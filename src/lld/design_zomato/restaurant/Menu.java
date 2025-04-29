package lld.design_zomato.restaurant;

import java.util.List;

public class Menu {
    private List<Dish> dishes;

    public Menu(List<Dish> dishes) {
        this.dishes = dishes;
    }

    // Optional: you can add methods like getDishes() if needed
    public List<Dish> getDishes() {
        return dishes;
    }
}
