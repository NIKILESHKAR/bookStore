package com.example.projectr1.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orderDetails;

    @ManyToOne
    @JoinColumn(name = "login_id")
    @JsonIgnore
    private Logins login;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;

    // Constructors, getters, and setters
    public Order() {
    }

    public Order(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Logins getUser() {
        return login;
    }

    public void setUser(Logins login) {
        this.login = login;
    }
}