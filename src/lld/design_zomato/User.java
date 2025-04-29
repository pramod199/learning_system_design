package lld.design_zomato;

public class User {
    private String name;
    private Location location;

    public User(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public String getId() {
        return name;
    }

}
