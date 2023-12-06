import config.DatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        DatabaseConnection db = new DatabaseConnection();

        Connection conn = db.databaseConnection("bookstore_jdbc", "postgres", "12131");


    }
}