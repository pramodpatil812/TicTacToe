package org.example;

import org.example.models.*;
import org.example.strategies.move.FirstAvailableMoveStrategy;
import org.example.strategies.move.MoveStrategy;
import org.example.strategies.move.RandomMoveStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Ask for symbol+other details as a user input for HumanPlayer
        System.out.println("Enter symbol for HumanPlayer: ");
        Scanner scanner = new Scanner(System.in);
        Symbol symbol = Symbol.valueOf(scanner.nextLine());
        System.out.println("Enter name for HumanPlayer: ");
        String name = scanner.nextLine();
        System.out.println("Enter email for HumanPlayer: ");
        String email = scanner.nextLine();
        Player humanPlayer = new HumanPlayer(symbol, name, email);

        //Assign symbol for other player
        Symbol botSymbol = getBotSymbol(symbol);
        DifficultyLevel level = DifficultyLevel.EASY;
        MoveStrategy moveStrategy = getMoveStrategy(DifficultyLevel.EASY);
        Player botPlayer = new BotPlayer(botSymbol, "Bot1", DifficultyLevel.EASY, moveStrategy);

        //start the game
        TicTacToe ticTacToe = new TicTacToe(List.of(humanPlayer, botPlayer), 3);
        ticTacToe.start();
    }

    private static MoveStrategy getMoveStrategy(DifficultyLevel difficultyLevel) {
        if(difficultyLevel == DifficultyLevel.EASY) {
            return new FirstAvailableMoveStrategy();
        }
        return new RandomMoveStrategy();
    }

    private static Symbol getBotSymbol(Symbol humanSymbol) {
        if(humanSymbol == Symbol.O) {
            return Symbol.X;
        }
        return Symbol.O;
    }
}