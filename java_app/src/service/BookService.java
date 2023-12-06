package service;

import model.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookService {
    private Connection connection;

    public BookService(Connection connection) {
        this.connection = connection;
    }

    public void insertBook(String title, String isbn, int quantity, double price, int authorId) throws SQLException {

        String sql = "INSERT INTO book (title, isbn, quantity_in_stock, price, author_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, title);
            statement.setString(2, isbn);
            statement.setInt(3, quantity);
            statement.setDouble(4, price);
            statement.setInt(5, authorId);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {

                System.out.println("Book created successfully.");
            } else {

                System.out.println("Failed to create the book.");
            }
        }
    }

    public Book getBookById(int bookId) throws SQLException {

        String sql = "SELECT * FROM book WHERE book_id = ?";

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


}

