import config.DatabaseConnection;
import service.BookService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = new DatabaseConnection().databaseConnection("bookstore_jdbc", "postgres", "12131")) {

            // Starts a transaction
            conn.setAutoCommit(false);

            BookService bookService = new BookService(conn);

            try {
                bookService.insertBook("Crime and Punishment", "123456789", 5, 10, 1);

                // If all operations succeed this will commit the transaction
                conn.commit();

            } catch (SQLException e) {

                // If any operation fails, It rollbacks the transaction ( AKA the process)
                conn.rollback();
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}