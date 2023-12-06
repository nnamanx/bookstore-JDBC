package model.entity;

public class Order {

    private int orderId;
    private int bookId;
    private int status = 1;

//    Getters & Setters

    public int getOrderId() {

        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //    ToString method

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", bookId=" + bookId +
                ", status=" + status +
                '}';
    }
}
