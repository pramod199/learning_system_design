package creational.prototype;

import creational.builder.CarBuilder;
import creational.builder.Director;

/*

 */
public class Client {
    public static void main(String[] args) {
        Car carA = new Car();

        carA.brand = "BUgatti";
        carA.model = "chiron";
        carA.setColor("Blue");

        Car carB = new Car(); // copying is tightly coupled and depends on the Car class.
        carB.brand = carA.brand;
        carB.model = carA.model;
//        carB.setColor(carA.color); // this won't work as color is private and there is no getter.

        // another issue: if you have interface

//        Vehicle car = carA;



    }

    public void copyObject(Vehicle vehicle) {

        // Vehicle can not be instantiated
        // should we create a Car or Bus?
    }
}
