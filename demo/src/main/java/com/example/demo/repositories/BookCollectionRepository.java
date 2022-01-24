package com.example.demo.repositories;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookCollectionRepository extends JpaRepository<Book, Integer> {

    public boolean existsById(int book_id);

    @Query(value = "select * from book where book_id in (select book_id from hire)", nativeQuery = true)
    public List<Book> hireBooks();

    @Query(value = "select * from book where book_id not in (select book_id from hire)", nativeQuery = true)
    public List<Book> booksInCollection();

    @Query(value = "select * from book where book_id not in (select book_id from hire) and title like %?1", nativeQuery = true)
    public List<Book> booksInCollectionById(String title);

}
