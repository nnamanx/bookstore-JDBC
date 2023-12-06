package impl;

import model.entity.Order;
import service.OrderService;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderServiceImpl {

    private Connection conn;

    public OrderServiceImpl(Connection conn) {
        this.conn = conn;
    }

    public void performOrderOperations() {

        OrderService orderService = new OrderService(conn);

        try {

            // Insert Order
            Order newOrder = new Order();

            orderService.insertOrder(newOrder);

            // Retrieve Order by ID
            Order retrievedOrder = orderService.getOrderById(1);
            System.out.println("Retrieved Order: " + retrievedOrder);


            // Delete Order
            orderService.deleteOrder(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
