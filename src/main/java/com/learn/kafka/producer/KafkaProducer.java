package com.learn.kafka.producer;

import com.learn.kafka.constant.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by mukesh.shyamlal@gmail.com on 26/07/17.
 */
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String message) {
        System.out.println("Publishing Message : " + message);
        kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message);
    }

}
