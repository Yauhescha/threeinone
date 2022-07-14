package com.hescha.threeinone.repository;

import com.hescha.threeinone.model.MessageFromUser;

import java.util.List;

public interface MessageFromUserRepository {

    boolean create(MessageFromUser entity);

    MessageFromUser read(Long id);

    List<MessageFromUser> readAll();

    boolean update(MessageFromUser entity);

    void delete(Long id);

    boolean answer(Long id);
}
