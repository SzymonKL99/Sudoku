package com.kodilla.sudoku;

import java.util.Arrays;
import java.util.Scanner;

public class SudokuGame {

    private SudokuBoard sudokuBoard = new SudokuBoard();
    private SudokuPrinter sudokuPrinter = new SudokuPrinter();
    private Scanner scanner = new Scanner(System.in);
    private String choice;


    @Override
    public String toString() {
        return sudokuBoard.toString();
    }

    public boolean resolveSudoku() {
        inicialize();
        fillInProcess();
        solveSudoku();
        return endGameQuestion();
    }

    private void fillInProcess() {
        System.out.println("Welcome in sudoku App");
        boolean endFilling;
        do {
            System.out.println(this.toString());
            System.out.println("Give number of row: ");
            int row = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Give number of column: ");
            int column = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Give value: ");
            int value = scanner.nextInt();
            scanner.nextLine();
            sudokuBoard.addNumberToSudoku(row, column, value);
            endFilling = checkEndFillingIn();
        } while (!endFilling);
    }

    private boolean checkEndFillingIn() {
        System.out.println("Do you wanna end fill in number in sudoku? y/n");
        choice = scanner.nextLine();
        return (choice.equals("y"));
    }

    private boolean endGameQuestion() {
        System.out.println("y - end game || n - start again");
        choice = scanner.nextLine();
        return (choice.equals("y"));
    }

    private void inicialize() {
        sudokuBoard.initBoard();
    }

    private void solveSudoku() {
        do {
            System.out.println(this.toString());
            System.out.println("Pleas write SUDOKU to get a solution");
            choice = scanner.nextLine();
        } while (!choice.equals("SUDOKU"));

        try {
            SudokuSolver sudokuSolver = new SudokuSolver(sudokuBoard);
            SudokuBoard result = sudokuSolver.solve();
            sudokuPrinter.print(result);
        } catch (CloneNotSupportedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

}
