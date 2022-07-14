package com.hescha.kafka.service;

import com.hescha.kafka.model.Message;

import java.util.List;

public interface MessageService {
    Message create(Message entity);

    Message read(Long id);

    List<Message> readAll();

    void delete(Long id);
}
