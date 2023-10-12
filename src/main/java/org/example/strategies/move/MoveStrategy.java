package org.example.strategies.move;

import org.example.models.Board;
import org.example.models.CellCoordinate;
import org.example.models.Symbol;

public interface MoveStrategy {
    CellCoordinate makeMove(Board board, Symbol symbol);
}
