package sample;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.image.Image;


public class TileMapping {

  private int numColumns;
  private int numRows;

  private ArrayList<Integer> indices;

  public TileMapping () {}

  public void computeSize (int width, int height) {
    // Compute width and height in tiles
    numColumns = (int)Math.ceil((double)width  / Tile.TILE_WIDTH)  + 1;
    numRows    = (int)Math.ceil((double)height / Tile.TILE_HEIGHT) + 1;
  }

  public void allocate () {
    var count = numColumns * numRows;
    indices = new ArrayList<>(Arrays.asList(new Integer[count]));
  }

  public void set (int a, int b) {
    indices.set(a, b);
  }



  // public void load () {
  //   for (int j=0; j<numRows; j++) {
  //     for (int i=0; i<numColumns; i++) {
  //       int n = i + j*numColumns;
  //       var image = new Image("images/tile" + (n + 1) + ".png");
  //       var tile = new Tile(j, i, image);
  //       tiles.add(n, tile);
  //     }
  //   }
  // }

  public int getNumColumns () {
    return numColumns;
  }

  public int getNumRows () {
    return numRows;
  }
}
