package lld.solid_principles.dependency_inversion;

/*
 Class should depend on interface rather than concrete class

 */
public class Macbook {
    private final WiredKeyBoard keyboard; // here it is using concrete class, which violates the dependency inversion principle
    private final WiredMouse mouse;

    public Macbook(WiredKeyBoard keyboard, WiredMouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}
