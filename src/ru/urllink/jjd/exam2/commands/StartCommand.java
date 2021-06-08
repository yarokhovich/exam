package ru.urllink.jjd.exam2.commands;

import ru.urllink.jjd.exam2.Game;

public class StartCommand  implements Command{
    private   Game game;

    public StartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.startGame();
    }

    @Override
    public String getTitle() {
        return "Начать игру";
    }
}
