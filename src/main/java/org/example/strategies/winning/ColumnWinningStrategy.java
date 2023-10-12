package org.example.strategies.winning;

import org.example.models.Board;
import org.example.models.Player;
import org.example.models.Symbol;

import java.util.Objects;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean check(Board board) {
        //On every move check method is called and checks for all the columns if player has all his symbol drawn in any of the columns.
        //This can be optimized by passing symbol and the column id of the move. Then "check" will only perform comparison in the
        //same column for the passed symbol.
        Symbol[][] symbols = board.getBoard();
        Symbol colFirstSymbol;
        for(int j = 0; j < board.getSize(); j++) {
            boolean win = true;
            colFirstSymbol = symbols[0][j];
            if(Objects.isNull(colFirstSymbol)) {
                continue;
            }
            for (int i = 1; i < board.getSize(); i++) {
                Symbol symbol = symbols[i][j];
                if (!colFirstSymbol.equals(symbol)) {
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
