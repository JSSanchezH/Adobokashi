package scenes;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.App;
import userinterface.MyButtons;

import static main.GameStates.*;

public class Menu extends GameScene implements SceneMethods {

  private BufferedImage img;
  private ArrayList<BufferedImage> sprites = new ArrayList<>();
  private MyButtons bPlay, bSettings, bEdit, bRndm, bQuit;

  public Menu(App app) {
    super(app);
    importImg();
    loadSprites();

    initButtons();

  }

  private void initButtons() {

    int width = 200;
    int height = width / 3;
    int x = (840 - width) / 2;
    int y = 100;
    int yOffset = 100;

    bPlay = new MyButtons("Jugar", x, y, width, height);
    bSettings = new MyButtons("Configuración", x, y + yOffset, width, height);
    bEdit = new MyButtons("Editar", x, y + yOffset * 2, width, height);
    bRndm = new MyButtons("Random", x, y + yOffset * 3, width, height);
    bQuit = new MyButtons("Salir", x, y + yOffset * 4, width, height);
  }

  @Override
  public void render(Graphics g) {

    drawButtons(g);
  }

  private void drawButtons(Graphics g) {

    bPlay.draw(g);
    bSettings.draw(g);
    bEdit.draw(g);
    bRndm.draw(g);
    bQuit.draw(g);
  }

  private void importImg() {

    InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

    try {
      img = ImageIO.read(is);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void loadSprites() {

    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 16; j++) {
        sprites.add(img.getSubimage(i * 32, j * 32, 32, 32));
      }
    }
  }

  @Override
  public void mouseClicked(int x, int y) {

    if (bPlay.getBounds().contains(x, y))
      SetGameState(PLAY);
    else if (bSettings.getBounds().contains(x, y))
      SetGameState(SETTINGS);
    else if (bEdit.getBounds().contains(x, y))
      SetGameState(EDIT);
    else if (bRndm.getBounds().contains(x, y))
      SetGameState(RNDM);
    else if (bQuit.getBounds().contains(x, y))
      System.exit(0);

  }

  @Override
  public void mouseMoved(int x, int y) {

    bPlay.setMouseOver(false);
    bSettings.setMouseOver(false);
    bEdit.setMouseOver(false);
    bRndm.setMouseOver(false);
    bQuit.setMouseOver(false);

    if (bPlay.getBounds().contains(x, y))
      bPlay.setMouseOver(true);
    else if (bSettings.getBounds().contains(x, y))
      bSettings.setMouseOver(true);
    else if (bEdit.getBounds().contains(x, y))
      bEdit.setMouseOver(true);
    else if (bRndm.getBounds().contains(x, y))
      bRndm.setMouseOver(true);
    else if (bQuit.getBounds().contains(x, y))
      bQuit.setMouseOver(true);

  }

  @Override
  public void mousePressed(int x, int y) {

    if (bPlay.getBounds().contains(x, y))
      bPlay.setMousePressed(true);
    else if (bSettings.getBounds().contains(x, y))
      bSettings.setMousePressed(true);
    else if (bEdit.getBounds().contains(x, y))
      bEdit.setMousePressed(true);
    else if (bRndm.getBounds().contains(x, y))
      bRndm.setMousePressed(true);
    else if (bQuit.getBounds().contains(x, y))
      bQuit.setMousePressed(true);
  }

  @Override
  public void mouseReleased(int x, int y) {
    resetButtons();

  }

  private void resetButtons() {
    bPlay.resetBooleans();
    bSettings.resetBooleans();
    bEdit.resetBooleans();
    bRndm.resetBooleans();
    bQuit.resetBooleans();
  }

  @Override
  public void mouseDragged(int x, int y) {
    // TODO Auto-generated method stub

  }

}
