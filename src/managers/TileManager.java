package managers;

import objects.Tile;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import help.LoadSave;

public class TileManager {

  public Tile LEFT_WALL_1, LEFT_WALL_2, TOP_LEFT_CORNER, BOT_LEFT_CORNER, TOP_RIGHT_CORNER, BOT_RIGHT_CORNER,
      BOT_WALL_1, BOT_WALL_2, TOP_WALL_1, TOP_WALL_2, STONE; // Corregir

  private BufferedImage atlas;
  public ArrayList<Tile> tiles = new ArrayList<>();

  public TileManager() {

    loadAtlas();
    createTiles();
  }

  private void createTiles() {
    int id = 0;

    tiles.add(STONE = new Tile(getSprite(13, 11), id++, "STONE"));
    tiles.add(TOP_RIGHT_CORNER = new Tile(getSprite(15, 12), id++, "CORNER"));
    tiles.add(TOP_WALL_1 = new Tile(getSprite(14, 12), id++, "WALL"));
    tiles.add(TOP_WALL_2 = new Tile(getSprite(13, 12), id++, ""));
    tiles.add(TOP_LEFT_CORNER = new Tile(getSprite(12, 12), id++, ""));
    tiles.add(LEFT_WALL_1 = new Tile(getSprite(12, 13), id++, ""));
    tiles.add(LEFT_WALL_2 = new Tile(getSprite(12, 14), id++, ""));
    tiles.add(BOT_LEFT_CORNER = new Tile(getSprite(12, 15), id++, ""));
    tiles.add(BOT_WALL_2 = new Tile(getSprite(13, 15), id++, ""));
    tiles.add(BOT_WALL_2 = new Tile(getSprite(14, 15), id++, ""));
    tiles.add(BOT_RIGHT_CORNER = new Tile(getSprite(15, 15), id++, ""));

  }

  private void loadAtlas() {

    atlas = LoadSave.getSpriteAtlas();
  }

  public BufferedImage getSprite(int id) {
    return tiles.get(id).getSprite();
  }

  private BufferedImage getSprite(int x, int y) {
    return atlas.getSubimage(x * 32, y * 32, 32, 32);
  }
}
