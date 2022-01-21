package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> readBooks(){
        return bookRepository.findAll();
    }


    @Transactional
    public String createBook(Book book){
        try {
            if (!bookRepository.existsById(book.getBook_id())){
                book.setBook_id(null == bookRepository.findMaxId()? book.getBook_id() : bookRepository.findMaxId() + 1);
                bookRepository.save(book);
                return "book record created successfully.";
            }else {
                return "book already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }



    @Transactional
    public String deleteBook(Book book) {
        if (bookRepository.existsById(book.getBook_id())) {
            try {
                List<Book> books = bookRepository.findById(book.getBook_id());
                books.stream().forEach(s -> {
                    bookRepository.delete(s);
                });
                return "book record deleted successfully.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "book does not exist";
        }
    }
}



/**
 @Transactional
 public String updateBook(Book book){
 if (bookRepository.existsById(book.getBook_id())){
 try {
 List<Book> books = bookRepository.findById(book.getBook_id());
 books.stream().forEach(s -> {
 Book bookToBeUpdate = bookRepository.findById(s.getBook_id()).get();
 bookToBeUpdate.setTitle(book.getTitle());
 bookToBeUpdate.setAuthor(book.getAuthor());
 bookToBeUpdate.setRelase(book.getRelase());
 bookRepository.save(bookToBeUpdate);
 });
 return "book record updated.";
 }catch (Exception e){
 throw e;
 }
 }else {
 return "book does not exists in the database.";
 }
 }
 **/