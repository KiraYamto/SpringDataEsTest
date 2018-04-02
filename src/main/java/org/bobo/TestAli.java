package org.bobo;

import com.aliyuncs.auth.BasicCredentials;
import com.aliyuncs.auth.HmacSHA1Signer;
import com.aliyuncs.chatbot.model.v20171011.ChatRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestAli {
    private static final String APP_KEY_ID = "LTAI8I1GW9NRi5Kr";
    private static final String APP_KEY_SECRET = "fOcXAFinAzTBsBSiVO1aRYLgrcIlTp";
    public static void main(String[] args) {

        ChatRequest request = new ChatRequest();
        request.setInstanceId("chatbot-cn-4590j4a6h000rs");
        request.setUtterance("what is this!!");
    }
}
