package com.hescha.kafka.controller;

import com.hescha.kafka.model.Message;
import com.hescha.kafka.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/kafka")
@AllArgsConstructor
public class ThirdDataApplicationController {

    private final MessageService service;

    @PostMapping
    public ResponseEntity<Message> create(@RequestBody Message entity) {
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> read(@PathVariable Long id) {
        return ResponseEntity.ok(service.read(id));
    }

    @GetMapping
    public ResponseEntity<List<Message>> readAll() {
        return ResponseEntity.ok(service.readAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
