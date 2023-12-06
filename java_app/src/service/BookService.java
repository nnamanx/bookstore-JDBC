package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookService {
    private Connection connection;

    public BookService(Connection connection) {
        this.connection = connection;
    }

    public void insertBook(String title, String isbn, int quantity, double price, int authorId) throws SQLException {

        String sql = "INSERT INTO books (title, isbn, quantity_in_stock, price, author_id) VALUES (?, ?, ?, ?, ?)";

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
}

