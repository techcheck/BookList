package com.demo.web.app01.service;

import com.demo.web.app01.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
