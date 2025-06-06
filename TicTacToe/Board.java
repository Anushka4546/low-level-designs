package TicTacToe;

public class Board {
    private int size;
    private Symbol[][] grid;
    private int moves; 

    Board() {
        this(3);
    }

    Board(int size) {
        this.size = size;
        this.grid = new Symbol[this.size][this.size];
        this.moves = 0;
    }

    public boolean isCellEmpty(int i, int j) {
        return this.grid[i][j] == null;
    } 

    private boolean isValidMove(int i, int j) {
        return i >= 0 && j >= 0 && i < this.size && j < this.size && this.isCellEmpty(i, j);
    }

    public boolean placeMove(int i, int j, Symbol s) {
        if(this.isValidMove(i, j)) {
            this.grid[i][j] = s;
            this.moves++;
            return true;
        } else {
            System.out.println("Invalid Move! Try again!");
            return false;
        }
    }

    public boolean isFull() {
        return this.moves == this.size * this.size;
    }

    public void printBoard() {
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                if(this.grid[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(this.grid[i][j] + " ");
                }
                
            }
            System.out.println();
        }
    }

    public int getSize() {
        return this.size;
    }

    public Symbol[][] getGrid() {
        return this.grid;
    }
}
