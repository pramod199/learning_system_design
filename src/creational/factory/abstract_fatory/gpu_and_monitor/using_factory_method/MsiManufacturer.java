package creational.factory.abstract_fatory.gpu_and_monitor.using_factory_method;

public class MsiManufacturer extends Company {
    // problem: if we add more components, we will have to open these methods and change them
    @Override
    public Component createComponent(String type) {

        Component component = null;
        if ("GPU".equals(type)) {
            component = new MsiGpu();
        } else {
            component = new MsiMonitor();
        }
        return component;
    }
}
