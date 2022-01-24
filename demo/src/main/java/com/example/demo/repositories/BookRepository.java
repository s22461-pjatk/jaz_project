package com.example.demo.repositories;
import com.example.demo.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public boolean existsById(int book_id);


    @Query(value = "select max(s.book_id) from book s", nativeQuery = true)
    public Integer findMaxId();


    @Query(value = "select * from book where title like %?1% and author like %?2%", nativeQuery = true)
    public List<Book> searchBook(String title, String author);


}