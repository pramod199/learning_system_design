package lld.design_apply_coupon_on_shopping_cart;

public class Item1 extends Product {
    public Item1(String name, double originalPrice, ProductType productType) {
        super(name, originalPrice, productType);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}
