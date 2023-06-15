package com.myscaler.tictactoe.Strategies.BotWinningStratergies;

import com.myscaler.tictactoe.Models.BotDifficultyLevel;

public class botWinningStrategiesFactory {

    public static botWinningStratergies getBotWinningStratergies(BotDifficultyLevel botDifficultyLevel) {
        return new EasyBotWinningStratergies();

        // return switch (botDifficultyLevel) {
        // case EASY -> new EasyBotWinningStratergies();
        // case MEDIUM -> new MediumBotWinningStratergies();
        // case HARD -> new HardBotWinningStratergies();
        // };
    }
}
