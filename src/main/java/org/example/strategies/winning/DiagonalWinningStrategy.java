package org.example.strategies.winning;

import org.example.models.Board;
import org.example.models.Player;
import org.example.models.Symbol;

import java.util.Objects;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean check(Board board) {
        Symbol[][] symbols = board.getBoard();
        int i = 0, j = 0;
        Symbol diagonalFirstSymbol = symbols[i][j];
        boolean win = true;
        if(Objects.isNull(diagonalFirstSymbol)) {
            win = false;
        }
        else {
            i++;
            j++;
            while (i < board.getSize()) {
                if (!diagonalFirstSymbol.equals(symbols[i][j])) {
                    win = false;
                    break;
                }
                i++;
                j++;
            }
        }

        if(win) {
            return true;
        }

        i = board.getSize() - 1;
        j = 0;
        diagonalFirstSymbol = symbols[i][j];
        win = true;
        if(Objects.isNull(diagonalFirstSymbol)) {
            win = false;
        }
        else {
            i--;
            j++;
            while (i > 0) {
                if (!diagonalFirstSymbol.equals(symbols[i][j])) {
                    win = false;
                    break;
                }
                i--;
                j++;
            }
        }

        return win;
    }
}
