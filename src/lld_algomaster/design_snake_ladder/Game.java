package lld_algomaster.design_snake_ladder;

import lld_algomaster.design_snake_ladder.enums.GameStatus;
import lld_algomaster.design_snake_ladder.models.Board;
import lld_algomaster.design_snake_ladder.models.Dice;
import lld_algomaster.design_snake_ladder.models.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private final Board board;

    private final Queue<Player> players;

    private final Dice dice;

    private GameStatus status;
    private Player winner;

    public Game(Board board, Dice dice, List<String> playerNames) {
        this.board = board;
        this.dice = dice;
        players = new LinkedList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        this.status = GameStatus.NOT_STARTED;
    }

    public void play(){
        if (players.size() < 2) {
            System.out.println("Cannot start game. At least 2 players are required.");
            return;
        }

        this.status = GameStatus.RUNNING;
        System.out.println("Game started!");

        while (status == GameStatus.RUNNING) {
            Player currentPlayer = players.poll();
            takeTurn(currentPlayer);
            // If the game is not finished and the player didn't roll a 6, add them back to the queue
            if (status == GameStatus.RUNNING) {
                players.add(currentPlayer);
            }
        }

        System.out.println("Game Finished!");
        if (winner != null) {
            System.out.println("Winner is " + winner.getName());
        }
    }

    private void takeTurn(Player player) {
        int roll = dice.roll();
        System.out.println(player.getName() + "'s turn. Rolled a " + roll);

        int currentPosition = player.getPosition();
        int nextPosition = currentPosition + roll;

        if (nextPosition > board.getSize()) {
            System.out.printf("Oops, %s need to land exactly on %d. Turn skipped. \n", player.getName(), board.getSize());
            return;
        }

        int finalPosition = board.getFinalPosition(nextPosition);

        if (finalPosition > nextPosition) { // Ladder
            System.out.printf("Wow! %s found a ladder 🪜 at %d and climbed to %d.\n", player.getName(), nextPosition, finalPosition);
        } else if (finalPosition < nextPosition) { // Snake
            System.out.printf("Oh no! %s was bitten by a snake 🐍 at %d and slid down to %d.\n", player.getName(), nextPosition, finalPosition);
        } else {
            System.out.printf("%s moved from %d to %d.\n", player.getName(), currentPosition, finalPosition);
        }

        player.setPosition(finalPosition);

        if (finalPosition == board.getSize()) {
            this.winner = player;
            this.status = GameStatus.FINISHED;
            System.out.printf("Hooray! %s reached the final and won!", player.getName());
            return;
        }

        if (roll == 6) {
            System.out.printf("%s rolled a 6 and gets another turn!\n", player.getName());
            takeTurn(player);
        }
    }

}
