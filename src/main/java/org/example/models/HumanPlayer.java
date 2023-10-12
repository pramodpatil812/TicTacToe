package org.example.models;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class HumanPlayer extends Player {
    private String email;
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(Symbol symbol, String name, String email) {
        super(symbol, name);
        this.name = name;
        this.email = email;
    }

    @Override
    public CellCoordinate makeMove(Board board) {
        //take user input for cell coordinates
        System.out.println("Enter cell coordinates for move");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        //validate coordinates - Optional, as it's anyway being validated in fillSymbol method

        board.fillSymbol(row, col, symbol);
        return new CellCoordinate(row, col);
    }
}
