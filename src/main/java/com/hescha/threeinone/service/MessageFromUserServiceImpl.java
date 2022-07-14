package com.hescha.threeinone.service;

import com.hescha.threeinone.model.MessageFromUser;
import com.hescha.threeinone.repository.MessageFromUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MessageFromUserServiceImpl implements MessageFromUserService {

    private final MessageFromUserRepository repository;

    @Override
    public boolean create(MessageFromUser entity) {
        return repository.create(entity);
    }

    @Override
    public MessageFromUser read(Long id) {
        return repository.read(id);
    }

    @Override
    public List<MessageFromUser> readAll() {
        return repository.readAll();
    }

    @Override
    public boolean update(MessageFromUser entity) {
        return repository.update(entity);
    }

    @Override
    public void delete(Long id) {
        read(id);
        repository.delete(id);
    }

    @Override
    public boolean answer(Long id) {
        return repository.answer(id);
    }
}
