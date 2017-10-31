package MineSweeperGame.Base.Exceptions;

public class TurnIsOutOfBounds extends Exception {

    private final String message = "Coordinate you entered is out of field!";

    public TurnIsOutOfBounds() {
        super();
    }

    public void Message() {
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }
}
