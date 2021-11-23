package main;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class App extends JFrame implements Runnable {

    private AppScreen appScreen;

    private BufferedImage img;

    private Thread gameThread;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    public App() {

        importImg();

        int width = 656;
        int height = 679;

        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cuando se cierra la ventana se finaliza el programa
        setLocationRelativeTo(null); // Centra la ventana

        appScreen = new AppScreen(img);
        add(appScreen);
        setVisible(true);
    }

    private void importImg() {

        InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        gameThread = new Thread(this) {
        };

        gameThread.start();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Inició el juego!");

        App app = new App();
        app.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET; // Un segundo (en nanosegundos) para tener 60 fps
        double timePerUpdate = 1000000000.0 / UPS_SET; // Un segundo (en nanosegundos) para tener 60 ups

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        while (true) {
            // Render
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = System.nanoTime();
                frames++;
            }

            // Update
            if (System.nanoTime() - lastUpdate >= timePerUpdate) {
                // updateGame();
                lastUpdate = System.nanoTime();
                updates++;
            }

            // Checking FPS y UPS
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }

    }
}
