package com.example.bt.repository;

import com.example.bt.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where title like :searchName and category_id!= :categoryId",nativeQuery = true)
    Page<Blog> searchAll(Pageable pageable, @Param("searchName") String name, @Param("categoryId") int categoryId);
    @Query(value = "select * from blog where title like :searchName and category_id= :categoryId",nativeQuery = true)
    Page<Blog> search(Pageable pageable, @Param("searchName") String name, @Param("categoryId") int categoryId);

}
