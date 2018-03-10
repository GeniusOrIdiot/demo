package com.example.demo.java_code;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2017-present, Demart Corporation.
 * All rights reserved.
 * <p>
 * Created by MDMORY on 2017/10/12.
 * </p>
 */
public class XmlrpcSendService {
    
    public static void main(String[] args) throws Exception {
        // create configuration
        long start = System.currentTimeMillis();
        
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://prs.advantasms.com/sdp_apps/services/thirdparty/sdp_server.php"));
        config.setEnabledForExtensions(true);
        config.setConnectionTimeout(60 * 1000);
        config.setReplyTimeout(60 * 1000);
        
        XmlRpcClient client = new XmlRpcClient();
        
        // use Commons HttpClient as transport
        client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
        // set configuration
        client.setConfig(config);
        //credentials
        Map<String, Object> credentials = new HashMap<>();
        credentials.put("USERNAME", "demart");
        credentials.put("PASSWORD", "demart1234");
        
//        //body
//        Map<String, Object> body = new HashMap<>();
//        body.put("CHANNELID", "60");
//        body.put("MSISDN", "254796756990"); // receiver
//        body.put("SOURCEADDR", "Demart");   // senderId
//        body.put("MESSAGE", "TEST MESSAGE");
//
//        Object[] params = new Object[]{credentials, body};
//        HashMap result = (HashMap) client.execute("ADVANTA.sendSms", params);
//        System.out.println("Response: " + result);
//        long end = System.currentTimeMillis();
//        long microseconds = (end - start);
//        //System.out.println(end);
//        System.out.println("TAT: " + microseconds + " ms");

        Map<String, Object> dlr = new HashMap<>();
        dlr.put("REFERENCEID", "REF1524408163");
        Object[] params = new Object[]{credentials, dlr};
        HashMap report = (HashMap) client.execute("ADVANTA.getDlr", params);
        System.out.println("Delivery report:" + report);
    }
}
