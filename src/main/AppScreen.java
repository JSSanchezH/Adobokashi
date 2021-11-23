package main;

// import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

import javax.swing.JPanel;

public class AppScreen extends JPanel {

  private Dimension size;
  private App app;
  private Render render;

  public AppScreen(App app) {

    this.app = app;
    render = new Render(this);

    setPanelSize();

  }

  private void setPanelSize() {

    int width = 640;
    int height = 640;

    size = new Dimension(width, height);
    setMinimumSize(size);
    setPreferredSize(size);
    setMaximumSize(size);

  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    render.render(g);

  }

  // private Color getRandomColor() {
  // int red = random.nextInt(256);
  // int green = random.nextInt(256);
  // int blue = random.nextInt(256);

  // return new Color(red, green, blue);
  // }
}
