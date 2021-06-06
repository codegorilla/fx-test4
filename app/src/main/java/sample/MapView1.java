package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Region;
import javafx.scene.paint.*;

public class MapView1 extends Region {

  Canvas canvas;

  public MapView1 () {
    super();
    canvas = new Canvas();
    getChildren().add(canvas);
    canvas.widthProperty().addListener(evt -> draw());
    canvas.heightProperty().addListener(evt -> draw());
  }

  void draw() {
    double width = canvas.getWidth();
    double height = canvas.getHeight();

    var gc = canvas.getGraphicsContext2D();
    gc.clearRect(0, 0, width, height);

    gc.setStroke(Color.RED);
    gc.strokeLine(0, 0, width, height);
    gc.strokeLine(0, height, width, 0);
  }

  @Override
  protected void layoutChildren () {
    super.layoutChildren();
    // Position and size canvas, accounting for border and padding
    final var x = snappedLeftInset();
    final var y = snappedTopInset();
    final var w = snapSizeX(getWidth()) - x - snappedRightInset();
    final var h = snapSizeY(getHeight()) - y - snappedBottomInset();
    canvas.setLayoutX(x);
    canvas.setLayoutY(y);
    canvas.setWidth(w);
    canvas.setHeight(h);
  }
}
