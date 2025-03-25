package creational.builder;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String color;

     Car(int id, String brand, String model, String color) { // notice this is package private
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }
}
