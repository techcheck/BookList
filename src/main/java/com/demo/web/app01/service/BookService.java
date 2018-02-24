package com.demo.web.app01.service;

import com.demo.web.app01.model.Book;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookService {

    private static List<Book> bookList = new ArrayList<Book>();

    static {
        Book book1 = new Book(1, "Docker Reference", "John Doe", 15.99f);
        Book book2 = new Book(2, "Kubernetes Reference", "Jack Ryan", 34.99f);
        Book book3 = new Book(3, "Networking Refresher", "T'chala D'mar", 65.99f);
        Book book4 = new Book(4, "Spring and Pivotal", "Atomic Brunette", 123.99f);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public List<Book> addBook(Book book) {
        int newId = bookList.size() + 1;
        book.setId(newId);
        bookList.add(book);
        return bookList;
    }

    public Book getBookById(int id) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

}
