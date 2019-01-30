package com.sauzny.jkitchen_note.db.rabbitmq;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    
    @PostConstruct
    public void init(){
        System.out.println("Producer init...");
    }
    
    @Autowired
    private AmqpTemplate amqpTemplate;

    private final static Logger LOGGER = Logger.getLogger(Producer.class);
    
    public void sendDataToQueue(String queueKey, Object object) {
        try {
            //System.out.println("发送消息 开始");
            //System.out.println("queueKey " + queueKey);
            //System.out.println("object " + object);
            amqpTemplate.convertAndSend(queueKey, object);
            //System.out.println("发送消息 结束");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
