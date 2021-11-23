package main;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class App extends JFrame {

    private AppScreen appScreen;

    private BufferedImage img;

    public App() {

        importImg();

        int width = 655;
        int height = 675;

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

    public static void main(String[] args) throws Exception {
        System.out.println("Inició el juego!");

        App app = new App();
    }
}
