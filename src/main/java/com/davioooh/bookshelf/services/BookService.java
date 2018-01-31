package com.davioooh.bookshelf.services;

import com.davioooh.bookshelf.domain.Book;
import com.davioooh.bookshelf.repositories.BookRepository;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return ImmutableList.copyOf(bookRepository.findAll());
    }

    public Book getById(Integer id) {
        return bookRepository.findOne(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Integer id) {
        bookRepository.delete(id);
    }

}
