package com.learn.kafka.consumer;

import com.learn.kafka.constant.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by mukesh.shyamlal@gmail.com on 26/07/17.
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = KafkaConstants.KAFKA_TOPIC
            , group = KafkaConstants.KAFKA_FIRST_CONSUMER_GROUP)
    public void consumerMessage(String message) {
        System.out.println("Received Messasge : " + message);
    }

}
