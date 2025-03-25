package lld.solid_principles.liscov_substitution.another_example.fix;

/*
parent class should have only very generic method, which can be overridden by child class
and child class can have more specific methods
 */
public class Vehicle {
    public Integer getNumberOfWheels() {
        return 2;
    }

//    public Boolean hasEngine() {
//        return true;
//    }

}
