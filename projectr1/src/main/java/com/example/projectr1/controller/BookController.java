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

import com.example.projectr1.model.Book;
import com.example.projectr1.service.BookService;
@RestController
public class BookController {
    @Autowired
    BookService ms;
    @PostMapping("/postdetails")
    public ResponseEntity<Book>addelements(@RequestBody Book m)
    {
        Book mm=ms.create(m);
        return new ResponseEntity<>(mm,HttpStatus.CREATED);
    }
    @GetMapping("/getdetails")
    public ResponseEntity<List<Book>> showinfo()
    {
        List<Book>obj=ms.getAll();
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @GetMapping("/getdetailsbyid")
    public ResponseEntity<Book> getById(@PathVariable Integer bookId)
    {
        Book obj=ms.getMe(bookId);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/putdetails/{bookId}")
    public ResponseEntity<Book> putMethodName(@PathVariable("bookId") int id, @RequestBody Book m) {
        if(ms.updateDetails(id,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/deletedetails/{bookId}")
    public ResponseEntity<Boolean> delete(@PathVariable("bookId") int bookId)
    {
        if(ms.deleteuser(bookId) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    //pagination and sorting 
    
    @GetMapping("/api/patient/{offset}/{pagesize}/{field}")
    public List<Book> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return ms.getsort(offset,pagesize,field);
    }
    @GetMapping("/api/patient/sortBy/{field}")
    public List<Book> g(@PathVariable String field)
    {
        return ms.sort(field);
    }
    // SELECT QUERY METHOD

    @GetMapping("/rating")
    public List<Book> getDetailsbyStatus() {
        return ms.getDetailsbyStatus();
    }
}