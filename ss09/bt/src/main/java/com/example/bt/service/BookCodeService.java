package com.example.bt.service;

import com.example.bt.model.BookCode;
import com.example.bt.repository.IBookCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCodeService implements IBookCodeService {
    @Autowired
    private IBookCodeRepository bookCodeRepository;
    @Override
    public int randomCode() {

        return (int) Math.round(Math.random()*90000+10000);
    }

    @Override
    public int findByBookCode(int bookCode) {
        BookCode bookCode1 = bookCodeRepository.findByBookCode(bookCode);
        return bookCode1.getId();
    }

    @Override
    public boolean save(BookCode bookCode) {
        try {
            bookCodeRepository.save(bookCode);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
