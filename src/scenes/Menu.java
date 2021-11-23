package scenes;

import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.App;

public class Menu extends GameScene implements SceneMethods {

  private BufferedImage img;
  private ArrayList<BufferedImage> sprites = new ArrayList<>();
  private Random random;

  public Menu(App app) {
    super(app);
    random = new Random();
    importImg();
    loadSprites();

  }

  @Override
  public void render(Graphics g) {
    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 20; j++) {

        g.drawImage(sprites.get(getRandomInt()), i * 32, j * 32, null);
      }
    }

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

}
