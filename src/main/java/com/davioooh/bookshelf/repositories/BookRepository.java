package com.davioooh.bookshelf.repositories;

import com.davioooh.bookshelf.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
