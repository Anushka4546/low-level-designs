package TicTacToe;

public class PlayerFactory {
    public static Player createPlayer(String type, String name, Symbol symbol) {
        if(type.equalsIgnoreCase("Human")) {
            return new HumanPlayer(name, symbol);
        } else if(type.equalsIgnoreCase("Computer")) {
            return new ComputerPlayer(name, symbol);
        } else {
           throw new IllegalArgumentException("Unknown player type: " + type);
        }
    }
}
