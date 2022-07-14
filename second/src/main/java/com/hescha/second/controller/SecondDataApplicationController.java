package com.hescha.second.controller;

import com.hescha.second.model.Book;
import com.hescha.second.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/data")
@AllArgsConstructor
public class SecondDataApplicationController {

    private final BookService service;

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book entity) {
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> read(@PathVariable Long id) {
        return ResponseEntity.ok(service.read(id));
    }

    @GetMapping
    public ResponseEntity<List<Book>> readAll() {
        return ResponseEntity.ok(service.readAll());
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book entity) {
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
