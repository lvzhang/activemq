package com.mq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.TextMessage;

@Service
public class ConsumerService {
    @Resource(name ="jmsTemplate")
    private JmsTemplate jmsTemplate;
    @JmsListener(destination = "queueDestination")
    public TextMessage recive(Destination destination){
        TextMessage tm = (TextMessage)jmsTemplate.receive(destination);
        try {
            System.out.println("从队列" + destination.toString() + "收到了消息：\t"
                    + tm.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
        return tm;
    }
}
