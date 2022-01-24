package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RequestMapping("api/collection")
@RestController
public class BookCollectionController {

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "read", method = RequestMethod.GET)
    public List<Book> booksCollection() { return bookService.readBooksCollection(); }

    @RequestMapping(value = "hires", method = RequestMethod.GET)
    public List<Book> hiresBooks() { return bookService.readHiresBooks(); }

    @RequestMapping(value = "search/{title}/{author}", method = RequestMethod.GET)
    public List<Book> searchBooks(@PathVariable("title") String title, @PathVariable("author") String author) {
        return bookService.searchBooksGet(title, author); }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public List<Book> hiresBooks(@RequestBody Book book) {
        return bookService.searchBooksPost(book); }

    @RequestMapping(value = "collection/by/title", method = RequestMethod.GET)
    public List<List> collectionByTitle(){ return bookService.readCollectionByTitle();}

}