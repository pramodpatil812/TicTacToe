package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class Player {
    protected Symbol symbol;
    protected String name;

    //makeMove needs to place player's symbol in board and hence Board is needed as parameter
    public abstract CellCoordinate makeMove(Board board);
}
