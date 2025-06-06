package TicTacToe;

import java.util.Scanner;

abstract public class Player {
    private String name;
    private Symbol symbol;

    Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public abstract Move getMove(Board board, Scanner scn);

    public String getName() {
        return this.name;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }
}
