package com.example.practic.service;

import com.example.practic.model.Book;

import java.util.List;

public interface BookService {
    void save(Book book);
    void deleteById(Long id);
    List<Book> findAllBooks();

}
