package com.example.projectr1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.example.projectr1.model.Book;
import com.example.projectr1.repository.BookRepo;


@Service
public class BookService {
    @Autowired
    BookRepo lr;
    public Book create(Book ll)
    {
        return lr.save(ll);
    } 
    public List<Book> getAll()
    {
        return lr.findAll();
    }
    public Book getMe(int bookId)
    {
        return lr.findById(bookId).orElse(null);
    }
    public boolean updateDetails(int bookId,Book mm)
        {
            if(this.getMe(bookId)==null)
            {
                return false;
            }
            try{
                lr.save(mm);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteuser(int bookId)
        {
            if(this.getMe(bookId) == null)
            {
                return false;
            }
            lr.deleteById(bookId);
            return true;
        }

//pagination and sorting
public List<Book> getsort(int pageNumber,int pageSize,String field)
{          return lr.findAll(PageRequest.of(pageNumber, pageSize)
      .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
}
public List<Book> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return lr.findAll(sort);
    }


 //SELECT QUERY FUNCTION 
 public List <Book> getDetailsbyStatus(){
    return lr.findByStatus();
}

    
}
