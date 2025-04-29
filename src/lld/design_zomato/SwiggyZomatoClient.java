package lld.design_zomato;

import lld.design_zomato.delivery.DeliveryPartner;
import lld.design_zomato.delivery.DeliveryPartnerManager;
import lld.design_zomato.restaurant.Cuisine;
import lld.design_zomato.restaurant.Dish;
import lld.design_zomato.restaurant.DishAddOn;
import lld.design_zomato.restaurant.Menu;
import lld.design_zomato.restaurant.Restaurant;
import lld.design_zomato.restaurant.RestaurantMgr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwiggyZomatoClient {

    public static void main(String[] args) {
        // Chinese Restaurant
        RestaurantOwner owner1 = new RestaurantOwner("owner1");
        Restaurant chineseRest = new Restaurant("chinese vala", owner1, new Location(1, 2));
        Dish noodles = new Dish("noodles", Cuisine.CHINESE, 200);
        noodles.addAddOn(new DishAddOn("premium sauce", 20));
        Dish friedRice = new Dish("fried rice", Cuisine.CHINESE, 180);
        Dish springRolls = new Dish("spring rolls", Cuisine.CHINESE, 120);

        Menu chineseMenu = new Menu(List.of(noodles, friedRice, springRolls));
        chineseRest.addMenu(chineseMenu);

        // South Indian Restaurant
        RestaurantOwner owner2 = new RestaurantOwner("owner2");
        Restaurant southIndianRest = new Restaurant("south indian food", owner2, new Location(2, 3));
        Dish idli = new Dish("idli", Cuisine.SOUTH_INDIAN, 200);
        Dish dosa = new Dish("dosa", Cuisine.SOUTH_INDIAN, 180);
        Dish uthappam = new Dish("uthappam", Cuisine.SOUTH_INDIAN, 120);
        Menu southIndianMenu = new Menu(List.of(idli, dosa, uthappam));
        southIndianRest.addMenu(southIndianMenu);

        // Add Restaurants to Manager
        RestaurantMgr restaurantMgr = RestaurantMgr.getRestaurantMgr();
        restaurantMgr.addRestaurant("chinese vala", chineseRest);
        restaurantMgr.addRestaurant("south indian food", southIndianRest);

        //////////////////////////////////////////////////////////////////////////////////////////////////

        DeliveryPartner alpha = new DeliveryPartner("alpha");
        DeliveryPartner beta = new DeliveryPartner("beta");
        DeliveryPartner gamma = new DeliveryPartner("gamma");

        DeliveryPartnerManager deliveryPartnerMgr = DeliveryPartnerManager.getDeliveryPartnerManager();
        deliveryPartnerMgr.addDeliveryPartner("alpha", alpha);
        deliveryPartnerMgr.addDeliveryPartner("beta", beta);
        deliveryPartnerMgr.addDeliveryPartner("gamma", gamma);

        //////////////////////////////////////////////////////////////////////////////////////////////////

        User keerti = new User("keerti", new Location(10, 11));
        User gaurav = new User("gaurav", new Location(13, 14));
        User yogita = new User("yogita", new Location(15, 16));

        UserManager userMgr = UserManager.getUserManager();
        userMgr.addUser("keerti", keerti);
        userMgr.addUser("gaurav", gaurav);
        userMgr.addUser("yogita", yogita);

        //////////////////////////////////////////////////////////////////////////////////////////////////

        // Prepare cart
        Map<Dish, Integer> cart = new HashMap<>();
        cart.put(noodles, 2);
        cart.put(friedRice, 1);

        Order order1 = new Order(keerti, chineseRest, cart);

        OrderManager orderMgr = OrderManager.getOrderMgr();
        orderMgr.createOrder("order1", order1);
    }

}
