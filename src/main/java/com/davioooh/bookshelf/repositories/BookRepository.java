package com.davioooh.bookshelf.repositories;

import com.davioooh.bookshelf.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
