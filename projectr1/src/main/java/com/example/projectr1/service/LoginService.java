package com.example.projectr1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectr1.model.Logins;
import com.example.projectr1.repository.LoginsRepo;


@Service
public class LoginService {
    @Autowired
    LoginsRepo pr;

    public Logins create(Logins p) {
        return pr.save(p);
    }

    public List<Logins> getalldetail() {
        return pr.findAll();
    }
    public Logins getUserByName(String username)
    {
        return pr.findById(username).orElse(null);
    }
    public boolean updateDetails(String username,Logins p)
    {
        if(this.getUserByName(username)==null)
        {
            return false;
        }
        try{
            pr.save(p);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean delete(String username)
    {
        if(this.getUserByName(username) == null)
        {
            return false;
        }
        pr.deleteById(username);
        return true;
    }
    
}
