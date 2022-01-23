package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Hire {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int hire_id;
    private int book_id;
    private int index_number;
    private Date date_hire;
    private Date date_delivery;

    public int getIndex_number() {
        return index_number;
    }

    public void setIndex_number(int index_number) {
        this.index_number = index_number;
    }

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


    public Date getDate_hire() {
        return date_hire;
    }

    public void setDate_hire(Date date_hire) {
        this.date_hire = date_hire;
    }

    public Date getDate_delivery() {
        return date_delivery;
    }

    public void setDate_delivery(Date date_delivery) {
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