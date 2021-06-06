package sample;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;

public class BaseMap extends Group {

  private ImageView imageView;
  private ImageView tile1;

  public BaseMap () {

    Image image = null;
    TileSet ts = null;

    ts = new TileSet(6, 3);
    ts.load();

    TileView tv = new TileView(ts);
    getChildren().add(tv.getRoot());

    tv.setCenter(650, 768);
    tv.setWidth(960);
    tv.setHeight(500);
    tv.render();

  }

  public void loadImage (String imageFile) {
    var image = new Image(imageFile);
    tile1.setImage(image);
  }

  public double getWidth () {
    return tile1.getImage().getWidth();
  }

  public double getHeight () {
    return tile1.getImage().getHeight();
  }

}