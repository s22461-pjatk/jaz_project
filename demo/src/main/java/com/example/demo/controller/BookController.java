package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createBook(@RequestBody Book book){ return bookService.createBook(book); }

    @RequestMapping(value = "read", method = RequestMethod.GET)
    public List<Book> readBooks(){ return bookService.readBooks();}

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public String updateBook(@RequestBody Book book) { return bookService.updateBook(book); }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String deleteBook(@RequestBody Book book) { return bookService.deleteBook(book); }

    @RequestMapping(value = "collection", method = RequestMethod.GET)
    public List<Book> booksCollection() { return bookService.readBooksCollection(); }


}