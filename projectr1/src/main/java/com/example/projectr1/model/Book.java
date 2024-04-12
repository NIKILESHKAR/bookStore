package com.example.projectr1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Book {
    @Id
    int bookId;
    String name,authorName;
    int authorId,rating;

    
    @OneToOne
    @JoinColumn(name="logins_username")
    @JsonBackReference
    private Logins logins;


    
    public Book() {
    }


    public Book(int bookId, String name, String authorName, int authorId, int rating) {
        this.bookId = bookId;
        this.name = name;
        this.authorName = authorName;
        this.authorId = authorId;
        this.rating = rating;
    }


    public int getBookId() {
        return bookId;
    }


    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAuthorName() {
        return authorName;
    }


    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


    public int getAuthorId() {
        return authorId;
    }


    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }


    public int getRating() {
        return rating;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }


    public Logins getLogins() {
        return logins;
    }


    public void setLogins(Logins logins) {
        this.logins = logins;
    }

    
    

    
    
    
}
