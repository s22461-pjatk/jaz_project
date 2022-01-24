package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Book {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int book_id;
    private String title;
    private String author;
    private int relase;

    public Book(){}

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public int getRelase() {
        return relase;
    }


    public void setRelase(int relase) {
        this.relase = relase;
    }


    @Override
    public String toString() {
        return "Student{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", relase='" + relase + '\'' +
                '}';
    }

}