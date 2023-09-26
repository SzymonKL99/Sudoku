package com.kodilla.sudoku;

public class SudokuPrinter {

    public void print(SudokuBoard sudokuBoard) {
        System.out.println("Sudoku");
        String boardString = sudokuBoard.toString();
        System.out.println(boardString);
    }
}
