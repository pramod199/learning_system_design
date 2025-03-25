package lld.factory_design_pattern.factory;

public class ShapeFactory {
    Shape getShape(String input) {
        if ("CIRCLE".equalsIgnoreCase(input)) {
            return new Circle();
        } else if ("RECTANGLE".equalsIgnoreCase(input)) {
            return new Rectangle();
        }
        return null;
    }
}
