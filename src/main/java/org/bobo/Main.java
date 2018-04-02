package org.bobo;
 import com.aliyuncs.profile.DefaultProfile;
 import com.aliyuncs.DefaultAcsClient;
 import com.aliyuncs.IAcsClient;
 import com.aliyuncs.exceptions.ClientException;
 import com.aliyuncs.exceptions.ServerException;
 import com.aliyuncs.ecs.model.v20140526.*;
 public class Main {
     private static final String APP_KEY_ID = "LTAIutuV7TZCuXyE";
     private static final String APP_KEY_SECRET = "f8JckOznmbvSWqTubSm1582KtdXSZX";
     public static void main(String[] args) {
         // 创建DefaultAcsClient实例并初始化

         DefaultProfile profile = DefaultProfile.getProfile(
             "cn-shanghai",          // 地域ID
                 APP_KEY_ID,      // RAM账号的AccessKey ID
                 APP_KEY_SECRET); // RAM账号Access Key Secret
         IAcsClient client = new DefaultAcsClient(profile);
         // 创建API请求并设置参数
         DescribeInstancesRequest request = new DescribeInstancesRequest();
         request.setPageSize(10);
         // 发起请求并处理应答或异常
         DescribeInstancesResponse response;
         try {
             response = client.getAcsResponse(request);
             for (DescribeInstancesResponse.Instance instance:response.getInstances()) {
                 System.out.println(instance.getPublicIpAddress());
             }
         } catch (ServerException e) {
             e.printStackTrace();
         } catch (ClientException e) {
             e.printStackTrace();
         }
     }
 }