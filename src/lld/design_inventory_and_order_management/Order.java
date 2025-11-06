package lld.design_inventory_and_order_management;


import java.util.List;

public class Order {
    int id;
    User user;
    Address deliveryAddress;
    List<OrderItem> orderItems;
    Warehouse warehouse;
    OrderStatus status;
    Invoice invoice;
    Payment payment;

    Order(int orderId, User user, Warehouse warehouse, List<OrderItem> orderItems) {
        this.id = orderId;
        this.user = user;
        this.orderItems = orderItems;
        this.warehouse = warehouse;
        this.deliveryAddress = user.address;
        invoice = new Invoice();
        invoice.generateInvoice(this);
    }


    public void generateOrderInvoice(){
        invoice.generateInvoice(this);
    }

    public double getTotalAmount(){
        generateOrderInvoice();
        return invoice.totalItemPrice;
    }


    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public Payment getPayment() {
        return payment;
    }
}
