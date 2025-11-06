package lld.design_inventory_and_order_management;


import lld.design_apply_coupon_on_shopping_cart.ShoppingCart;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Register users
        User user1 = new User(1, "John Doe");
        User user2 = new User(2, "Jane Smith");
        UserController userController = new UserController();
        userController.addUser(user1);
        userController.addUser(user2);

        // Add products
        Inventory inventory = new Inventory();
        Product product1 = new Product(1, "Smartphone", "High-end smartphone", 999.99, 10);
        Product product2 = new Product(2, "Laptop", "Powerful gaming laptop", 1999.99, 5);

        Address warehouseAddress = new Address("123 Main St", "New York", "NY", "10001");

        Warehouse warehouse = new Warehouse(inventory, warehouseAddress);
        warehouse.addProduct(product1);
        warehouse.addProduct(product2);

        WarehouseController warehouseController = new WarehouseController(List.of(warehouse), new NearestWarehouseSelectionStrategy());


        OrderController orderController = new OrderController();

        ShoppingApp shoppingApp = ShoppingApp.getInstance(userController, warehouseController, orderController);

        User user = shoppingApp.getUser(1);
        System.out.println("User: " + user.getId());

        Warehouse shoppingAppWarehouse = shoppingApp.getWarehouse();

        // User 1 adds products to cart and places an order
        shoppingApp.addProductToCart(user1, product1, 1);
        shoppingApp.addProductToCart(user1, product2, 2);

        shoppingApp.placeOrder(user1, shoppingAppWarehouse, new Payment(new CardPaymentMode()));

    }
}
