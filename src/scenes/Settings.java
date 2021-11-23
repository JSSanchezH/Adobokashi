package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.App;

public class Settings extends GameScene implements SceneMethods {

  public Settings(App app) {
    super(app);
    // TODO Auto-generated construc tor stub
  }

  @Override
  public void render(Graphics g) {
    g.setColor(Color.GREEN);
    g.fillRect(0, 0, 640, 640);

  }

}
