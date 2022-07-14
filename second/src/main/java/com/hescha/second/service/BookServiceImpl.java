package com.hescha.second.service;

import com.hescha.second.model.Book;
import com.hescha.second.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public Book create(Book entity) {
        return repository.create(entity);
    }

    @Override
    public Book read(Long id) {
        return repository.read(id);
    }

    @Override
    public List<Book> readAll() {
        return repository.readAll();
    }

    @Override
    public Book update(Book entity) {
        return repository.update(entity);
    }

    @Override
    public void delete(Long id) {
        read(id);
        repository.delete(id);
    }
}
