package com.example.demo.service.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * MQ队列bean
 *
 * @author LiuYJ
 * @since 24/03/2018
 */
@Configuration
@EnableJms
public class ActiveMQConfig {
    @Bean
    public Queue msgQueue() {
        return new ActiveMQQueue(QueueConstant.MSG_QUEUE);
    }

}
