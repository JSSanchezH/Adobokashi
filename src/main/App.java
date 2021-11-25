package main;

import javax.swing.JFrame;

import scenes.Edit;
import scenes.Menu;
import scenes.Play;
import scenes.Rndm;
import scenes.Settings;

public class App extends JFrame implements Runnable {

    private AppScreen appScreen;

    private Thread gameThread;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    // Clases
    private Render render;
    private Menu menu;
    private Play play;
    private Settings settings;
    private Edit edit;
    private Rndm rndm;

    public App() {

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cuando se cierra la ventana se finaliza el programa

        initClasses();

        setResizable(false);
        add(appScreen);

        pack();
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }

    private void initClasses() {
        render = new Render(this);
        appScreen = new AppScreen(this);

        menu = new Menu(this);
        play = new Play(this);
        settings = new Settings(this);
        edit = new Edit(this);
        rndm = new Rndm(this);
    }

    private void start() {
        gameThread = new Thread(this) {
        };

        gameThread.start();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Inició el juego!");

        App app = new App();

        app.appScreen.initInputs();
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

        long now;

        while (true) {

            now = System.nanoTime();
            // Render
            if (now - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = now;
                frames++;
            }

            // Update
            if (now - lastUpdate >= timePerUpdate) {
                // updateGame();
                lastUpdate = now;
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

    // Getters and Setters

    public Render getRender() {
        return render;
    }

    public Menu getMenu() {
        return menu;
    }

    public Play getPlay() {
        return play;
    }

    public Settings getSettings() {
        return settings;
    }

    public Edit getEdit() {
        return edit;
    }

    public Rndm getRndm() {
        return rndm;
    }
}
