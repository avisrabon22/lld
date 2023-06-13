package com.myscaler.tictactoe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();

        for (int i = 0; i < size; ++i) {
            board.add(new ArrayList<Cell>());
            for (int j = 0; j < size; ++j) {
                board.get(i).add(new Cell(i, j));
            }

        }
    }

    public int getSize() {
        return size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

}
