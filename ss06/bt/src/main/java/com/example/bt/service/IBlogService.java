package com.example.bt.service;

import com.example.bt.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void add (Blog blog);
    Blog findById(int id);
    void update(Blog blog);
    void remove(int id);

}
