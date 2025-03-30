package lld.design_apply_coupon_on_shopping_cart;

public class Item2 extends Product {
    public Item2(String name, double originalPrice, ProductType productType) {
        super(name, originalPrice, productType);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}
