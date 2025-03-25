package lld.solid_principles.dependency_inversion;

public class WiredKeyBoard implements KeyBoard {
    @Override
    public void type() {
        System.out.println("Wired Keyboard typing");
    }
}
