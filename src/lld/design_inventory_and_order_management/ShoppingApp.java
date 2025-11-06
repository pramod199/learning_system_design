package lld.design_inventory_and_order_management;


import java.util.ArrayList;
import java.util.List;

public class ShoppingApp {
    private static ShoppingApp instance = null;
    UserController userController;
    WarehouseController warehouseController;
    OrderController orderController;

    private ShoppingApp(UserController userController, WarehouseController warehouseController, OrderController orderController) {
        this.userController = userController;
        this.warehouseController = warehouseController;
        this.orderController = orderController;
    }

    public static ShoppingApp getInstance(UserController userController, WarehouseController warehouseController, OrderController orderController) {
        if (instance == null) {
            instance = new ShoppingApp(userController, warehouseController, orderController);
        }
        return instance;
    }

    //get user object
    public User getUser(int userId){
        return userController.getUser(userId);
    }

    //get warehouse
    public Warehouse getWarehouse(){
        return warehouseController.selectWarehouse();

    }

    //get inventory
    public Inventory getInventory(Warehouse warehouse){
        return warehouse.inventory;

    }

    //add product to cart
    public void addProductToCart(User user, Product product, int count){
        Cart cart = user.getCart();
        cart.addItem(product, count);
    }


    public synchronized Order placeOrder(User user, Warehouse warehouse, Payment payment) {
        return orderController.createNewOrder(user, warehouse, payment);



    }

}
