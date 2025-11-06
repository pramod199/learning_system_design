package lld.design_inventory_and_order_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderController {
    Map<Integer, Order> orderIdVsOrder;
    Map<Integer, List<Order>> userIdVsOrders;

    public OrderController() {
        this.orderIdVsOrder = new HashMap<>();
        this.userIdVsOrders = new HashMap<>();
    }

    //create New Order
    public Order createNewOrder(User user, Warehouse warehouse, Payment payment) {
        //1. update inventory
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItem item : user.getCart().getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            if (product.isAvailable(quantity)) {
                product.updateQuantity(-quantity);
                orderItems.add(item);
            }
        }

        if (orderItems.isEmpty()) {
            throw new IllegalStateException("No available products in the cart.");
        }

        Order order = new Order(generateOrderId(), user, warehouse, orderItems);



        // process payment
        if (payment.makePayment(order.getTotalAmount(), "card payment")) {
            order.status = OrderStatus.PROCESSING;
        } else {
            order.status = OrderStatus.CANCELLED;
            // Revert the product quantities
            for (OrderItem item : orderItems) {
                Product product = item.getProduct();
                int quantity = item.getQuantity();
                product.updateQuantity(quantity);
            }
        }

        // create order
        orderIdVsOrder.put(order.getId(), order);

        if (userIdVsOrders.containsKey(user.getId())) {
            List<Order> userOrders = userIdVsOrders.get(user.getId());
            userOrders.add(order);
            userIdVsOrders.put(user.getId(), userOrders);
        } else {
            List<Order> userOrders = new ArrayList<>();
            userOrders.add(order);
            userIdVsOrders.put(user.getId(), userOrders);
        }
        return order;
    }


    //remove order
    public void removeOrder(Order order) {

        //remove order capability goes here
    }

    public List<Order> getOrderByCustomerId(int userId) {
        return null;
    }

    public Order getOrderByOrderId(int orderId) {
        return null;
    }

    private int generateOrderId() {
        return 1;
    }


}
