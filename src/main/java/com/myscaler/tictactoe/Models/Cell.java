package com.myscaler.tictactoe.Models;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }

    // Display the cell method logic******************
    public void display() {
        if (getCellState().equals(CellState.EMPTY)) {
            System.out.println("- |");
        } else {
            System.out.println(getPlayer().getSymbol().getaChar() + " |");
        }
    }

    // Gatters and Setters *****************************
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
