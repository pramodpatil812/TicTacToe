package org.example.models;

import lombok.Getter;
import org.example.exceptions.InvalidArgumentException;

import java.util.Objects;

@Getter
public class Board {
    private Symbol[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new Symbol[size][size];
    }

    public void fillSymbol(int row, int col, Symbol symbol) {
        if(!isValidCell(row, col) || !isCellEmpty(row, col)) {
            System.out.println("isValidCell(row, col) " + isValidCell(row, col));
            System.out.println("isCellEmpty(row, col) " + isCellEmpty(row, col));
            throw new InvalidArgumentException("Invalid cell coordinates: "+row + ", "+col);
        }
        board[row][col] = symbol;
    }

    public void print() {
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Symbol symbol = board[i][j];
                if (Objects.isNull(symbol)) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + symbol + " | ");
                }
                //System.out.print(symbol == Symbol.O ? " O " : (symbol == Symbol.X ? " X " : " "));
            }
            System.out.println();
        }
    }

    private boolean isCellEmpty(int row, int col) {
        //if(!isValidCell(row, col))   return false;
        for(Symbol symbol : Symbol.values()) {
            if(board[row][col] == symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidCell(int row, int col) {
        return ((row >= 0 && row < size) && (col >= 0 && col < size));
    }
}
