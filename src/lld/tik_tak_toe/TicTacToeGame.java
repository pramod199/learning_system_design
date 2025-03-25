package lld.tik_tak_toe;

import lld.tik_tak_toe.models.Board;
import lld.tik_tak_toe.models.Pair;
import lld.tik_tak_toe.models.PieceType;
import lld.tik_tak_toe.models.Player;
import lld.tik_tak_toe.models.PlayingPiece;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players; // we have taken deque as we wil be remove player from start and put at end.
    Board gameBoard;

    TicTacToeGame() {
        initializeGame();
    }

    private void initializeGame() {
        // initialize players
        players = new LinkedList<>();
        PlayingPiece crossX = new PlayingPiece(PieceType.X);
        players.add(new Player("Player 1", crossX));
        PlayingPiece crossO = new PlayingPiece(PieceType.O);
        players.add(new Player("Player 2", crossO));

        // initialize board
        gameBoard = new Board(3);
    }


    public String startGame() {
        boolean noWinner = true;

        while (noWinner) {
            // get player turn and put him on back of list.
            Player playerTurn = players.removeFirst();

            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSlots = gameBoard.getFreeSlots();
            if (freeSlots.isEmpty()) {
                noWinner = false;
                continue;
            }

            // read user input
            System.out.println("Player " + playerTurn.name + " Enter row and column");
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();

            // add player piece to board
            boolean pieceAdded = gameBoard.addPiece(row, col, playerTurn.playingPiece);
            if (!pieceAdded) {
                System.out.println("Invalid move, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner = isThereWinner(row, col, playerTurn.playingPiece);
            if (winner) {
                return "Player " + playerTurn.name + " wins";
            }

        }
        return "Game Over, tie";
    }

    // can be improved to do in O(1) -> check n queens problem
    private boolean isThereWinner(int row, int col, PlayingPiece playingPiece) {
        // check row
        boolean rowWinner = true;
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != playingPiece.pieceType) {
                rowWinner = false;
                break;
            }
        }
        if (rowWinner) {
            return true;
        }

        // check column
        boolean colWinner = true;
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][col] == null || gameBoard.board[i][col].pieceType != playingPiece.pieceType) {
                colWinner = false;
                break;
            }
        }
        if (colWinner) {
            return true;
        }

        // check diagonal
        boolean diagonalWinner = true;
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][i] == null || gameBoard.board[i][i].pieceType != playingPiece.pieceType) {
                diagonalWinner = false;
                break;
            }
        }
        if (diagonalWinner) {
            return true;
        }

        boolean reverseDiagonalWinner = true;
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][gameBoard.size - i - 1] == null || gameBoard.board[i][gameBoard.size - i - 1].pieceType != playingPiece.pieceType) {
                reverseDiagonalWinner = false;
                break;
            }
        }
        if (reverseDiagonalWinner) {
            return true;
        }

        return false;
    }
}
