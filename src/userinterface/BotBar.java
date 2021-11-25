package userinterface;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import objects.Tile;
import scenes.Play;

import java.awt.Color;

import static main.GameStates.*;

public class BotBar {

  private int x, y, width, height;

  private MyButtons bMenu;

  private Tile selectedTile;

  private Play play;

  private ArrayList<MyButtons> tileButtons = new ArrayList<>();

  public BotBar(int x, int y, int width, int height, Play play) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.play = play;

    initButtons();
  }

  private void initButtons() {
    bMenu = new MyButtons("Menu", 642, 2, 60, 20);

    int width = 50;
    int height = 50;
    int x = 645;
    int y = 50;
    int xOffset = 55;
    int yOffset = 55;
    int i = 0;
    int j = 0;
    int k = 0;
    for (Tile tile : play.getTileManager().tiles) {

      while (i < 6 && k < 18) {
        tileButtons.add(new MyButtons(tile.getName(), x + xOffset * i, y + yOffset * j, width, height, k));
        i++;
        k++;

      }
      i = 0;
      j++;

    }

  }

  private void drawButtons(Graphics g) {
    bMenu.draw(g);
    drawTileButtons(g);
    drawSelectedTile(g);

  }

  private void drawSelectedTile(Graphics g) {
    if (selectedTile != null) {
      g.drawImage(selectedTile.getSprite(), 645, 500, 50, 50, null);
      g.setColor(Color.BLACK);
      g.drawRect(645, 500, 50, 50);
    }
  }

  private void drawTileButtons(Graphics g) {

    for (MyButtons b : tileButtons) {
      g.drawImage(getButtImg(b.getId()), b.x, b.y, b.width, b.height, null);

      if (b.isMouseOver())
        g.setColor(Color.white);
      else
        g.setColor(Color.BLACK);

      g.drawRect(b.x, b.y, b.width, b.height);

      if (b.isMousePressed()) {
        g.drawRect(b.x + 1, b.y + 1, b.width - 2, b.height - 2);
        g.drawRect(b.x + 2, b.y + 2, b.width - 4, b.height - 4);
      }

    }
  }

  public BufferedImage getButtImg(int id) {
    return play.getTileManager().getSprite(id);
  }

  public void draw(Graphics g) {
    g.setColor(new Color(20, 35, 40));
    g.fillRect(x, y, width, height);

    drawButtons(g);
  }

  public void mouseClicked(int x, int y) {
    if (bMenu.getBounds().contains(x, y))
      SetGameState(MENU);
    else {
      for (MyButtons b : tileButtons) {
        if (b.getBounds().contains(x, y)) {
          selectedTile = play.getTileManager().getTile(b.getId());
          play.setSelectedTile(selectedTile);
          return;
        }
      }
    }

  }

  public void mouseMoved(int x, int y) {

    bMenu.setMouseOver(false);

    for (MyButtons b : tileButtons)
      b.setMouseOver(false);

    if (bMenu.getBounds().contains(x, y))
      bMenu.setMouseOver(true);
    else {
      for (MyButtons b : tileButtons) {
        if (b.getBounds().contains(x, y)) {
          b.setMouseOver(true);
          return;
        }
      }
    }

  }

  public void mousePressed(int x, int y) {

    if (bMenu.getBounds().contains(x, y))
      bMenu.setMousePressed(true);
    else {
      for (MyButtons b : tileButtons) {
        if (b.getBounds().contains(x, y)) {
          b.setMousePressed(true);
          return;
        }
      }
    }
  }

  public void mouseReleased(int x, int y) {

    resetButtons();

  }

  private void resetButtons() {
    bMenu.resetBooleans();

    for (MyButtons b : tileButtons)
      b.resetBooleans();
  }

}
