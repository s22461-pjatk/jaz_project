package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


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

    @RequestMapping(value = "hires", method = RequestMethod.GET)
    public List<Book> hiresBooks() { return bookService.readHiresBooks(); }

    @RequestMapping(value = "search/{title}/{author}", method = RequestMethod.GET)
    public List<Book> hiresBooks(@PathVariable("title") String title, @PathVariable("author") String author) {
        return bookService.searchBooksGet(title, author); }


    @RequestMapping(value = "search", method = RequestMethod.POST)
    public List<Book> hiresBooks(@RequestBody Book book) {
        return bookService.searchBooksPost(book); }

}