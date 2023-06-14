package com.myscaler.tictactoe.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.myscaler.tictactoe.Strategies.WinningStratergies.WinningStratergies;

public class Game {
    private List<Move> moves;
    private Board board;
    private List<Player> players;
    private int currentMovePlayerIndex;
    private List<WinningStratergies> winningStratergies;
    private GameStatus gameStatus;
    private Player winner;

    // ***************************************************************8
    private Game(int dimension, List<Player> players, List<WinningStratergies> winningStratergies) {
        this.moves = new ArrayList<>();
        this.board = new Board(dimension);
        this.players = players;
        this.currentMovePlayerIndex = 0;
        this.winningStratergies = winningStratergies;
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    // Get builder class to set game**************
    public static Builder getBulder() {
        return new Builder();
    }

    // Check draw fo makeMove method********
    public boolean checkDraw() {
        if (moves.size() == board.getSize() * board.getSize()) {
            gameStatus = GameStatus.DRAW;
            return true;
        }
        return false;
    }

    // check winner for makeMove method**********
    private boolean checkWinner(Player currentPlayer, Move move) {
        for (WinningStratergies winningStratergy : winningStratergies) {
            if (winningStratergy.checkWinner(board, move)) {
                gameStatus = GameStatus.ENDED;
                winner = currentPlayer;
                return true;
            }

        }
        return false;
    }

    // Validate the move******************
    private boolean validateMove(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

        if (row >= board.getSize() || col >= board.getSize() || row < 0 || col < 0) {
            return false;
        }
        if (board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            return true;
        }
        return false;

    }

    // Make move method logic*********************
    public void makeMove() {
        Player currentPlayer = players.get(currentMovePlayerIndex);
        Cell proposedCell = currentPlayer.makeMove();
        if (!validateMove(proposedCell)) {
            return;
        }
        Cell cellOnBoard = board.getBoard().get(proposedCell.getRow()).get(proposedCell.getCol());
        cellOnBoard.setCellState(CellState.FILLED);
        cellOnBoard.setPlayer(currentPlayer);

        Move move = new Move(currentPlayer, cellOnBoard);
        moves.add(move);

        // for winning
        if (checkWinner(currentPlayer, move)) {
            return;
        }
        // for draw
        if (checkDraw()) {
            return;
        }

        currentMovePlayerIndex += 1;
        currentMovePlayerIndex %= players.size();
    }

    // print the board *************************************
    public void printBoard() {
        this.board.print();
    }

    // Print winner logic********************************
    public void printWinner() {
        System.out.println(winner);
    }

    // Print the result logic**********************************
    public void printResult() {
        if (gameStatus.equals(GameStatus.ENDED)) {
            System.out.println("The game is ended.");
            System.out.println("The winner is " + winner.getName());
        } else {
            System.out.println("Game is draw.");
        }
    }

    // Gatters and setters**********************************************
    public List<Move> getMoves() {
        return moves;
    }

    // *************************************
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    // *************************************
    public Board getBoard() {
        return board;
    }

    // *************************************
    public void setBoard(Board board) {
        this.board = board;
    }

    // *************************************
    public List<Player> getPlayers() {
        return players;
    }

    // *************************************
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    // *************************************
    public int getCurrentMovePlayerIndex() {
        return currentMovePlayerIndex;
    }

    // *************************************
    public void setCurrentMovePlayerIndex(int currentMovePlayerIndex) {
        this.currentMovePlayerIndex = currentMovePlayerIndex;
    }

    // *************************************
    public List<WinningStratergies> getWinningStratergies() {
        return winningStratergies;
    }

    // *************************************
    public void setWinningStratergies(List<WinningStratergies> winningStratergies) {
        this.winningStratergies = winningStratergies;
    }

    // *************************************
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    // *************************************
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    // *************************************
    public Player getWinner() {
        return winner;
    }

    // *************************************
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    // Builder inner class**************************
    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<WinningStratergies> winningStratergies;

        private Builder() {
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStratergies(List<WinningStratergies> winningStratergies) {
            this.winningStratergies = winningStratergies;
            return this;
        }

        // validate the input of user
        private boolean valid() {
            if (this.players.size() < 2) {
                return false;
            }
            if (this.players.size() != this.dimension - 1) {
                return false;
            }

            int botCount = 0;
            for (Player player : this.players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
            }
            if (botCount >= 2) {
                return false;
            }

            Set<Character> existingSymbols = new HashSet<>();

            for (Player player : this.players) {
                if (existingSymbols.contains(player.getSymbol().getaChar())) {
                    return false;
                }
                existingSymbols.add(player.getSymbol().getaChar());

            }
            return true;
        }

        // funtion for build the game
        public Game build() {
            if (!valid()) {
                throw new RuntimeException("Invalid Param");
            }
            return new Game(dimension, players, winningStratergies);
        }
    }
    // *****************************************************************************************************************

}
