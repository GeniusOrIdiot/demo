package com.example.demo.service.activemq;

import com.example.demo.service.activemq.config.QueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * ActiveMq 消息发送服务
 *
 * @author LiuYJ
 * @since 24/03/2018
 */
@Slf4j
@Component
public class MsgSender {
    private JmsTemplate jmsTemplate;

    public MsgSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMsg(String msg) {
        jmsTemplate.convertAndSend(QueueConstant.MSG_QUEUE, msg);
    }
}
