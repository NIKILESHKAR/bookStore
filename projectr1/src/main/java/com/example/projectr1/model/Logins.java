package com.example.projectr1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Logins {
    @Id
    private int id;
    private String username;
    private String password;
    public Logins() {

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Logins(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }


     //ONE TO ONE CONNECTION
     @OneToOne(mappedBy = "logins", cascade = CascadeType.ALL)
     @JsonManagedReference 
     private Book book;
    
}
