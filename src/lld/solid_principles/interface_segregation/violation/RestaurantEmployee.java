package lld.solid_principles.interface_segregation.violation;

/*
    This is a violation of Interface Segregation Principle.
    The RestaurantEmployee interface has three methods, but not all employees need to implement all three methods.
    For example, a dishwasher does not need to serve customers or cook food.
    This interface should be broken down into smaller interfaces.

    Interface should be such that client should not be forced to implement methods which it does not use.
 */
public interface RestaurantEmployee {
    void washDishes();

    void serveCustomer();

    void cookFood();
}
