package lld.design_apply_coupon_on_shopping_cart.coupon;

import lld.design_apply_coupon_on_shopping_cart.Product;

public class PercentageCouponDecorator extends CouponDecorator {

    Product product;
    int discountPercentage;

    public PercentageCouponDecorator(Product product, int discountPercentage) {
        this.product = product;
        this.discountPercentage = discountPercentage;
    }
    @Override
    public double getPrice() {
        double price = product.getPrice();
        return price - (price * discountPercentage / 100);
    }
}
