package com.demo.web.app01.controller;

import com.demo.web.app01.model.Book;
import com.demo.web.app01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/list")
    public List<Book> getBookList() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome to BookList Services";
    }

    @PostMapping("/add")
    public List<Book> addBook(@RequestBody Book newBook) {
        return bookService.addBook(newBook);
    }

}
