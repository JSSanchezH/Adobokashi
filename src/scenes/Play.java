package scenes;

// import java.awt.Color;
import java.awt.Graphics;

import help.LevelBuilder;
import main.App;
import managers.TileManager;
import objects.Tile;
import userinterface.BotBar;

public class Play extends GameScene implements SceneMethods {

  private int[][] level;
  private TileManager tileManager;

  private Tile selectedTile;

  private BotBar botBar;

  private int mouseX, mouseY;

  private int lastTileX, lastTileY, lastTileId;

  private boolean drawSelect;

  public Play(App app) {
    super(app);

    level = LevelBuilder.getLevelData();

    tileManager = new TileManager();

    botBar = new BotBar(640, 0, 400, 640, this);

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
    drawSelectedTile(g);

  }

  private void drawSelectedTile(Graphics g) {
    if (selectedTile != null && drawSelect) {
      g.drawImage(selectedTile.getSprite(), mouseX, mouseY, 32, 32, null);
    }
  }

  public void setSelectedTile(Tile tile) {
    this.selectedTile = tile;
    drawSelect = true;
  }

  public TileManager getTileManager() {
    return tileManager;
  }

  @Override
  public void mouseClicked(int x, int y) {

    if (x >= 640)
      botBar.mouseClicked(x, y);
    else {
      changeTile(mouseX, mouseY);
    }

  }

  private void changeTile(int x, int y) {
    if (selectedTile != null) {
      int tileX = x / 32;
      int tileY = y / 32;

      // Para evitar cambios innecesarios, cuando se repite posición o item
      if (lastTileX == tileX && lastTileY == tileY && lastTileId == selectedTile.getId())
        return;

      lastTileX = tileX;
      lastTileY = tileY;
      lastTileId = selectedTile.getId();

      level[tileY][tileX] = selectedTile.getId();
    }
  }

  @Override
  public void mouseMoved(int x, int y) {
    if (x >= 640) {
      botBar.mouseMoved(x, y);
      drawSelect = false;
    } else {
      drawSelect = true;

      // Dividir y multiplicar por 32 hace el objeto se mueva en una cuadricula
      mouseX = (x / 32) * 32;
      mouseY = (y / 32) * 32;
    }

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

  @Override
  public void mouseDragged(int x, int y) {
    if (x >= 640) {

    } else
      changeTile(x, y);

  }

}
