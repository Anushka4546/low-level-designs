package TicTacToe;

public enum Symbol {
    X('X'), O('O');

    private final char value;
    
    Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }
}