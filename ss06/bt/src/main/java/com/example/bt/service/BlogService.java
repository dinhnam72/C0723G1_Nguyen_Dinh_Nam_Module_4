package com.example.bt.service;

import com.example.bt.model.Blog;
import com.example.bt.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable, String searchName,int categoryId) {
        if (categoryId==0){
            return blogRepository.searchAll(pageable,"%"+searchName+"%",categoryId);
        }else {
            return blogRepository.search(pageable,"%"+searchName+"%",categoryId);
        }

    }

    @Override
    public void add(Blog blog) {

        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
       return blogRepository.findById(id).get();
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.delete(findById(id));
    }
}
