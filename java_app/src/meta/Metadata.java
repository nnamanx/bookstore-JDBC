package meta;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metadata {

    private Connection connection;

    public Metadata(Connection connection) {
        this.connection = connection;
    }

    public void displayTableMetadata(String tableName) throws SQLException {

        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, tableName, null);

        while (resultSet.next()) {

            System.out.println("Table Name: " + resultSet.getString("TABLE_NAME"));
            // Add more metadata details as needed
        }
    }

    public void displayColumnDetails(String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getColumns(null, null, tableName, null);

        while (resultSet.next()) {
            System.out.println("Column Name: " + resultSet.getString("COLUMN_NAME"));
            // Add more column details as needed
        }
    }

    public void displayKeyInformation(String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getPrimaryKeys(null, null, tableName);

        while (resultSet.next()) {
            System.out.println("Primary Key Name: " + resultSet.getString("COLUMN_NAME"));
            // Add more primary key details as needed
        }

        resultSet = metaData.getImportedKeys(null, null, tableName);
        while (resultSet.next()) {
            System.out.println("Foreign Key Name: " + resultSet.getString("FKCOLUMN_NAME"));
            // Add more foreign key details as needed
        }
    }
}
