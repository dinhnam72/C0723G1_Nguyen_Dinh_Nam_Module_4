package com.example.bt.controller;

import com.example.bt.model.Book;
import com.example.bt.model.BookCode;
import com.example.bt.service.IBookCodeService;
import com.example.bt.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookCodeService bookCodeService;

    @GetMapping("")
    public String showList(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList",bookList);
        model.addAttribute("book", new Book());
        return "list";
    }

    @GetMapping("/borrow")
    public String borrowBook(@ModelAttribute Book book){
//        book.setAmount(book.getAmount()-1);
////        BookCode bookCode = new BookCode(bookCodeService.randomCode(), book);
//        bookService.save(book);
//        bookCodeService.save(bookCode);
        return "redirect:/home";
    }

    @GetMapping("/give-back")
    public String giveBackBook(@RequestParam int bookCode, RedirectAttributes redirectAttributes){
        System.out.println(bookCode);
        int bookC = bookCodeService.findByBookCode(bookCode);
        Book book = bookService.findById(bookC);
        book.setAmount(book.getAmount()+1);
        bookService.save(book);
        return "redirect:/home";
    }
}
