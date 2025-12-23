package lld.design_online_shopping_service;

import lld.design_online_shopping_service.enums.ProductCategory;
import lld.design_online_shopping_service.models.*;
import lld.design_online_shopping_service.strategy.CreditCardPaymentStrategy;

public class OnlineShoppingDemo {
    public static void main(String[] args) {
        // --- System Setup (Singleton and Services) ---
        OnlineShoppingSystem system = OnlineShoppingSystem.getInstance();

        Product laptop = new Product("Dell XPS", "A powerful and sleek laptop.", 1499.99, ProductCategory.ELECTRONICS);
        Product book = new Product("The Pragmatic Programmer", "A classic book for software developers.", 45.50, ProductCategory.BOOKS);

        system.addProduct(laptop, 10); // 10 laptops in stock
        system.addProduct(book, 50);   // 50 books in stock

        // --- Register a Customer ---
        Address aliceAddress = new Address("123 Main St", "Anytown", "CA", "12345");
        Customer alice = system.registerCustomer("Alice", "alice@example.com", "password123", aliceAddress);
        // --- Alice Shops ---
        System.out.println("--- Alice starts shopping ---");

        // Alice adds a laptop to her cart
        system.addToCart(alice.getId(), laptop.getId(), 1);
        System.out.println("Alice added a laptop to her cart.");

        system.addToCart(alice.getId(), book.getId(), 1);

        ShoppingCart aliceCart = system.getCustomerCart(alice.getId());
        System.out.printf("Alice's cart total: $%.2f%n", aliceCart.calculateTotal());

// --- Alice Checks Out ---
        System.out.println("\n--- Alice proceeds to checkout ---");
        Order aliceOrder = system.placeOrder(alice.getId(), new CreditCardPaymentStrategy("1234-5678-9876-5432"));
        if (aliceOrder == null) {
            System.out.println("Order placement failed.");
            return;
        }

        System.out.printf("Order #%s placed successfully for Alice.%n", aliceOrder.getId());

    }
}
