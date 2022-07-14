package com.hescha.kafka.service;

import com.hescha.kafka.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class KafkaService {
    private final MessageService messageService;

    @KafkaListener(id = "myId", topics = "LOG_TOPIC")
    public void listen(String in) {
        System.out.println("readed: " + in);
        Message message = new Message();
        message.setDescription(in);
        message.setLocalDateTime(LocalDateTime.now());
        messageService.create(message);
    }
}
