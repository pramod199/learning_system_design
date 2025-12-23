package lld_algomaster.design_tic_tac_toe.state;

import lld_algomaster.design_tic_tac_toe.Game;
import lld_algomaster.design_tic_tac_toe.models.Player;

public interface GameState {
    void handleMove(Game game, Player player, int row, int col);
}
