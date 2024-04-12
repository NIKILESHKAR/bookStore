package com.example.projectr1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectr1.model.Logins;
import com.example.projectr1.service.LoginService;


@RestController
public class LoginController {
    @Autowired
    LoginService ps;
    @PostMapping("/api/login")
    public ResponseEntity<Logins> add(@RequestBody Logins p) {
        Logins pro = ps.create(p);
        return new ResponseEntity<>(pro, HttpStatus.CREATED);
    }

    @GetMapping("/api/login")
    public ResponseEntity<List<Logins>> showdetails() {
        return new ResponseEntity<>(ps.getalldetail(), HttpStatus.OK);
    }
    @PutMapping("/putdata/{username}")
        public ResponseEntity<Logins>putMethodName(@PathVariable("username")String username,@RequestBody Logins p)
        {
            if(ps.updateDetails(username,p) == true)
            {
                return new ResponseEntity<>(p,HttpStatus.OK);
            }
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        @DeleteMapping("/delete/{username}")
        public ResponseEntity<Boolean>delete(@PathVariable("username")String username)
        {
            if(ps.delete(username) == true)
            {
                return new ResponseEntity<>(true,HttpStatus.OK);
            }
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    
}
