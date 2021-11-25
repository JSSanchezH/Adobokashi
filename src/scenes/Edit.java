package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.App;

import userinterface.MyButtons;
import static main.GameStates.*;

public class Edit extends GameScene implements SceneMethods {

  private MyButtons bMenu;

  public Edit(App app) {
    super(app);
    initButtons();

  }

  private void initButtons() {
    bMenu = new MyButtons("Menu", 642, 2, 60, 20);
  }

  @Override
  public void render(Graphics g) {
    g.setColor(Color.orange);
    g.fillRect(0, 0, 640, 640);

    drawButtons(g);
  }

  private void drawButtons(Graphics g) {
    bMenu.draw(g);
  }

  @Override
  public void mouseClicked(int x, int y) {
    if (bMenu.getBounds().contains(x, y))
      SetGameState(MENU);

  }

  @Override
  public void mouseMoved(int x, int y) {
    bMenu.setMouseOver(false);
    if (bMenu.getBounds().contains(x, y))
      bMenu.setMouseOver(true);

  }

  @Override
  public void mousePressed(int x, int y) {
    if (bMenu.getBounds().contains(x, y))
      bMenu.setMousePressed(true);
  }

  @Override
  public void mouseReleased(int x, int y) {
    resetButtons();
  }

  private void resetButtons() {
    bMenu.resetBooleans();

  }

}