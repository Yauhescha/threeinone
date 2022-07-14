package com.hescha.second.repository;

import com.hescha.second.model.Book;

import java.util.List;

public interface BookRepository {

    Book create(Book entity);

    Book read(Long id);

    List<Book> readAll();

    Book update(Book entity);

    void delete(Long id);
}
