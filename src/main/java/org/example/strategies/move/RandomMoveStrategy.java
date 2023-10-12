package org.example.strategies.move;

import org.example.models.Board;
import org.example.models.CellCoordinate;
import org.example.models.Symbol;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public CellCoordinate makeMove(Board board, Symbol symbol) {
        //get available cell coordinates from board
        //randomly choose one of the available cell coordinates
        //board.placeSymbol(row, col, symbol);
        return new CellCoordinate(-1, -1);
    }
}
