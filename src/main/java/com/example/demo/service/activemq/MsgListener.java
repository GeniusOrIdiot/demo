package com.example.demo.service.activemq;

import com.example.demo.service.activemq.config.QueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;

/**
 * MQ消息接收服务
 *
 * @author LiuYJ
 * @since 24/03/2018
 */
@Slf4j
@Component
public class MsgListener extends MessageListenerAdapter {

    @JmsListener(destination = QueueConstant.MSG_QUEUE, containerFactory = "jmsListenerContainerFactory")
    public void onMsg(String msg, Session session) throws JMSException {
        log.info("Received message: " + msg);
        session.commit();
    }
}
