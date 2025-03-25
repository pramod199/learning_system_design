package creational.prototype;

public class Car implements Prototype {
    String brand;
    String model;
    private String color;
    private int topSpeed;

    public Car() {
    }

    public Car(Car car) {
        this.brand = car.brand;
        this.model = car.model;
        this.color = car.color;
        this.topSpeed = car.topSpeed;
    }

    /*
    if car was subclass
     public Car(Car car) {
        super(car);
        this.brand = car.brand;

     }
     */

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public Car clone() {
        return new Car(this);
    }
}
