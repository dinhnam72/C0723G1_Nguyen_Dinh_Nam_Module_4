package com.example.bt.service;

import com.example.bt.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> search(Pageable pageable,String searchName);
    List<Blog> findAll(int categoryId);
    List<Blog> findAll();
    void add (Blog blog);
    Blog findById(int id);
    void update(Blog blog);
    void remove(int id);

}
