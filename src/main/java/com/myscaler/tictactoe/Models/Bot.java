package com.myscaler.tictactoe.Models;

import com.myscaler.tictactoe.Strategies.BotWinningStratergies.botWinningStrategiesFactory;
import com.myscaler.tictactoe.Strategies.BotWinningStratergies.botWinningStratergies;

public class Bot extends Player {

    private BotDifficultyLevel botDifficultyLevel;
    private botWinningStratergies botwinningStratergies;

    public Bot(Symbol symbol, String name, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botwinningStratergies = botWinningStrategiesFactory.getBotWinningStratergies(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Cell makeMove(Board board) {
        return botwinningStratergies.makeMove(board);
    }

}
