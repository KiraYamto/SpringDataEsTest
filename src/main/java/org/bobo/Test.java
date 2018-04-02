package org.bobo;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.auth.BasicCredentials;
import com.aliyuncs.auth.HmacSHA1Signer;
import com.aliyuncs.chatbot.model.v20171011.ChatRequest;
import com.aliyuncs.chatbot.model.v20171011.ChatResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.profile.DefaultProfile;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.*;

public class Test {

   // private static final String APP_KEY_ID = "LTAIRIC8k5GW7X9Q";
   // private static final String APP_KEY_SECRET = "x5EilAkciPQgBrjXhl9Fb28Yrux6JF";
  /*  private static final String APP_KEY_ID = "LTAI8I1GW9NRi5Kr";
    private static final String APP_KEY_SECRET = "fOcXAFinAzTBsBSiVO1aRYLgrcIlTp";*/
    private static final String APP_KEY_ID = "LTAIutuV7TZCuXyE";
    private static final String APP_KEY_SECRET = "f8JckOznmbvSWqTubSm1582KtdXSZX";

    private static final String CHAT_URL = "http://chatbot.cn-shanghai.aliyuncs.com";

    /**
     * 得到UTC时间，类型为字符串，格式为"yyyy-MM-dd HH:mm"<br />
     * 如果获取失败，返回null
     * @return
     */

    public static String getUTCTimeStr() {
        StringBuffer UTCTimeBuffer = new StringBuffer();
        // 1、取得本地时间：
        Calendar cal = Calendar.getInstance() ;
        // 2、取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(Calendar.YEAR);
        String month = (cal.get(Calendar.MONTH)+1)>9?(cal.get(Calendar.MONTH)+1)+"":"0"+(cal.get(Calendar.MONTH)+1);
        String day = cal.get(Calendar.DAY_OF_MONTH)>9?cal.get(Calendar.DAY_OF_MONTH)+"":"0"+cal.get(Calendar.DAY_OF_MONTH);
        String hour = cal.get(Calendar.HOUR_OF_DAY)>9?""+cal.get(Calendar.HOUR_OF_DAY):"0"+cal.get(Calendar.HOUR_OF_DAY);
        String minute = cal.get(Calendar.MINUTE)>9?""+cal.get(Calendar.MINUTE):"0"+cal.get(Calendar.MINUTE);
        String second = cal.get(Calendar.SECOND)>9?""+cal.get(Calendar.SECOND):"0"+cal.get(Calendar.SECOND);
        UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day) ;
        UTCTimeBuffer.append("T").append(hour).append(":").append(minute).append(":").append(second).append("Z") ;
        return UTCTimeBuffer.toString() ;

    }

    public static void main(String[] args) throws Exception{

        ChatRequest request = new ChatRequest();
        request.setInstanceId("chatbot-cn-4590j4a6h000rs");
        request.setUtterance("查询工单ID");
        request.setAcceptFormat(FormatType.JSON);
        doAction(request);



    }
    public static void doAction(ChatRequest request) {
        // 创建DefaultAcsClient实例并初始化

        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-shanghai",          // 地域ID
                APP_KEY_ID,      // RAM账号的AccessKey ID
                APP_KEY_SECRET); // RAM账号Access Key Secret

        IAcsClient client = new DefaultAcsClient(profile);
        try {
           HttpResponse response = client.doAction(request);
            System.out.println(response.getUrl());
            String  result = new String(response.getHttpContent());
            System.out.println(result);
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
    public static String getRequestUrl(String[] arr,Map<String,String> map)throws Exception{
        StringBuffer url = new StringBuffer(CHAT_URL+"?");
        for (int i = 0; i <arr.length ; i++) {
            url.append(arr[i]).append("=").append(URLEncoder.encode(map.get(arr[i]),"utf-8"));
            if(i<arr.length-1){
                url.append("&");
            }
        }
        System.out.println(url.toString());
        return url.toString();

    }
    public static String getSignToString(String[] arr,Map<String,String> paramMap)throws Exception{

        StringBuffer signToString = new StringBuffer("GET&%2F&");
        StringBuffer requestParam = new StringBuffer("");
        for (int i = 0; i < arr.length; i++) {
            try {
                if(!arr[i].equals("Signature")){
                    requestParam.append(arr[i]).append("=").append(paramMap.get(arr[i]));
                    signToString.append(arr[i]+URLEncoder.encode("=","utf-8")+URLEncoder.encode(paramMap.get(arr[i]),"utf-8"));
                }
            } catch (Exception e) {
                System.out.println("----"+arr[i]);
            }
            if(i<arr.length-1){
                signToString.append(URLEncoder.encode("&","utf-8"));
                requestParam.append("&");
            }
        }
        System.out.println(requestParam.toString());
        return signToString.toString();

    }
    public static String[] selectionSort(String[] arr){
        System.out.println("before:");
        sysoutArr(arr);
        long len = arr.length;
        int minIndex;
        String temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j].compareTo(arr[minIndex])<0) {     //寻找最小的数
                    minIndex = j;                 //将最小数的索引保存
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("after:");
        sysoutArr(arr);
        return arr;
    }
    public static void sysoutArr(String[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
    public static String byte2hex(byte[] b)
    {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString();
    }
}
