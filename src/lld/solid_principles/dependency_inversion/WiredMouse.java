package lld.solid_principles.dependency_inversion;

public class WiredMouse implements Mouse {
    @Override
    public void type() {
        System.out.println("Wired Mouse");
    }
}
