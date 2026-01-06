package lld_algomaster.bookmyshow.entities;

import java.util.ArrayList;
import java.util.List;

public class City {
    private final String id;
    private final String name;

    private List<Theatre> theatres = new ArrayList<>();

    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }
}