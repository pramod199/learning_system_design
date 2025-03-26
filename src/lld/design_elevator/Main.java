package lld.design_elevator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Floor> floors = new ArrayList<>();
        floors.add(new Floor(1));
        floors.add(new Floor(2));
        floors.add(new Floor(3));
        floors.add(new Floor(4));
        floors.add(new Floor(5));

        Building building = new Building(floors);

    }

}
