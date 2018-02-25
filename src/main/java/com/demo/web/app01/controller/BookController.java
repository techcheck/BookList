package com.demo.web.app01.controller;

import com.demo.web.app01.model.Book;
import com.demo.web.app01.service.BookRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/list")
    public Iterable<Book> getBookList() {
        return bookRepository.findAll();
        //return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome to BookList Services";
    }

    @PostMapping("/add")
    public Iterable<Book> addBook(@RequestBody Book newBook) {
        bookRepository.save(newBook);
        return bookRepository.findAll();
    }

    @GetMapping("/hostInfo")
    public JSONObject getHostPodInfo() throws ParseException {
        Map<String, String> env =  System.getenv();
        JSONObject object = (JSONObject) new org.json.simple.parser.JSONParser().parse(JSONObject.toJSONString(env));
        return object;
    }

    @GetMapping("/createLogs")
    public String generateLogs(){
        String generatedString = RandomStringUtils.randomAlphabetic(50);
        System.out.println(generatedString);
        return "Logs Created";
    }

}
