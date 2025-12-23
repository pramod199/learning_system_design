package lld_algomaster.design_tic_tac_toe.state;

import lld_algomaster.design_tic_tac_toe.Game;
import lld_algomaster.design_tic_tac_toe.exceptions.InvalidMoveException;
import lld_algomaster.design_tic_tac_toe.models.Player;

public class DrawState implements GameState {

    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        throw new InvalidMoveException("Game is already over. It was a draw.");
    }
}