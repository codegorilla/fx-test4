package sample;

import javafx.scene.image.Image;

public class Tile {

  public static final int TILE_WIDTH  = 256;
  public static final int TILE_HEIGHT = 256;

  private int row;
  private int column;
  private Image image;

  public Tile (int row, int column, Image image) {
    this.row = row;
    this.column = column;
    this.image = image;
  }

  public int getRow () {
    return row;
  }

  public int getColumn () {
    return column;
  }

  public Image getImage () {
    return image;
  }
}
