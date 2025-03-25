package lld.solid_principles.single_responsibility.fix;


/*
    * Single Responsibility Principle:
    * A class should have only one reason to change, meaning that a class should have only one job.
    * If a class has more than one responsibility, it becomes coupled. A change to one responsibility results to modification of the other responsibility.
 */
public class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public double calculateTotalPrice() { // if gst comes then we need to change this method
        return marker.price * quantity;
    }

    /*

    public void printInvoice() { // if print logic changes then we need to change this method
        System.out.println("Name: " + marker.name);
        System.out.println("Color: " + marker.color);
        System.out.println("Year: " + marker.year);
        System.out.println("Price: " + marker.price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + calculateTotalPrice());
    }

    public void saveToDb() { // if we decide to save to file then we need to change this method
        // Save to database
    }*/
}
