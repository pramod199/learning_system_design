package creational.factory.abstract_fatory.gpu_and_monitor.using_factory_method;

public abstract class Company {

    // business logic can be added here.

    public abstract Component createComponent(String type); // type param added to know monitor or gpu.
}
