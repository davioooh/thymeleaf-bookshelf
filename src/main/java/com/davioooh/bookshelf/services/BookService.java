package com.davioooh.bookshelf.services;

import com.davioooh.bookshelf.domain.Book;
import com.davioooh.bookshelf.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book getByID(Integer id){
        return bookRepository.findOne(id);
    }

}
