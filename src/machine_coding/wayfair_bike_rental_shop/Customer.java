package machine_coding.wayfair_bike_rental_shop;

import machine_coding.wayfair_bike_rental_shop.enums.HumanSize;

class Customer {
    Long id;
    String name;
    String phone;
    HumanSize size;

    public Customer(Long id, String name, String phone, HumanSize size) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.size = size;
    }
}
