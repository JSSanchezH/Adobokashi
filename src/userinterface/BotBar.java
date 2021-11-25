package userinterface;

import java.awt.Graphics;
import java.awt.Color;

import static main.GameStates.*;

public class BotBar {

  private int x, y, width, height;

  private MyButtons bMenu;

  public BotBar(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

    initButtons();
  }

  private void initButtons() {
    bMenu = new MyButtons("Menu", 642, 2, 60, 20);
  }

  private void drawButtons(Graphics g) {
    bMenu.draw(g);
  }

  public void draw(Graphics g) {
    g.setColor(new Color(20, 35, 40));
    g.fillRect(x, y, width, height);

    drawButtons(g);
  }

  public void mouseClicked(int x, int y) {

    if (bMenu.getBounds().contains(x, y))
      SetGameState(MENU);

  }

  public void mouseMoved(int x, int y) {

    bMenu.setMouseOver(false);

    if (bMenu.getBounds().contains(x, y))
      bMenu.setMouseOver(true);

  }

  public void mousePressed(int x, int y) {

    if (bMenu.getBounds().contains(x, y))
      bMenu.setMousePressed(true);
  }

  public void mouseReleased(int x, int y) {
    resetButtons();

  }

  private void resetButtons() {
    bMenu.resetBooleans();
  }

}
