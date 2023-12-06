package config;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
    public Connection databaseConnection(String databaseName, String user, String pass) {

        Connection conn = null;

        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5434/" + databaseName, user, pass);
            if (conn != null) {

                System.out.println("Connected.");
            } else {
                System.out.println("Failed!");
            }

        } catch (Exception e) {

            System.out.println(e);
        }
        return conn;
    }

}