package TicTacToe;

import java.util.Scanner;

public class HumanPlayer extends Player{
    HumanPlayer(String name, Symbol symbol) {
        super(name, symbol);
    }

    @Override
    public Move getMove(Board board, Scanner scn) {
        System.out.println(this.getName() + ", enter your move (row and column): ");
        int r = scn.nextInt();
        int c = scn.nextInt();
        return new Move(r, c);
    }
}
