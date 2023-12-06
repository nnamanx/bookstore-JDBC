# Bookstore-JDBC
The Bookstore Spring Boot app is a web application built using the Spring Boot framework, designed to manage and showcase a collection of books. Users can search for specific titles and perform actions such as adding books. The application likely incorporates features such as database integration to store book information.

# Entity-Relationship (ER) Diagram
<img width="468" alt="image" src="https://github.com/nnamanx/bookstore-JDBC/assets/88698561/66e920f3-96e8-4570-be08-986a1302e8ae">

# Code Explanation

DatabaseConnection class: Purpose is to establishe a connection to the PostgreSQL database. databaseConnection(String databaseName, String user, String pass) method is used. Establishes a connection to the specified PostgreSQL database. After running the program, it prints a message indicating the success or failure of the connection. 

<img width="155" alt="image" src="https://github.com/nnamanx/bookstore-JDBC/assets/88698561/001562ab-abb6-4829-a6d6-890e0053cec5">

AuthorService class: Purpose is to handle CRUD operations for the Author entity. insertAuthor(Author author) - Inserts a new author into the database.
getAuthorById(int authorId) - Retrieves an author by their ID.
updateAuthor(Author author) - Updates the details of an existing author.
deleteAuthor(int authorId, int status) - Deletes or updates the status of an author.
getAllAuthors() - Retrieves a list of all authors.

BookService Class: Purpose is to handle CRUD operations for the Book entity.
insertBook(Book book) - Inserts a new book into the database.
getBookById(int bookId) - Retrieves a book by its ID.
updateBook(Book book) - Updates the details of an existing book. 
deleteBook(int bookId, int status) - Deletes or updates the status of a book.
getAllBooks() - Retrieves a list of all books.


# Metadata Access: 
This class is responsible for providing access to essential database metadata. This includes methods for retrieving information about tables, columns, primary keys, and foreign keys. The purpose of the Metadata class is to facilitate the retrieval of critical database metadata, allowing the application to dynamically understand the structure and relationships within the database.

# Transaction Management:
The purpose is to ensure atomicity and consistency of database transactions. Include transaction-related methods used in the application.


