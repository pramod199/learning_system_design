package lld_algomaster.bookmyshow.entities;


import java.util.List;

public class Theatre {
    private String id;
    private String name;
    private String address;
    private City city;
    private List<Screen> screens;

    public Theatre(String id, String name, String address, City city, List<Screen> screens) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.screens = screens;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public City getCity() {
        return city;
    }

    public List<Screen> getScreens() {
        return screens;
    }
}