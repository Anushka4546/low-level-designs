package TicTacToe;

public class Move {
    private int row;
    private int col;

    Move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}