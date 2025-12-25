package lld_algomaster.design_online_shopping_service.service;

import lld_algomaster.design_online_shopping_service.enums.ProductCategory;
import lld_algomaster.design_online_shopping_service.models.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private final List<Product> productList;

    public SearchService(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        productList.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .forEach(result::add);
        return result;
    }

    public List<Product> searchByCategory(ProductCategory category) {
        List<Product> result = new ArrayList<>();
        productList.stream()
                .filter(p -> p.getCategory() == category)
                .forEach(result::add);
        return result;
    }

}
