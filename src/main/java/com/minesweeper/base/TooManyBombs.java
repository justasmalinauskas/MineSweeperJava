package com.minesweeper.base;

public class TooManyBombs extends Exception {

    private final String message = "Too many bombs in field for a nice game!";
    public TooManyBombs() {
        super();
    }

    public void message() {
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }

}
