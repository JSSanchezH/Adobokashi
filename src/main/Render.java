package main;

import java.awt.Graphics;

public class Render {

  private App app;

  public Render(App app) {
    this.app = app;

  }

  public void render(Graphics g) {

    switch (GameStates.gameState) {
    case MENU:
      app.getMenu().render(g);
      break;
    case PLAY:
      app.getPlay().render(g);
      break;
    case SETTINGS:
      app.getSettings().render(g);
      break;
    case EDIT:
      app.getEdit().render(g);
      break;
    }

  }

}
