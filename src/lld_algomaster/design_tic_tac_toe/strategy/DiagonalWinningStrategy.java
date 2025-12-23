package lld_algomaster.design_tic_tac_toe.strategy;

import lld_algomaster.design_tic_tac_toe.models.Board;
import lld_algomaster.design_tic_tac_toe.models.Player;

public class DiagonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Player player, int row, int col) {
        int n = board.getSize();
        // main diagonal
        boolean mainDiagonal = true;
        for (int i = 0; i< board.getSize(); i++){
            if (board.getCell(i, i).getSymbol() != player.getSymbol()){
                mainDiagonal = false;
                break;
            }
        }
        if (mainDiagonal) {
            return true;
        }

        // anti diagonal

        boolean antiDiagonal = true;
        for (int i = 0; i< n; i++) {
            if (board.getCell(i, n-1-i).getSymbol() != player.getSymbol()){
                antiDiagonal = false;
                break;
            }
        }
        return antiDiagonal;
    }
}