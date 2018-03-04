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
        return "welcome to BookList Services..!! This version containers addition services to get Container / POD details for LOAD BALANCING Test";
    }

    @PostMapping("/add")
    public List<Book> addBook(@RequestBody Book newBook) {
        return bookService.addBook(newBook);
    }

    @GetMapping("/hostInfoDetails")
    public JSONObject getHostPodInfo() throws ParseException {
        Map<String, String> env =  System.getenv();
        JSONObject object = (JSONObject) new org.json.simple.parser.JSONParser().parse(JSONObject.toJSONString(env));
        return object;
    }

    @GetMapping("/host")
    public String getHostInfo(){
        Map<String, String> env =  System.getenv();
        for(String key: env.keySet()){
            if(key.equalsIgnoreCase("HOSTNAME")){
                return env.get(key);
            }else{
                return System.getenv("HOSTNAME");
            }

        }
        return "HostName is not Set";
    }

    @GetMapping("/createLogs")
    public String generateLogs(){
        String generatedString = RandomStringUtils.randomAlphabetic(50);
        System.out.println(generatedString);
        return "Logs Created";
    }

}
