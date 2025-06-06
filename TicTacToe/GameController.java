package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    Board board;
    List<Player> players;
    Player currPlayer;
    Scanner scn;

    private void initializeGame() {
        this.board = new Board();
        players = new ArrayList<>();
        System.out.println("Option 1: Player vs Player");
        System.out.println("Option 2: Player vs Computer");
        scn = new Scanner(System.in);
        int op = scn.nextInt();
        scn.nextLine();

        if(op == 1) {
            System.out.println("Enter player1 and player2 name");
            String p1 = scn.nextLine();
            String p2 = scn.nextLine();

            players.add(new HumanPlayer(p1, Symbol.X));
            players.add(new HumanPlayer(p2, Symbol.O));
            currPlayer = players.get(0);
        } else if(op == 2) {
            System.out.println("Enter player name");
            String p1 = scn.nextLine();
            String p2 = "Computer";

            players.add(new HumanPlayer(p1, Symbol.X));
            players.add(new ComputerPlayer(p2, Symbol.O));
            currPlayer = players.get(0);
        }
    }

    public void startGame() {
        initializeGame();
        System.out.println("Start Game.....");
        this.board.printBoard();

        while(true) {
            Move move = currPlayer.getMove(board, scn);
            boolean isValid = this.board.placeMove(move.getRow(), move.getCol(), currPlayer.getSymbol());

            if(isValid) {
                EventType event = checkWinner();
                this.board.printBoard();
                if(event != EventType.INPROGRESS) {
                    break;
                } else {
                    this.switchPlayer();
                }
            } else if(this.board.isFull()) {
                System.out.println("DRAW!!");
                break;
            } else {
                System.out.println("Invalid Move! Try Again");
            }
        }
    }

    private EventType checkWinner() {
        if(checkWin()) {
            System.out.println("Congratulations, " + currPlayer.getName() +" You Win!!");
            return EventType.WIN;
        } else if(this.board.isFull()) {
            System.out.println("DRAW!");
            return EventType.DRAW;
        } else {
            return EventType.INPROGRESS;
        }
    }

    public void switchPlayer() {
        for(Player p: players) {
            if(!p.getName().equals(currPlayer.getName())) {
                currPlayer = p;
                break;
            }
        }
    }

    private boolean checkWin() {
        Symbol s = currPlayer.getSymbol();
        int size = board.getSize();
        Symbol[][] grid = board.getGrid();

        // Check rows
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != s) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            boolean win = true;
            for (int i = 0; i < size; i++) {
                if (grid[i][j] != s) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check main diagonal
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][i] != s) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check anti-diagonal
        win = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][size - i - 1] != s) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // No win found
        return false;
    }


}