package com.example.projectr1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectr1.model.Logins;

public interface LoginsRepo extends JpaRepository<Logins,String>{
    
}
