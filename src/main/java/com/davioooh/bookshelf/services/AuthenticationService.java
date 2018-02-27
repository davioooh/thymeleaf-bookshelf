package com.davioooh.bookshelf.services;

import com.davioooh.bookshelf.domain.User;
import com.davioooh.bookshelf.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        return new BookshelfUser(
                user.getId()
                , user.getUsername()
                , user.getPassword()
                , Collections.singleton(new SimpleGrantedAuthority("user")));
    }

    static class BookshelfUser extends org.springframework.security.core.userdetails.User {

        private long id;

        public BookshelfUser(long userId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
            super(username, password, authorities);
            this.id = userId;
        }

        public long getId() {
            return id;
        }
    }
}