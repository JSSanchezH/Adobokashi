package main;

// import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

import inputs.KeyboardListener;
import inputs.MyMouseListener;

import javax.swing.JPanel;

public class AppScreen extends JPanel {

  private Dimension size;
  private App app;

  private MyMouseListener myMouseListener;
  private KeyboardListener keyboardListener;

  public AppScreen(App app) {

    this.app = app;

    setPanelSize();

  }

  // Antes los inputs estaban en la case App, pero eso hacía que la posición del
  // mouse fuera incorrectaf
  public void initInputs() {
    myMouseListener = new MyMouseListener(app);
    keyboardListener = new KeyboardListener();

    addMouseListener(myMouseListener);
    addMouseMotionListener(myMouseListener);
    addKeyListener(keyboardListener);

    requestFocus();
  }

  private void setPanelSize() {

    int width = 840;
    int height = 640;

    size = new Dimension(width, height);
    setMinimumSize(size);
    setPreferredSize(size);
    setMaximumSize(size);

  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    app.getRender().render(g);

  }

  // private Color getRandomColor() {
  // int red = random.nextInt(256);
  // int green = random.nextInt(256);
  // int blue = random.nextInt(256);

  // return new Color(red, green, blue);
  // }
}
