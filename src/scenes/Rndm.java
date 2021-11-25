package scenes;

import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.App;

import userinterface.MyButtons;
import static main.GameStates.*;

public class Rndm extends GameScene implements SceneMethods {

  private BufferedImage img;
  private ArrayList<BufferedImage> sprites = new ArrayList<>();
  private Random random;

  private MyButtons bMenu;

  public Rndm(App app) {
    super(app);

    random = new Random();
    importImg();
    loadSprites();

    initButtons();

  }

  private void initButtons() {
    bMenu = new MyButtons("Menu", 642, 2, 60, 20);
  }

  @Override
  public void render(Graphics g) {
    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 20; j++) {

        g.drawImage(sprites.get(getRandomInt()), i * 32, j * 32, null);
      }
    }

    drawButtons(g);

  }

  private void drawButtons(Graphics g) {
    bMenu.draw(g);
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

  private int getRandomInt() {
    return random.nextInt(256);
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
