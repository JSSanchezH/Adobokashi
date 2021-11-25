package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.App;
import main.GameStates;

public class MyMouseListener implements MouseListener, MouseMotionListener {

  private App app;

  public MyMouseListener(App app) {

    this.app = app;

  }

  @Override
  public void mouseDragged(MouseEvent e) {
    switch (GameStates.gameState) {
    case MENU:
      app.getMenu().mouseDragged(e.getX(), e.getY());

      break;
    case PLAY:
      app.getPlay().mouseDragged(e.getX(), e.getY());

      break;
    case SETTINGS:
      app.getSettings().mouseDragged(e.getX(), e.getY());

      break;
    case EDIT:
      app.getEdit().mouseDragged(e.getX(), e.getY());

      break;
    case RNDM:
      app.getRndm().mouseDragged(e.getX(), e.getY());

      break;
    default:
      break;

    }

  }

  @Override
  public void mouseMoved(MouseEvent e) {
    switch (GameStates.gameState) {
    case MENU:
      app.getMenu().mouseMoved(e.getX(), e.getY());

      break;
    case PLAY:
      app.getPlay().mouseMoved(e.getX(), e.getY());

      break;
    case SETTINGS:
      app.getSettings().mouseMoved(e.getX(), e.getY());

      break;
    case EDIT:
      app.getEdit().mouseMoved(e.getX(), e.getY());

      break;
    case RNDM:
      app.getRndm().mouseMoved(e.getX(), e.getY());

      break;
    default:
      break;

    }

  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
      switch (GameStates.gameState) {
      case MENU:
        app.getMenu().mouseClicked(e.getX(), e.getY());
        break;
      case PLAY:
        app.getPlay().mouseClicked(e.getX(), e.getY());

        break;
      case SETTINGS:
        app.getSettings().mouseClicked(e.getX(), e.getY());

        break;
      case EDIT:
        app.getEdit().mouseClicked(e.getX(), e.getY());

        break;
      case RNDM:
        app.getRndm().mouseClicked(e.getX(), e.getY());

        break;
      default:
        break;

      }

      // System.out.println("Pos: " + e.getX() + " : " + e.getY());

    } else if (e.getButton() == MouseEvent.BUTTON3)
      System.out.println("Click derecho presionado");

  }

  @Override
  public void mousePressed(MouseEvent e) {
    switch (GameStates.gameState) {
    case MENU:
      app.getMenu().mousePressed(e.getX(), e.getY());
      break;
    case PLAY:
      app.getPlay().mousePressed(e.getX(), e.getY());

      break;
    case SETTINGS:
      app.getSettings().mousePressed(e.getX(), e.getY());

      break;
    case EDIT:
      app.getEdit().mousePressed(e.getX(), e.getY());

      break;
    case RNDM:
      app.getRndm().mousePressed(e.getX(), e.getY());

      break;
    default:
      break;

    }

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    switch (GameStates.gameState) {
    case MENU:
      app.getMenu().mouseReleased(e.getX(), e.getY());
      break;
    case PLAY:
      app.getPlay().mouseReleased(e.getX(), e.getY());

      break;
    case SETTINGS:
      app.getSettings().mouseReleased(e.getX(), e.getY());

      break;
    case EDIT:
      app.getEdit().mouseReleased(e.getX(), e.getY());

      break;
    case RNDM:
      app.getRndm().mouseReleased(e.getX(), e.getY());

      break;
    default:
      break;

    }

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

}
