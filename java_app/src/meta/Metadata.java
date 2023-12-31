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
        }
    }

    public void displayColumnDetails(String tableName) throws SQLException {

        DatabaseMetaData metaData = connection.getMetaData();

        ResultSet resultSet = metaData.getColumns(null, null, tableName, null);

        while (resultSet.next()) {
            System.out.println("Column Name: " + resultSet.getString("COLUMN_NAME"));
        }
    }


    public void displayKeyInformation(String tableName) throws SQLException {

        DatabaseMetaData metaData = connection.getMetaData();

        // Displaying Primary Key Information
        ResultSet primaryKeyResultSet = metaData.getPrimaryKeys(null, null, tableName);

        // If there is no info about primary key
        if (!primaryKeyResultSet.next()) {
            System.out.println("No primary key found for table '" + tableName + "'.");
        } else {
            do {
                System.out.println("Primary Key Name: " + primaryKeyResultSet.getString("COLUMN_NAME"));
            } while (primaryKeyResultSet.next());
        }

        // Display Foreign Key Information
        ResultSet foreignKeyResultSet = metaData.getImportedKeys(null, null, tableName);

        // If there is no info
        if (!foreignKeyResultSet.next()) {

            System.out.println("No foreign key found for table '" + tableName + "'.");
        } else {
            do {
                System.out.println("Foreign Key Name: " + foreignKeyResultSet.getString("FKCOLUMN_NAME"));
            } while (foreignKeyResultSet.next());
        }
    }

}
