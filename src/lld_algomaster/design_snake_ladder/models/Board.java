package lld_algomaster.design_snake_ladder.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private final Map<Integer, Integer> snakesAndLadders;

    public Board(int size, List<Jump> jumps) {
        this.size = size;
        this.snakesAndLadders = new HashMap<>();
        for (Jump jump : jumps) {
            snakesAndLadders.put(jump.getStart(), jump.getEnd());
        }
    }

    public int getSize(){
        return size;
    }

    public int getFinalPosition(int position) {
        return snakesAndLadders.getOrDefault(position, position);
    }
}
