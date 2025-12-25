package lld_algomaster.design_online_shopping_service.models;

import lld_algomaster.design_online_shopping_service.enums.ProductCategory;

import java.util.UUID;

public class Product {
    String id;
    String name;
    String description;

    double price;
    ProductCategory category;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public Product(String name, String description, double price, ProductCategory category) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}
