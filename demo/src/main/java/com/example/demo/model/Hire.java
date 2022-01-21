package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hire_id;
    private int book_id;
    private int reader_id;
    private String date_hire;
    private String date_delivery;


    public int getHire_id() {
        return hire_id;
    }

    public void setHire_id(int hire_id) {
        this.hire_id = hire_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public String getDate_hire() {
        return date_hire;
    }

    public void setDate_hire(String date_hire) {
        this.date_hire = date_hire;
    }

    public String getDate_delivery() {
        return date_delivery;
    }

    public void setDate_delivery(String date_delivery) {
        this.date_delivery = date_delivery;
    }
}


/**
 *     public Hire() {}
 *     public Hire(int idBook, int idReader) {
 *         this.idBook = idBook;
 *         this.idReader = idReader;
 *
 *     }
 */