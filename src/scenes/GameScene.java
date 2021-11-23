package scenes;

import main.App;

public class GameScene {

  private App app;

  public GameScene(App app) {
    this.app = app;
  }

  public App getGame() {
    return app;
  }
}
