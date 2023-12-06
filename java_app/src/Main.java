import config.DatabaseConnection;
import impl.AuthorServiceImpl;
import service.BookService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = new DatabaseConnection().databaseConnection("bookstore_jdbc", "postgres", "12131")) {
            AuthorServiceImpl authorService = new AuthorServiceImpl(conn);
            authorService.performAuthorOperations();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}