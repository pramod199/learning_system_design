package lld.factory_design_pattern.factory;

public class MainClass {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shapeObj = shapeFactory.getShape("CIRCLE");
        shapeObj.draw();
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
    }
}
