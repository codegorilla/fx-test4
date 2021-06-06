package sample;

import java.util.ArrayList;

import javafx.scene.image.Image;


public class TileSet {

  private int numRows;
  private int numColumns;

  private ArrayList<Tile> tiles;

  public TileSet (int numColumns, int numRows) {
    this.numColumns = numColumns;
    this.numRows = numRows;
    tiles = new ArrayList<>();
  }

  public void load () {
    for (int j=0; j<numRows; j++) {
      for (int i=0; i<numColumns; i++) {
        int n = i + j*numColumns;
        var image = new Image("images/tile" + (n + 1) + ".png");
        var tile = new Tile(j, i, image);
        tiles.add(n, tile);
      }
    }
  }

  public int getNumRows () {
    return numRows;
  }

  public int getNumColumns () {
    return numColumns;
  }

  public Tile get (int row, int column) {
    int n = column + row*numColumns;
    return tiles.get(n);
  }
}
