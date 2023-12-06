import config.DatabaseConnection;
import impl.AuthorServiceImpl;
import impl.BookServiceImpl;
import meta.Metadata;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = new DatabaseConnection().databaseConnection("bookstore_jdbc", "postgres", "12131")) {

            // Instantiate AuthorService and perform operations
            AuthorServiceImpl authorService = new AuthorServiceImpl(conn);
            authorService.performAuthorOperations();

            System.out.println("=============================================");

            // Instantiate BookService and perform operations
            BookServiceImpl bookService = new BookServiceImpl(conn);
            bookService.performBookOperations();

            // Instantiate Metadata and perform operations
            Metadata metadata = new Metadata(conn);
            metadataOperations(metadata);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void metadataOperations(Metadata metadata) {

        try {

            System.out.println("Metadata for 'Book' Table:");
            metadata.displayTableMetadata("Book");

            System.out.println("=============================================");

            System.out.println("Column Details for 'Book' Table:");
            metadata.displayColumnDetails("Book");

            System.out.println("=============================================");

            System.out.println("Key Information for 'Book' Table:");
            metadata.displayKeyInformation("Book");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
