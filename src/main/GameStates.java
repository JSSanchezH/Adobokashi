package main;

public enum GameStates {
  PLAY, MENU, SETTINGS, EDIT, RNDM;

  public static GameStates gameState = MENU;

  public static void SetGameState(GameStates state) {
    gameState = state;
  }
}
