package lld.design_online_shopping_service.models;

import lld.design_online_shopping_service.enums.OrderStatus;
import lld.design_online_shopping_service.observer.Observable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order extends Observable {

    private final String id;

    private final Customer customer;

    private final List<OrderLineItem> items;

    private final Address shippingAddress;

    private final double totalAmount;

    private final LocalDateTime orderDate;

    private OrderStatus status;

    public Order(Customer customer, List<OrderLineItem> items, Address shippingAddress, double totalAmount) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.customer = customer;
        this.items = items;
        this.shippingAddress = shippingAddress;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PLACED;
        addObserver(customer);
    }


    public String getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
