package lld.solid_principles.liscov_substitution;

/*
 If class B is a subclass of class A, then we should be able to replace A with B without affecting the behavior of our program.

 subclass should extend the capability of parent , should not narrow it down.
 */
public interface Bike {
    void turnOnEngine();
    void accelerate();
}
