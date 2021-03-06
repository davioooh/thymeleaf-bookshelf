package com.davioooh.bookshelf.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // ... per H2 console
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                //
                .authorizeRequests()
                .antMatchers("/css/**", "/font-awesome-*/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(
                        "/books/new",
                        "/books/**/edit",
                        "/books/save",
                        "/books/**/delete").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }
}