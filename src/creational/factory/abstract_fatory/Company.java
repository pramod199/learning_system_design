package creational.factory.abstract_fatory;

public abstract class Company {

    public Gpu assembleGpu() {
        Gpu gpu = createGpu();
        gpu.assemble();
        return gpu;
    }

    public abstract Gpu createGpu(); // creational factory method
}
