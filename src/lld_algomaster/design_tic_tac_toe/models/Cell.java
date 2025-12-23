package lld_algomaster.design_tic_tac_toe.models;

import lld_algomaster.design_tic_tac_toe.enums.Symbol;

public class Cell {
    private Symbol symbol;

    public Cell() {
        symbol = Symbol.EMPTY;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
