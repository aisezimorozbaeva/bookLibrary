package com.example.practic.controller;

import com.example.practic.model.Book;
import com.example.practic.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;
    @GetMapping("/book_register")
    public String bookRegister(){
        return "register";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book> list = bookService.findAllBooks();
        return new ModelAndView("bookList","book",list);
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        bookService.save(b);
        return "redirect:/available_books";
    }
}