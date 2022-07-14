package com.hescha.threeinone.controller;

import com.hescha.threeinone.modelnew.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/first3")
public class FirstApplicationSecondDataController {


    @Value("${server.second.address}")
    private String host;

    @Value("${server.second.port}")
    private String port;

    @PostMapping
    public ResponseEntity<Book> create(Book entity) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = host + ":" + port + "/data";
        HttpEntity<Book> request = new HttpEntity<>(entity);

        return restTemplate.postForEntity(fooResourceUrl, request, Book.class);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> read(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = host + ":" + port + "/data/" + id;

        return restTemplate.getForEntity(fooResourceUrl, Book.class);
    }

    @GetMapping
    public ResponseEntity<List<Book>> readAll() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = host + ":" + port + "/data/";

        ResponseEntity<List<Book>> rateResponse =
                restTemplate.exchange(fooResourceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                });
        List<Book> books = rateResponse.getBody();
        return ResponseEntity.ok(books);
    }

    @PutMapping
    public ResponseEntity<Book> update(Book entity) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = host + ":" + port + "/data";

        HttpEntity<Book> request = new HttpEntity<>(entity);

        ResponseEntity<Book> rateResponse =
                restTemplate.exchange(fooResourceUrl, HttpMethod.PUT, request, Book.class);
        Book book = rateResponse.getBody();
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = host + ":" + port + "/data/" + id;

        restTemplate.delete(fooResourceUrl);
        return ResponseEntity.ok().build();
    }
}
