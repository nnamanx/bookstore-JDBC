package impl;


import config.DatabaseConnection;
import model.entity.Book;
import service.BookService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl {

    private Connection conn;

    public BookServiceImpl(Connection conn) {
        this.conn = conn;
    }

    public void performBookOperations() {
        BookService bookService = new BookService(conn);

        try {

            // Insert Book
            Book newBook = new Book();

            newBook.setTitle("Crime and Punishment");
            newBook.setIsbn("34748290");
            newBook.setQuantityInStock(10);
            newBook.setPrice(15);
            newBook.setAuthorId(1);

            bookService.insertBook(newBook);

            // Retrieve Book by ID
            Book retrievedBook = bookService.getBookById(1);
            System.out.println("Retrieved Book: " + retrievedBook);

            // Update Book
            retrievedBook.setTitle("Updated Crime and Punishment");
            bookService.updateBook(retrievedBook);

            // Delete Book
            bookService.deleteBook(1, 1);

//            List<Book> allBooks = bookService.getAllBooks();
//            System.out.println("All Books: " + allBooks);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
