package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.App;

public class Edit extends GameScene implements SceneMethods {

  public Edit(App app) {
    super(app);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void render(Graphics g) {
    g.setColor(Color.orange);
    g.fillRect(0, 0, 640, 640);

  }

}
