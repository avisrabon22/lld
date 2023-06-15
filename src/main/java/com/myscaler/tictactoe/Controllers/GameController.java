package com.myscaler.tictactoe.Controllers;

import java.util.List;

import com.myscaler.tictactoe.Models.Game;
import com.myscaler.tictactoe.Models.GameStatus;
import com.myscaler.tictactoe.Models.Player;
import com.myscaler.tictactoe.Strategies.WinningStratergies.WinningStratergies;

public class GameController {

    // Create Game *************************
    public Game createGame(int dimension, List<Player> players, List<WinningStratergies> winningStratergies) {
        return Game.getBulder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStratergies(winningStratergies)
                .build();
    }

    // Display board ********
    public void displayBoard(Game game) {
        game.printBoard();
    }

    // Undo ****************************
    public void undo(Game game) {
        game.undo();

    }

    // Make a move **********************
    public void makeMove(Game game) {
        game.makeMove();
    }

    // Game status ************************
    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    // Print the winner ****************************
    public void printWinner(Game game) {
        game.printWinner();

    }

    // Print the result ********************************
    public void printResult(Game game) {
        game.printResult();
    }

}
