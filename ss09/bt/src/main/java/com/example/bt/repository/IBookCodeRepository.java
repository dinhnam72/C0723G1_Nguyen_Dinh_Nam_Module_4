package com.example.bt.repository;

import com.example.bt.model.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookCodeRepository extends JpaRepository<BookCode,Integer> {
    @Query(value = "select * from book_code where bookCode = :bookCode",nativeQuery = true)
    BookCode findByBookCode(@Param("bookCode") int bookCode);
}
