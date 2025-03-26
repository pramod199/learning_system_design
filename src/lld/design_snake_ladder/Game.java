package lld.design_snake_ladder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();

    Player winner;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5,4);
        board.printBoard();

        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        players.add(p1);
        players.add(p2);
    }

    public void startGame() {

        while (winner == null) {
            // check whose turn now.
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn: " + playerTurn.getName());

            // roll the dice
            int diceNumber = dice.rollDice();
            System.out.println("Dice number: " + diceNumber);

            int playerNewPosition = playerTurn.getPosition() + diceNumber;

            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.setPosition(playerNewPosition);

            System.out.println("Player new position: " + playerTurn.getPosition());

            // check winning condition
            if (playerTurn.getPosition() >= board.boardSize * board.boardSize) {
                winner = playerTurn;
                break;
            }
        }

        System.out.println("Winner is: " + winner.getName());
    }

    private int jumpCheck(int playerNewPosition) {
        if (playerNewPosition > board.boardSize * board.boardSize) {
            System.out.println("Invalid move, try again");
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if (cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = cell.jump.start > cell.jump.end ? "Snake" : "Ladder";
            System.out.println("Jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }

    private Player findPlayerTurn() {
        Player playerTurn = players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }

}
