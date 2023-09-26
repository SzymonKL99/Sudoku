package com.kodilla.sudoku;


public class SudokuElement {

    public static final int EMPTY = -1;
    private int value;

    public SudokuElement(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "\t" + value ;
    }
}