package lld_algomaster.design_tic_tac_toe.state;

import lld_algomaster.design_tic_tac_toe.Game;
import lld_algomaster.design_tic_tac_toe.enums.GameStatus;
import lld_algomaster.design_tic_tac_toe.enums.Symbol;
import lld_algomaster.design_tic_tac_toe.exceptions.InvalidMoveException;
import lld_algomaster.design_tic_tac_toe.models.Player;

public class InProgressState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        if (game.getCurrentPlayer() != player) {
            throw new InvalidMoveException("Not your turn!");
        }

        game.getBoard().placeSymbol(row, col, player.getSymbol());

        if (game.checkWinner(player, row, col)){
            game.setWinner(player);
            game.setStatus(player.getSymbol() == Symbol.X ? GameStatus.WINNER_X : GameStatus.WINNER_O);
            game.setState(new WinnerState());
        } else if (game.getBoard().isFull()){
            game.setStatus(GameStatus.DRAW);
            game.setState(new DrawState());
        } else {
            game.switchPlayer();
        }

    }
}
