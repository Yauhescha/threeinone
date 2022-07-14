package com.hescha.second.service;

import com.hescha.second.model.Book;

import java.util.List;

public interface BookService {
    Book create(Book entity);

    Book read(Long id);

    List<Book> readAll();

    Book update(Book entity);

    void delete(Long id);
}
