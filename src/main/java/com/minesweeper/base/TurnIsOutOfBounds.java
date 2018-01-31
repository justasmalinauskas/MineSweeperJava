package com.minesweeper.base;

public class TurnIsOutOfBounds extends Exception {

    private final String message = "Coordinate you entered is out of field!";

    public TurnIsOutOfBounds() {
        super();
    }

    public void message() {
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }
}
