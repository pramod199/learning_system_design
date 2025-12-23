package lld_algomaster.design_tic_tac_toe.strategy;

import lld_algomaster.design_tic_tac_toe.models.Board;
import lld_algomaster.design_tic_tac_toe.models.Player;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Player player, int row, int col) {
        for (int j = 0; j < board.getSize(); j++) {
            if (board.getCell(row, j).getSymbol() != player.getSymbol()) {
                return false;
            }
        }
        return true;
    }

}
