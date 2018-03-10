package com.example.demo.java_code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright (c) 2017-present, Demart Corporation.
 * All rights reserved.
 * <p>
 * Created by MDMORY on 2017/10/17.
 * </p>
 */
public class RegexTest {
    public static void main(String[] args) {
        String content = "<ResultCode>0</ResultCode>\n" +
            "<ResultDesc>OK</ResultDesc>\n" +
            "<ThirdPartyTransID>464</ThirdPartyTransID>";
        String regex = "ID>(.*)</Th";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}
