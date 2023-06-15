package com.myscaler.tictactoe.Strategies.WinningStratergies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myscaler.tictactoe.Models.Board;
import com.myscaler.tictactoe.Models.Move;
import com.myscaler.tictactoe.Models.Player;
import com.myscaler.tictactoe.Models.Symbol;

public class DiagonalWinningStratergies implements WinningStratergies {

    private Map<Symbol, Integer> leftDaigonalMap;
    private Map<Symbol, Integer> rightDaigonalMap;

    public DiagonalWinningStratergies(List<Player> players) {
        leftDaigonalMap = new HashMap<>();
        rightDaigonalMap = new HashMap<>();

        for (Player player : players) {
            leftDaigonalMap.put(player.getSymbol(), 0);
            rightDaigonalMap.put(player.getSymbol(), 0);
        }
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if (row == col) {
            leftDaigonalMap.put(symbol, leftDaigonalMap.get(symbol) + 1);
        }

        if (row + col == board.getSize() - 1) {
            rightDaigonalMap.put(symbol, rightDaigonalMap.get(symbol) + 1);
        }

        if (row == col)
            return leftDaigonalMap.get(symbol) == board.getSize();
        if (row + col == board.getSize() - 1)
            return rightDaigonalMap.get(symbol) == board.getSize();

        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if (row == col) {
            leftDaigonalMap.put(symbol, leftDaigonalMap.get(symbol) - 1);
        }

        if (row + col == board.getSize() - 1) {
            rightDaigonalMap.put(symbol, rightDaigonalMap.get(symbol) - 1);
        }

    }
}
