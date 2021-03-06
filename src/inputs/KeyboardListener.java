package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GameStates;
// import scenes.GameScene;

import static main.GameStates.*;

public class KeyboardListener implements KeyListener {

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_A)
      GameStates.gameState = MENU;
    else if (e.getKeyCode() == KeyEvent.VK_S)
      GameStates.gameState = PLAY;
    else if (e.getKeyCode() == KeyEvent.VK_D)
      GameStates.gameState = SETTINGS;
    else if (e.getKeyCode() == KeyEvent.VK_F)
      GameStates.gameState = EDIT;
    else if (e.getKeyCode() == KeyEvent.VK_G)
      GameStates.gameState = RNDM;

  }

  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub

  }

}
