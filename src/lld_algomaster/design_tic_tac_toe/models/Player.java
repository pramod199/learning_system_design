package lld_algomaster.design_tic_tac_toe.models;

import lld_algomaster.design_tic_tac_toe.enums.Symbol;

public class Player {
    private final String name;

    private final Symbol symbol;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
