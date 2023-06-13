package com.myscaler.tictactoe.Models;

import java.util.ArrayList;
import java.util.List;

import com.myscaler.tictactoe.Strategies.WinningStratergies.WinningStratergies;

public class Game {
    private List<Move> moves;
    private Board board;
    private List<Player> players;
    private int currentMovePlayerIndex;
    private List<WinningStratergies> winningStratergies;
    private GameStatus gameStatus;
    private Player winner;

    public Game(int dimension, List<Player> players, List<WinningStratergies> winningStratergies, GameStatus gameStatus,
            Player winner) {
        this.moves = new ArrayList<>();
        this.board = new Board(dimension);
        this.players = players;
        this.currentMovePlayerIndex = 0;
        this.winningStratergies = winningStratergies;
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentMovePlayerIndex() {
        return currentMovePlayerIndex;
    }

    public void setCurrentMovePlayerIndex(int currentMovePlayerIndex) {
        this.currentMovePlayerIndex = currentMovePlayerIndex;
    }

    public List<WinningStratergies> getWinningStratergies() {
        return winningStratergies;
    }

    public void setWinningStratergies(List<WinningStratergies> winningStratergies) {
        this.winningStratergies = winningStratergies;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

}
