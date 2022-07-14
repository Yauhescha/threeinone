package com.hescha.kafka.service;

import com.hescha.kafka.model.Message;
import com.hescha.kafka.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;

    @Override
    public Message create(Message entity) {
        return repository.save(entity);
    }

    @Override
    public Message read(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Message> readAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
