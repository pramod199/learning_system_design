package lld_algomaster.design_tic_tac_toe;

import lld_algomaster.design_tic_tac_toe.enums.Symbol;
import lld_algomaster.design_tic_tac_toe.models.Player;

public class TicTacToeDemo {
    public static void main(String[] args) {
        TicTacToeSystem system = TicTacToeSystem.getInstance();

        Player alice = new Player("ALice", Symbol.X);
        Player bob = new Player("Bob", Symbol.O);

        // Game1: ALice wins
        System.out.println("--- GAME 1: Alice (X) vs. Bob (O) ---");
        system.createGame(alice, bob);

        system.startGame();
        System.out.println("----------------------------------------\n");

        system.createGame(alice, bob);
        system.startGame();
    }
}
