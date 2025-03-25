package creational.factory.abstract_fatory;

public class Client {
    public static void main(String[] args) {
        Company asusManufacturer = new AsusManufacturer();
        asusManufacturer.assembleGpu();


    }
}
