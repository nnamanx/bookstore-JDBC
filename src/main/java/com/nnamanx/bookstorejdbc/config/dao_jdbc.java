package com.nnamanx.bookstorejdbc.config;

import com.nnamanx.bookstorejdbc.model.entity.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.nnamanx.bookstorejdbc.query.BookQueryList.*;


@Configuration
public class dao_jdbc {

    //    Taking database access information from yaml file

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    //    Connectivity
    protected Connection getConnect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }


    //Create or insert book
    public void insertBook(Book book) {
        try (Connection connect = getConnect();
             PreparedStatement statement = connect.prepareStatement(INSERT_BOOK)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());

            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Update book
    public boolean updateUser(Book book) {
        boolean bookUpdated = false;
        try (Connection connect = getConnect();
             PreparedStatement statement = connect.prepareStatement(UPDATE_BOOK)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            statement.setLong(4, Math.toIntExact(book.getId()));

            bookUpdated = statement.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookUpdated;
    }

    //Select book by id
    public Book selectBook(Long id) {
        Book book = null;
        try (Connection connect = getConnect();
             PreparedStatement statement = connect.prepareStatement(SELECT_BOOK_BY_ID)) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                Integer year = rs.getInt("year");

                book = Book.builder()
                        .id(id)
                        .title(title)
                        .author(author)
                        .year(year)
                        .build();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return book;
    }

    //Select books
    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connect = getConnect();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL_BOOKS)) {

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                Integer year = rs.getInt("year");

                Book book = Book.builder()
                        .id(id)
                        .title(title)
                        .author(author)
                        .year(year)
                        .build();
                books.add(book);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return books;
    }

    //Delete book
    public boolean deleteBook(Long id) {
        boolean deletedBook = false;
        try (Connection connect = getConnect();
             PreparedStatement statement = connect.prepareStatement(DELETE_BOOK)) {
            statement.setLong(1, id);

            deletedBook = statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return deletedBook;
    }


}
