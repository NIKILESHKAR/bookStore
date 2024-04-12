package com.example.projectr1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.projectr1.model.Book;

public interface BookRepo extends JpaRepository<Book,Integer>{
    @Query("SELECT f FROM Book f WHERE f.rating>3")
    List<Book> findByStatus();

    @Query("SELECT b FROM Book b WHERE b.book_id=:2")
    List<Book>findByidBooks();
}
