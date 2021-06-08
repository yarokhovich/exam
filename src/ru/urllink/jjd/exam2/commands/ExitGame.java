package ru.urllink.jjd.exam2.commands;

import ru.urllink.jjd.exam2.Game;

public class ExitGame implements Command{
  private Game game;

  public ExitGame(Game game) {
    this.game = game;
  }
    @Override
    public void execute() {
    game.exitGame();
    }

    @Override
    public String getTitle() {
      return "Выйти из игры";
    }
}
