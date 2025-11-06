package lld.design_inventory_and_order_management;

public class Invoice {
    double totalItemPrice;
    double totalTax;
    double totalFinalPrice;

    //generate Invoice
    public void generateInvoice(Order order) {
        order.getOrderItems().forEach(orderItem -> {
            totalItemPrice += orderItem.getProduct().getPrice() * orderItem.getQuantity();
        });
    }


}
