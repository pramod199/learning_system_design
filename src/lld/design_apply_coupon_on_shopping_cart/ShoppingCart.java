package lld.design_apply_coupon_on_shopping_cart;

import lld.design_apply_coupon_on_shopping_cart.coupon.PercentageCouponDecorator;
import lld.design_apply_coupon_on_shopping_cart.coupon.TypeCouponDecorator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList;

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public void addToCart(Product product) {
        Product productWithEligibleDiscount = new TypeCouponDecorator(new PercentageCouponDecorator(product, 10), 20, product.getProductType());
        productList.add(productWithEligibleDiscount);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
