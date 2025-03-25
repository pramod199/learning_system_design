package creational.builder;

/*
 director class defines the order in which we should call the construction steps
 so that we can reuse specific configurations
 of the products we are building.

 Directors are optional

 it hides the deatils of the product construction from the client code.

 can deal with various builder implementation also

 */
public class Director {
    public void buildBuggati(CarBuilder builder) {
        builder.brand("Bugatti")
                .color("Blue")
                .model("7 seat");
    }

    public void buildLambo(CarBuilder builder) {
        builder.brand("Lamborgini")
                .model("Aventador")
                .color("Yellow");
    }
}
