package TicTacToe;

import java.util.Scanner;

public class ComputerPlayer extends Player {
    ComputerPlayer(String name, Symbol symbol) {
        super(name, symbol);
    }

    @Override
    public Move getMove(Board board, Scanner scn) {
        // simple logic for now
        for(int i = 0; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                if(board.isCellEmpty(i, j)) {
                    return new Move(i, j);
                }
            }
        }

        return null;
    }
}
