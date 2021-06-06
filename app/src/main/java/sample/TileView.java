package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileView {

  private double width;
  private double height;

  private double centerX;
  private double centerY;

  private TileSet ts;
  private int spanX;

  private ImageView[] iva;



  private Group group;

  public TileView (TileSet ts) {

    this.ts = ts;

    // Figure out how big the tileview needs to be
    // How many tiles are needed?
    spanX = 0;

    // Create group to hold tiles
    group = new Group();
  }

  public Group getRoot () {
    return group;
  }

  public void setCenter (double x, double y) {
    centerX = x;
    centerY = y;
  }

  public void setWidth (double width) {
    this.width = width;
  }

  public void setHeight (double height) {
    this.height = height;
  }

  public void render () {
    // Recompute bounds
    var minX = centerX - width/2;

    // Compute tile index and span
    var tileX = (int)minX/Tile.TILE_WIDTH;

    // Compute offset of viewport from tileX
    var offset = (int)minX - tileX*Tile.TILE_WIDTH;
    group.setTranslateX(-offset);

    var prevSpanX = spanX;
    spanX = (int)Math.ceil(width/Tile.TILE_WIDTH) + 1;

    // Re-allocate image views if span changes
    if (spanX != prevSpanX) {
      iva = new ImageView[spanX];
      for (int i=0; i<spanX; i++) {
        iva[i] = new ImageView();
        iva[i].setTranslateX(i*Tile.TILE_WIDTH);
        group.getChildren().add(iva[i]);
      }
    }
    
    // Perform mapping
    for (int i=0; i<spanX; i++) {
      var tile = ts.get(0, tileX+i);
      iva[i].setImage(tile.getImage());
    }
  }


}
