package com.example.bt.controller;

import com.example.bt.dto.BlogDto;
import com.example.bt.model.Blog;
import com.example.bt.service.IBlogService;
import com.example.bt.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api-blog")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<Page<Blog>> getList(@PageableDefault(page = 0,size = 2) Pageable pageable,
                          @RequestParam(defaultValue = "") String searchName){
        Page<Blog> blogPage = blogService.search(pageable,searchName);
        if (blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.CREATED);
    }

//    @GetMapping("")
//    public ResponseEntity<List<Blog>> getList() {
//        List<Blog> blogList = blogService.findAll();
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getListByCategory(@PathVariable int id) {
        List<Blog> blogList = blogService.findAll(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(blogList, HttpStatus.CREATED);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<?> detail(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
