package com.learn.kafka.producer;

import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by mukesh.shyamlal@gmail.com on 26/07/17.
 */
@Component
public class ScheduleKafkaProducer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Observable<String> stringObservable = Observable.just("One", "Two"
                , "Three", "Four", "Five");
        stringObservable.delay(10, TimeUnit.SECONDS)
                .repeat().subscribe(kafkaProducer::publishMessage);
        System.out.println("Scheduled the KafkaProducer. ");
    }
}
