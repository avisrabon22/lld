package com.myscaler.tictactoe;

import java.util.List;
import java.util.Scanner;

import com.myscaler.tictactoe.Controllers.GameController;
import com.myscaler.tictactoe.Models.Bot;
import com.myscaler.tictactoe.Models.BotDifficultyLevel;
import com.myscaler.tictactoe.Models.Game;
import com.myscaler.tictactoe.Models.GameStatus;
import com.myscaler.tictactoe.Models.Player;
import com.myscaler.tictactoe.Models.PlayerType;
import com.myscaler.tictactoe.Models.Symbol;
import com.myscaler.tictactoe.Strategies.WinningStratergies.ColumnWinningStratergies;
import com.myscaler.tictactoe.Strategies.WinningStratergies.DiagonalWinningStratergies;
import com.myscaler.tictactoe.Strategies.WinningStratergies.RowWinningStratesies;

public class Main {

    public static void main(String[] args) {
        // for input*********************************************
        Scanner sc = new Scanner(System.in);
        // game controller object
        GameController gameController = new GameController();
        // create a createGame funtion**********************
        Game game;
        try {
            game = gameController.createGame(
                    3,
                    List.of(
                            new Player(new Symbol('X'), "Avijit", PlayerType.HUMAN),
                            new Bot(new Symbol('0'), "Kishu", BotDifficultyLevel.EASY)),
                    List.of(
                            new RowWinningStratesies(),
                            new ColumnWinningStratergies(),
                            new DiagonalWinningStratergies()));
        } catch (Exception e) {
            System.out.println("There somthing wrong");
            return;
        }

        // Game.Builder gamBuilder = new Game.Builder();

        // start the game
        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            // first display the game*******************************
            gameController.displayBoard(game);

            System.out.println("Do you wnat to undo?(Y/N)");
            String input = sc.next();
            // check Y or N for undo or move************************
            if (input.equalsIgnoreCase("Y")) {
                gameController.undo(game);
            } else {
                gameController.makeMove(game);
            }
        }

        // game status for winner check
        GameStatus gameStatus = new GameController().getGameStatus(game);
        if (gameStatus.equals(GameStatus.ENDED)) {
            gameController.printWinner(game);
        } else {
            System.out.println("Game drawn");
        }
        // for result
        gameController.printResult(game);

    }
    // *******************************************************************************8
}
