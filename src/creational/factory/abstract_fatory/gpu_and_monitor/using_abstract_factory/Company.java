package creational.factory.abstract_fatory.gpu_and_monitor.using_abstract_factory;

public abstract class Company {
    // business logic can be added here

    public abstract Gpu createGpu();

    public abstract Monitor createMonitor();

}

/*
1. explicitly declare interfaces for each distinct product we have.
2. create creational.factory method for each abstract product.
 */
