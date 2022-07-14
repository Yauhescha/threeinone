package com.hescha.threeinone.controller;

import com.hescha.threeinone.model.MessageFromUser;
import com.hescha.threeinone.service.MessageFromUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/first2")
@AllArgsConstructor
public class FirstDataApplicationController {

    private final MessageFromUserService service;

    @PostMapping
    public ResponseEntity<Boolean> create(MessageFromUser entity) {
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageFromUser> read(@PathVariable Long id) {
        return ResponseEntity.ok(service.read(id));
    }

    @GetMapping
    public ResponseEntity<List<MessageFromUser>> readAll() {
        return ResponseEntity.ok(service.readAll());
    }

    @PutMapping
    public ResponseEntity<Boolean> update(MessageFromUser entity) {
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/answer/{id}")
    public ResponseEntity<Boolean> answer(@PathVariable Long id) {
        return ResponseEntity.ok(service.answer(id));
    }
}
