package lld.tik_tak_toe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public void printBoard() {
        // implement it
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }

    }

    public List<Pair<Integer, Integer>> getFreeSlots() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    Pair<Integer, Integer> rowColumn = new Pair<>(i, j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false;
        }

        if (board[row][col] == null) {
            board[row][col] = playingPiece;
            return true;
        }
        return false;
    }
}
