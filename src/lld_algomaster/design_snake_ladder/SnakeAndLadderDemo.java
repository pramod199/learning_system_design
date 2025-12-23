package lld_algomaster.design_snake_ladder;

import lld_algomaster.design_snake_ladder.models.Board;
import lld_algomaster.design_snake_ladder.models.Dice;
import lld_algomaster.design_snake_ladder.models.Jump;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderDemo {
    public static void main(String[] args) {
        List<Jump> jumps = List.of(
                new Jump(17, 7), new Jump(54, 34),
                new Jump(62, 19), new Jump(98, 79),
                new Jump(3, 38), new Jump(24, 33),
                new Jump(42, 93), new Jump(72, 84)
        );

        List<String> players = Arrays.asList("Alice", "Bob", "Charlie");

        Board board = new Board(100, jumps);
        Dice dice = new Dice(1, 6);

        Game game = new Game(board, dice, players);
        game.play();
    }
}
