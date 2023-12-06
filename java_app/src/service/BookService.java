package service;

import model.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static model.constants.Query.*;

public class BookService {
    private Connection connection;

    public BookService(Connection connection) {
        this.connection = connection;
    }

    //    Creating book
    public void insertBook(Book book) throws SQLException {

        String sql = INSERT_BOOK;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getIsbn());
            statement.setInt(3, book.getQuantityInStock());
            statement.setDouble(4, book.getPrice());
            statement.setInt(5, book.getAuthorId());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Book created successfully.");
            } else {
                System.out.println("Failed to create book!");
            }
        }
    }

    //    Getting a book by its id
    public Book getBookById(int bookId) throws SQLException {

        String sql = GET_BOOK_BY_ID;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, bookId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    return mapResultSetToBook(resultSet);
                }
            }
        }
        return null;
    }

    // Mapping result
    private Book mapResultSetToBook(ResultSet resultSet) throws SQLException {

        Book book = new Book();
        book.setBookId(resultSet.getInt("book_id"));
        book.setTitle(resultSet.getString("title"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setQuantityInStock(resultSet.getInt("quantity_in_stock"));
        book.setPrice(resultSet.getDouble("price"));
        book.setAuthorId(resultSet.getInt("author_id"));
        return book;
    }

    //    Deleting
    public void deleteBook(int bookId, int status) throws SQLException {

        String sql = DELETE_BOOK;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bookId);
            statement.setInt(2, status);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book deleted.");
            } else {
                System.out.println("Book not found or status mismatch.");
            }
        }
    }
    //    Updating a book

    public void updateBook(Book updatedBook) throws SQLException {

        String sql = UPDATE_BOOK;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, updatedBook.getTitle());
            statement.setString(2, updatedBook.getIsbn());
            statement.setInt(3, updatedBook.getQuantityInStock());
            statement.setDouble(4, updatedBook.getPrice());
            statement.setInt(5, updatedBook.getAuthorId());
            statement.setInt(6, updatedBook.getStatus());
            statement.setInt(7, updatedBook.getBookId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("Failed to update book!");
            }
        }
    }

}

