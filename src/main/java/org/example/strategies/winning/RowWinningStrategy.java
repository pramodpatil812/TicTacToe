package org.example.strategies.winning;

import org.example.models.Board;
import org.example.models.Symbol;

import java.util.Objects;

public class RowWinningStrategy implements WinningStrategy {

    //On every move check method is called and checks for all the rows if player has all his symbol drawn in any of the rows
    //This can be optimized by passing symbol and the row id of the move. Then "check" will only perform comparison in the
    //same row for the passed symbol.
    @Override
    public boolean check(Board board) {
        Symbol[][] symbols = board.getBoard();
        Symbol rowFirstSymbol;
        for(int i = 0; i < board.getSize(); i++) {
            boolean win = true;
            rowFirstSymbol = symbols[i][0];
            if(Objects.isNull(rowFirstSymbol)) {
                continue;
            }
            for (int j = 1; j < board.getSize(); j++) {
                Symbol symbol = symbols[i][j];
                if (!rowFirstSymbol.equals(symbol)) {
                    win = false;
                    break;
                }
            }
            if(win) {
                return true;
            }
        }
        return false;
    }
}
