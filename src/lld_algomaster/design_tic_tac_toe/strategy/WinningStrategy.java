package lld_algomaster.design_tic_tac_toe.strategy;

import lld_algomaster.design_tic_tac_toe.models.Board;
import lld_algomaster.design_tic_tac_toe.models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player, int row, int col);
}