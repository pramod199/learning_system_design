package lld.design_apply_coupon_on_shopping_cart;

public abstract class Product {
    String name;
    double originalPrice;
    ProductType productType;

    public Product() {
    }

    public Product(String name, double originalPrice, ProductType productType) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.productType = productType;
    }


    public abstract double getPrice();


    public ProductType getProductType() {
        return productType;
    }
}
