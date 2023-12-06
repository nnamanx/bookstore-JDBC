package impl;

import config.DatabaseConnection;
import model.entity.Author;
import service.AuthorService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AuthorServiceImpl {

    private Connection conn;

    public AuthorServiceImpl(Connection conn) {
        this.conn = conn;
    }

    public void performAuthorOperations() {
        AuthorService authorService = new AuthorService(conn);

        try {
            // Insert Author
            Author newAuthor = new Author();
            newAuthor.setFirstName("John");
            newAuthor.setLastName("Doe");
            newAuthor.setEmail("john.doe@example.com");
            authorService.insertAuthor(newAuthor);

            // Retrieve Author by ID
            Author retrievedAuthor = authorService.getAuthorById(1);
            System.out.println("Retrieved Author: " + retrievedAuthor);

            // Update Author
            retrievedAuthor.setFirstName("UpdatedJohn");
            authorService.updateAuthor(retrievedAuthor);

            // Delete Author
            authorService.deleteAuthor(1, 0);

            // Retrieve All Authors
            List<Author> allAuthors = authorService.getAllAuthors();
            System.out.println("All Authors: " + allAuthors);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
