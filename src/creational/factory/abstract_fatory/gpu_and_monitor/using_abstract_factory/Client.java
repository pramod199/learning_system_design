package creational.factory.abstract_fatory.gpu_and_monitor.using_abstract_factory;

public class Client {
    public static void main(String[] args) {
        Company msi  = new MsiManufacturer();
        Gpu gpu = msi.createGpu();
        Monitor msiMonitor = msi.createMonitor();

        Company asusManufacturer = new AsusManufacturer();
        Gpu asusGpu = asusManufacturer.createGpu();
        Monitor asusMonitor = asusManufacturer.createMonitor();


    }
}
