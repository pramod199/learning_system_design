package lld.design_apply_coupon_on_shopping_cart;

public class Client {
    public static void main(String[] args) {
        Product item1 = new Item1("item1", 100, ProductType.GROCERY);
        Product item2 = new Item2("item2", 200, ProductType.ELECTRONIC);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCart(item1);
        shoppingCart.addToCart(item2);

//        System.out.println("Total price before applying coupon: " + shoppingCart.getTotalPrice());


        System.out.println("Total price after applying coupon: " + shoppingCart.getTotalPrice());
    }
}
