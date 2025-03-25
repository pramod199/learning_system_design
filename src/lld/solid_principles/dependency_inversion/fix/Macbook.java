package lld.solid_principles.dependency_inversion.fix;

import lld.solid_principles.dependency_inversion.KeyBoard;
import lld.solid_principles.dependency_inversion.Mouse;
import lld.solid_principles.dependency_inversion.WiredKeyBoard;
import lld.solid_principles.dependency_inversion.WiredMouse;

/*
 Class should depend on interface rather than concrete class

 */
public class Macbook {
    private final KeyBoard keyboard; // here it is using interface rather than concrete class, which adheres to the dependency inversion principle
    private final Mouse mouse;

    public Macbook(KeyBoard keyboard, Mouse mouse) { // using constructor injection, now we can use wired, bluetooth or any other type of keyboard and mouse
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}
