package lld_algomaster.design_tic_tac_toe.strategy;

import lld_algomaster.design_tic_tac_toe.models.Board;
import lld_algomaster.design_tic_tac_toe.models.Player;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Player player, int row, int col) {
        for(int i = 0; i< board.getSize(); i++){
            if (board.getCell(i, col).getSymbol() != player.getSymbol()) {
                return false;
            }
        }
        return true;
    }
}
