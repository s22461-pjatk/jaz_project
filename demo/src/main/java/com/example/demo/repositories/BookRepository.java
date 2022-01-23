package com.example.demo.repositories;
import com.example.demo.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public boolean existsById(int book_id);

    @Query("select max(s.book_id) from book s")
    public default Integer findMaxId() {
        return null;
    }

}