package com.demo.web.app01.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String authorName;
    private float price;

    public Book(String name, String authorName, float price) {
        this.name = name;
        this.authorName = authorName;
        this.price = price;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id == book.id &&
                Float.compare(book.price, price) == 0 &&
                Objects.equals(name, book.name) &&
                Objects.equals(authorName, book.authorName);
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%d, name='%s', authorName='%s', price=%f]",
                id, name, authorName, price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, authorName, price);
    }
}
