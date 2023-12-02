package com.nnamanx.bookstorejdbc.repository.impl;

import com.nnamanx.bookstorejdbc.model.entity.Book;
import com.nnamanx.bookstorejdbc.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book findById(Long id) {
        return null;
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Long id) {

    }
}

