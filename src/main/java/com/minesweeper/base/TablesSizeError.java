package com.minesweeper.base;

public class TablesSizeError extends Exception {
    private final String message = "Visable Table and Games table sizes doesn't match!";
    public TablesSizeError() {
        super();
    }

    public void message() {
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }
}
