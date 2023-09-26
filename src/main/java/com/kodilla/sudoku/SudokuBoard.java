package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype {

    private List<SudokuRow> sudokuRowList = new ArrayList<>();

    public SudokuBoard() {
    }

    public void initBoard() {
        for (int i = 0; i < 9; i++) {
            sudokuRowList.add(new SudokuRow());
        }
        for (SudokuRow sudokuRow : sudokuRowList) {
            sudokuRow.getEmptyRow();
        }
    }

    public void addNumberToSudoku(int x, int y, int number) {
        sudokuRowList.get(x - 1).getSudokuRowElements().set(y - 1, new SudokuElement(number));
    }

    public List<SudokuRow> getSudokuRowList() {
        return sudokuRowList;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard cloneSudokuBoard = (SudokuBoard) super.clone();
        cloneSudokuBoard.sudokuRowList = new ArrayList<>();
        for (SudokuRow sudokuRowList : sudokuRowList) {
            SudokuRow cloneSudokuRow = new SudokuRow();
            for (SudokuElement sudokuElement : sudokuRowList.getSudokuRowElements()) {
                cloneSudokuRow.getSudokuRowElements().add(sudokuElement);
            }
            cloneSudokuBoard.getSudokuRowList().add(cloneSudokuRow);
        }
        return cloneSudokuBoard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("    1   2   3   4   5   6   7   8   9\n");

        for (int i = 0; i < 9; i++) {
            sb.append(i + 1).append(" |");
            for (int j = 0; j < 9; j++) {
                int value = sudokuRowList.get(i).getSudokuRowElements().get(j).getValue();
                String valueString = value == SudokuElement.EMPTY ? " - " : " " + value + " ";
                sb.append(valueString);
                if (j == 2 || j == 5) {
                    sb.append("|");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("|\n");
            if (i == 2 || i == 5) {
                sb.append("   -------------------------------\n");
            }
        }
        return sb.toString();
    }
}
