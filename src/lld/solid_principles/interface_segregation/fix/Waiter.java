package lld.solid_principles.interface_segregation.fix;

public class Waiter implements WaiterInterface {
    @Override
    public void serveCustomer() {
        // serving customer
    }

    @Override
    public void takeOrder() {
        // taking order
    }
}
