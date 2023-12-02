package com.nnamanx.bookstorejdbc.query;

public class BookQueryList {

    public static final String INSERT_BOOK = "INSERT INTO book(title, author, year) VALUES(?, ?, ?);";
    public static final String SELECT_BOOK_BY_ID = "SELECT * FROM book WHERE id=?";
    public static final String SELECT_ALL_BOOKS = "SELECT * FROM book;";
    public static final String DELETE_BOOK = "DELETE from book WHERE id=?;";
    public static final String UPDATE_BOOK = "UPDATE book SET title=?, author=?, year=? WHERE id=?;";


}
