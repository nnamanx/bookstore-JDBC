package model.constants;

public class Query {

    public final static String UPDATE_AUTHOR = "UPDATE author SET first_name = ?, last_name = ?, email = ?, status = ? WHERE author_id = ?";
    public final static String INSERT_AUTHOR = "INSERT INTO author (first_name, last_name, email) VALUES (?, ?, ?)";
    public final static String GET_AUTHOR_BY_ID = "SELECT * FROM author WHERE author_id = ?";
    public final static String GET_ALL_AUTHORS = "SELECT * FROM author";
    public static final String DELETE_AUTHOR = "DELETE FROM author WHERE author_id = ? AND status = ?";
    public static final String INSERT_BOOK = "INSERT INTO book (title, isbn, quantity_in_stock, price, author_id) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_BOOK_BY_ID = "SELECT * FROM book WHERE book_id = ?";
    public static final String DELETE_BOOK = "UPDATE book SET status = ? WHERE book_id = ?";
    public static final String UPDATE_BOOK = "UPDATE book SET title = ?, isbn = ?, quantity_in_stock = ?, price = ?, author_id = ?, status = ? WHERE book_id = ?";
    public static final String INSERT_ORDER = "INSERT INTO book_order (book_id) VALUES (?)";
    public static final String GET_ORDER_BY_ID = "SELECT * FROM book_order WHERE order_id = ?";
    public static final String GET_ALL_ORDERS = "SELECT * FROM book_order";
    public static final String DELETE_ORDER = "UPDATE book_order SET status = 0 WHERE order_id = ?";
}

