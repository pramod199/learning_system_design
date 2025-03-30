package lld.design_apply_coupon_on_shopping_cart.coupon;

import lld.design_apply_coupon_on_shopping_cart.Product;
import lld.design_apply_coupon_on_shopping_cart.ProductType;

import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator {
    Product product;
    int discountPercentage;
    ProductType type;

    static List<ProductType> eligibleTypes = new ArrayList<>();
    static {
        eligibleTypes.add(ProductType.ELECTRONIC);
        eligibleTypes.add(ProductType.CLOTHING);
    }

    public TypeCouponDecorator(Product product, int discountPercentage, ProductType type) {
        this.product = product;
        this.discountPercentage = discountPercentage;
        this.type = type;
    }

    @Override
    public double getPrice() {
        double price = product.getPrice();
        if (eligibleTypes.contains(type)) {
            return price - (price * discountPercentage / 100);
        }
        return price;
    }
}
