package lld.design_online_shopping_service.models;

public class Account {
    private final String userName;

    private final String password;
    private final ShoppingCart cart;

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.cart = new ShoppingCart();
    }

    public ShoppingCart getCart() {
        return cart;
    }
}
