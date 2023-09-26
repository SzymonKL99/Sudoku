package com.kodilla.sudoku;

public class SudokuStart {
    public static void main(String[] args) {

        boolean gameFinished = false;
        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();
        }

    }
}
