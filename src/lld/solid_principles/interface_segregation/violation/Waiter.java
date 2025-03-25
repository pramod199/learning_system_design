package lld.solid_principles.interface_segregation.violation;

public class Waiter implements RestaurantEmployee {
    @Override
    public void washDishes() {
        // not my job
        throw new UnsupportedOperationException("Not my job");
    }

    @Override
    public void serveCustomer() {
        // serving customer
    }

    @Override
    public void cookFood() {
        // not my job
        throw new UnsupportedOperationException("Not my job");
    }
}
