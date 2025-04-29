package lld.design_zomato;


import lld.design_zomato.restaurant.Dish;
import lld.design_zomato.restaurant.Restaurant;

import java.util.Map;

public class Order {
    private User user;
    private Restaurant restaurant;
    private Map<Dish, Integer> dishes; // quantity for each dish
    private String discountCode;
    private String paymentId;
    private OrderStatus status;

    public Order(User user, Restaurant restaurant, Map<Dish, Integer> dishes) {
        this.user = user;
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.status = OrderStatus.PLACED;
    }

    public String getUserId() {
        return user.getId();
    }

    public String getRestaurantId() {
        return restaurant.getId();
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }

    public Location getUserLocation() {
        return user.getLocation();
    }

    public Location getRestaurantLocation() {
        return restaurant.getLocation();
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
