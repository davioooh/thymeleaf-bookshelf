package com.davioooh.bookshelf.repositories;

import com.davioooh.bookshelf.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
