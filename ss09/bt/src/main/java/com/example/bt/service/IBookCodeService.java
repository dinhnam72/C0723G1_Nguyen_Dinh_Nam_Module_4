package com.example.bt.service;

import com.example.bt.model.BookCode;

public interface IBookCodeService  {
    int randomCode();
    int findByBookCode(int bookCode);
    boolean save(BookCode bookCode);
}
