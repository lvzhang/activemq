package com.mq.listen;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueMessageListener2 implements MessageListener{
    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage)message;
        try {
            System.out.println("QueueMessageListener监听到了文本消息222222222：\t"
                    + tm.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
