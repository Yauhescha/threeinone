package com.hescha.threeinone.kafkalog;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.hescha.threeinone.ThreeinoneApplication.LOG_TOPIC;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    void send(String value) {
        System.out.println("sending logs...");
        kafkaTemplate.send(LOG_TOPIC, value);
    }
}
