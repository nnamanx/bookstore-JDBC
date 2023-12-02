package com.nnamanx.bookstorejdbc.repository;

import com.nnamanx.bookstorejdbc.model.entity.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAll(); // getting all books
    Book findById(Long id); // finding book by its id
    void save(Book book); // creating new book
    void update(Book book); // updating book info
    void delete(Long id); // deleting a book (not deleting but changing the status)
}
