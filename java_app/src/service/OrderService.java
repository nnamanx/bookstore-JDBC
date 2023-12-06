package service;

import model.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static model.constants.Query.*;

public class OrderService {

    private Connection connection;

    public OrderService(Connection connection) {
        this.connection = connection;
    }

    // Creating a new Order
    public void insertOrder(Order order) throws SQLException {

        String sql = INSERT_ORDER;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, order.getCustomerId());
            statement.setDate(2, order.getOrderDate());
            statement.executeUpdate();
            System.out.println("Order created successfully.");
        }
    }

    // Getting an Order by ID
    public Order getOrderById(int orderId) throws SQLException {

        String sql = GET_ORDER_BY_ID;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToOrder(resultSet);
                }
            }
        }
        // Return null if the order is not found
        return null;
    }

    // Read (Retrieve) all Orders
    public List<Order> getAllOrders() throws SQLException {

        List<Order> orders = new ArrayList<>();

        String sql = GET_ALL_ORDERS;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                orders.add(mapResultSetToOrder(resultSet));
            }
        }
        return orders;
    }

    // Updating an existing Order
    public void updateOrder(Order order) throws SQLException {

        String sql = UPDATE_ORDER;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, order.getCustomerId());
            statement.setDate(2, order.getOrderDate());
            statement.setInt(3, order.getOrderId());
            statement.executeUpdate();
            System.out.println("Order updated successfully.");
        }
    }

    // Deletion
    public void deleteOrder(int orderId) throws SQLException {

        String sql = DELETE_ORDER;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, orderId);
            statement.executeUpdate();
            System.out.println("Order deleted.");
        }
    }

    // Mapping ResultSet
    private Order mapResultSetToOrder(ResultSet resultSet) throws SQLException {

        Order order = new Order();

        order.setOrderId(resultSet.getInt("order_id"));
        order.setCustomerId(resultSet.getInt("customer_id"));
        order.setOrderDate(String.valueOf(resultSet.getDate("order_date")));
        order.setStatus(resultSet.getInt("status"));
        return order;
    }
}

