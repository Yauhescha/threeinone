package com.hescha.kafka.repository;

import com.hescha.kafka.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

//    Message create(Message entity);
//
//    Message read(Long id);
//
//    List<Message> readAll();
//
//    void delete(Long id);
}
