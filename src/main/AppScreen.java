package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class AppScreen extends JPanel {

  private Random random;
  private BufferedImage img;

  private ArrayList<BufferedImage> sprites = new ArrayList<>();

  public AppScreen(BufferedImage img) {

    this.img = img;

    loadSprites();
    random = new Random();

  }

  private void loadSprites() {

    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 16; j++) {
        sprites.add(img.getSubimage(i * 32, j * 32, 32, 32));
      }
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // g.drawImage(sprites.get(1), 0, 0, null);

    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 20; j++) {

        g.drawImage(sprites.get(getRandomInt()), i * 32, j * 32, null);
      }
    }

  }

  private int getRandomInt() {
    return random.nextInt(256);
  }

  // private Color getRandomColor() {
  // int red = random.nextInt(256);
  // int green = random.nextInt(256);
  // int blue = random.nextInt(256);

  // return new Color(red, green, blue);
  // }
}
