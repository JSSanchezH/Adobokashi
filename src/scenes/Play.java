package scenes;

import java.awt.Color;
import java.awt.Graphics;

import help.LevelBuilder;
import main.App;
import managers.TileManager;
import userinterface.BotBar;

public class Play extends GameScene implements SceneMethods {

  private int[][] level;
  private TileManager tileManager;

  private BotBar botBar;

  public Play(App app) {
    super(app);

    level = LevelBuilder.getLevelData();

    tileManager = new TileManager();

    botBar = new BotBar(640, 0, 200, 640);

  }

  @Override
  public void render(Graphics g) {
    for (int i = 0; i < level.length; i++) {
      for (int j = 0; j < level[i].length; j++) {
        int id = level[i][j];

        g.drawImage(tileManager.getSprite(id), j * 32, i * 32, null);
      }
    }

    botBar.draw(g);

  }

  @Override
  public void mouseClicked(int x, int y) {

    if (x >= 640)
      botBar.mouseClicked(x, y);

  }

  @Override
  public void mouseMoved(int x, int y) {
    if (x >= 640)
      botBar.mouseMoved(x, y);

  }

  @Override
  public void mousePressed(int x, int y) {
    if (x >= 640)
      botBar.mousePressed(x, y);
  }

  @Override
  public void mouseReleased(int x, int y) {
    botBar.mouseReleased(x, y);

  }

}
