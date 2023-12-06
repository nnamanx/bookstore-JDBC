package service;

import model.entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static model.constants.Query.*;

public class AuthorService {

    private Connection connection;

    public AuthorService(Connection connection) {

        this.connection = connection;
    }

    public void insertAuthor(Author author) throws SQLException {

        String sql = INSERT_AUTHOR;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.setString(3, author.getEmail());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Author created.");
            } else {

                System.out.println("Failed to create author!");
            }
        }
    }

    public Author getAuthorById(int authorId) throws SQLException {

        String sql = GET_AUTHOR_BY_ID;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, authorId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToAuthor(resultSet);
                }
            }
        }
        return null;
    }

    public List<Author> getAllAuthors() throws SQLException {

        List<Author> authors = new ArrayList<>();

        String sql = GET_ALL_AUTHORS;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                authors.add(mapResultSetToAuthor(resultSet));
            }
        }
        return authors;
    }

    public void updateAuthor(Author updatedAuthor) throws SQLException {

        String sql = UPDATE_AUTHOR;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, updatedAuthor.getFirstName());
            statement.setString(2, updatedAuthor.getLastName());
            statement.setString(3, updatedAuthor.getEmail());
            statement.setInt(4, updatedAuthor.getStatus());
            statement.setInt(5, updatedAuthor.getAuthorId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Author updated.");
            } else {
                System.out.println("Failed to update author!");
            }
        }
    }

    public void deleteAuthor(int authorId, int status) throws SQLException {

        String sql = DELETE_AUTHOR;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, authorId);
            statement.setInt(2, status);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Author deleted.");
            } else {
                System.out.println("Author not found or status mismatch.");
            }
        }
    }

    private Author mapResultSetToAuthor(ResultSet resultSet) throws SQLException {
        Author author = new Author();
        author.setAuthorId(resultSet.getInt("author_id"));
        author.setFirstName(resultSet.getString("first_name"));
        author.setLastName(resultSet.getString("last_name"));
        author.setEmail(resultSet.getString("email"));
        return author;
    }
}
