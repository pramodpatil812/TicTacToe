package org.example.models;

import org.example.strategies.winning.ColumnWinningStrategy;
import org.example.strategies.winning.DiagonalWinningStrategy;
import org.example.strategies.winning.RowWinningStrategy;
import org.example.strategies.winning.WinningStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TicTacToe {
    private List<Player> players;
    private Board board;
    private int nextPlayerIndex;
    private GameStatus status;
    private Player winningPlayer;
    private final List<WinningStrategy> winningStrategies = Arrays.asList(new RowWinningStrategy(), new ColumnWinningStrategy(), new DiagonalWinningStrategy());

    public TicTacToe(List<Player> players, int size) {
        this.players = players;
        board = new Board(size);

        //this is the player index who has the next turn for move. This index value can also be taken in constructor argument
        //if caller wants to control who starts the game
        nextPlayerIndex = 0;
        status = GameStatus.IN_PROGRESS;
    }

    public void start() {
        //loop until match is win/drawn
        //Get user input for player if he is a HumanPlayer
        //call move for selected player
        //check for winner condition
        //check for draw condition

        while(!status.equals(GameStatus.FINISHED)) {
            CellCoordinate cellCoordinates = players.get(nextPlayerIndex).makeMove(board);
            System.out.println("Player's move was at : "+cellCoordinates.getRow() + ", "+ cellCoordinates.getColumn());
            board.print();
            boolean win = checkWinner();
            if(win) {
                Player winner = players.get(nextPlayerIndex);
                System.out.printf("Player "+winner.getName() +" has won");
                break;
            }
            if(checkDraw()) {
                System.out.println("Match has drawn");
                break;
            }
            nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
        }
    }

    private boolean checkWinner() {
        //check if any of the player has won and return player
        //One way is to check for rows, columns and diagonals in the same function, but it's a violation of OCP and SRP. Instead, we can have winning strategies
        //and call their methods to check win
        /*
        checkRows();
        checkColumns();
        checkDiagonals();
        */

        //Optimization: If once winner has been checked then status must be already set to FINISHED
        if(status.equals(GameStatus.FINISHED)) {
            return true;
        }

        for(WinningStrategy winningStrategy : winningStrategies) {
            if(winningStrategy.check(board)) {
                status = GameStatus.FINISHED;
                return true;
            }
        }
        return false;
    }

    private boolean checkDraw() {
        if(checkWinner()) {
            return false;
        }

        Symbol[][] symbols = board.getBoard();
        for(int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Symbol symbol = symbols[i][j];
                if(Objects.isNull(symbol)) {
                    return false;
                }
            }
        }
        return true;
    }
}
