package creational.builder;

/*
 Use the Builder pattern to get rid of a “telescoping constructor”.


 */
public class Client {
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder();
        builder.id(12)
                .brand("Bugatti")
                .color("red")
                .model("Big");

        Car c = builder.build();

        // using director
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();
        director.buildBuggati(carBuilder);
        Car car = carBuilder.build();

    }
}
