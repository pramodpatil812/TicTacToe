package org.example.strategies.winning;

import org.example.models.Board;
import org.example.models.Player;

public interface WinningStrategy {
    boolean check(Board board);
}
