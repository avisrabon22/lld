package com.myscaler.tictactoe.Strategies.BotWinningStratergies;

import java.util.List;

import com.myscaler.tictactoe.Models.Board;
import com.myscaler.tictactoe.Models.Cell;
import com.myscaler.tictactoe.Models.CellState;

public class EasyBotWinningStratergies implements botWinningStratergies {

    @Override
    public Cell makeMove(Board board) {

        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return cell;
                }
            }
        }

        return null;
    }

}
