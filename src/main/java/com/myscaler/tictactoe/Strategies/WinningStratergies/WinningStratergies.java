package com.myscaler.tictactoe.Strategies.WinningStratergies;

import com.myscaler.tictactoe.Models.Board;
import com.myscaler.tictactoe.Models.Move;

public interface WinningStratergies {

    public boolean checkWinner(Board board, Move move);

}
