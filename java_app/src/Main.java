import config.DatabaseConnection;
import impl.AuthorServiceImpl;
import impl.BookServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = new DatabaseConnection().databaseConnection("bookstore_jdbc", "postgres", "12131")) {
            AuthorServiceImpl authorService = new AuthorServiceImpl(conn);
            authorService.performAuthorOperations();

            System.out.println("=============================================");

            BookServiceImpl bookService = new BookServiceImpl(conn);
            bookService.performBookOperations();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}