package org.example.models;

import lombok.Getter;
import org.example.strategies.move.MoveStrategy;

@Getter
public class BotPlayer extends Player {
    private DifficultyLevel level;
    private MoveStrategy moveStrategy;

    public BotPlayer(Symbol symbol, String name, DifficultyLevel level, MoveStrategy moveStrategy) {
        super(symbol, name);
        this.level = level;
        this.moveStrategy = moveStrategy;
    }

    @Override
    public CellCoordinate makeMove(Board board) {
        return moveStrategy.makeMove(board, symbol);
    }

    //This implementation has if-else hell and violate OCP and SRP. Hence we can implement strategy pattern
    /*
    public MoveCoordinate makeMove(Board board) {
        if(level == DifficultyLevel.EASY) {
            //Place symbol randomly in any of the board coordinate
        }
        else if(level == DifficultyLevel.MEDIUM) {
            //more intelligent logic to place symbol
        }
        else if(level == DifficultyLevel.HARD) {
            //Even more intelligent logic to place symbol
        }
    }
     */

}
