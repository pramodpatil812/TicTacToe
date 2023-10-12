package org.example.strategies.move;

import org.example.models.Board;
import org.example.models.CellCoordinate;
import org.example.models.Symbol;

import java.util.Objects;

public class FirstAvailableMoveStrategy implements MoveStrategy {

    @Override
    public CellCoordinate makeMove(Board board, Symbol symbol) {
        Symbol[][] symbols = board.getBoard();
        //Iterate board cells and return first empty cell
        for(int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if(Objects.isNull(symbols[i][j])) {
                    board.fillSymbol(i, j, symbol);
                    return new CellCoordinate(i, j);
                }
            }
        }

        return new CellCoordinate(-1, -1);
    }
}
