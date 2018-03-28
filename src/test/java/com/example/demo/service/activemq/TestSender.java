package com.example.demo.service.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiuYJ
 * @since 24/03/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSender {
    @Autowired
    private MsgSender msgSender;

    @Test
    public void testSendMsg() {
        int i = 0;
        do {
            msgSender.sendMsg((++i) + ": 你以为的你以为就是你以为？");
        } while (i < 3);
    }
}
