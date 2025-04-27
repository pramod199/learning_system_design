package lld.DesignUberOla;

public class Driver {

    String name;
    boolean isAvailable;
    Double rating;

    public Driver(String name, Double rating) {
        this.name = name;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    public Double getRating() {
        return rating;
    }
}
