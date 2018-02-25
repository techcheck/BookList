package com.demo.web.app01.controller;

import com.demo.web.app01.model.Book;
import com.demo.web.app01.service.BookService;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
