package ru.urllink.jjd.exam2.commands;

import ru.urllink.jjd.exam2.Game;

public class LoadCommand implements Command{
    private Game game;

    public LoadCommand(Game game) {
        this.game = game;
    }
    @Override
    public void execute() {
    game.loadGame();
    }

    @Override
    public String getTitle() {
        return "Загрузить игру";
    }
}
