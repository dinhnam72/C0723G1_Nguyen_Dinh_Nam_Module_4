package com.example.bt.service;

import com.example.bt.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(int id);
    boolean save(Book book);
}
