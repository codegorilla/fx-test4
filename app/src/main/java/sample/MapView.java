package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.*;

public class MapView extends Region {

  BaseMap baseMap;

  private double lastX;
  private double lastY;

  public MapView () {
    baseMap = new BaseMap();
    //baseMap.loadImage("images/tile1.png");
    getChildren().add(baseMap);

    //canvas.widthProperty().addListener(evt -> draw());
    //canvas.heightProperty().addListener(evt -> draw());
//    setOnMouseClicked(e -> System.out.println("Hello world!"));
    setOnMouseClicked(this::handleMouseClicked);
    setOnMousePressed(this::handleMousePressed);
    setOnMouseDragged(this::handleMouseDragged);
  }

  private void handleMouseClicked (MouseEvent event) {
    System.out.println("Button clicked!");
  }

  private void handleMousePressed (MouseEvent event) {
    System.out.println("Button pressed!");
    lastX = event.getX();
    lastY = event.getY();
  }

  private void handleMouseDragged (MouseEvent event) {
    System.out.println("Mouse dragged!");
    var x = event.getX();
    var y = event.getY();
    var deltaX = x - lastX;
    var deltaY = y - lastY;
    lastX = x;
    lastY = y;
    System.out.println(deltaX);

    // Translate the base map
    var mapLeftX = baseMap.getTranslateX();
    var mapRightX = mapLeftX + baseMap.getWidth();
    var mapLeftXnew = mapLeftX + deltaX;
    var mapRightXnew = mapRightX + deltaX;

    if (mapLeftXnew <= 0 && mapRightXnew >= getWidth()) {
      baseMap.setTranslateX(mapLeftXnew);
    }

    var mapTopY = baseMap.getTranslateY();
    var mapBottomY = mapTopY + baseMap.getHeight();
    var mapTopYnew = mapTopY + deltaY;
    var mapBottomYnew = mapBottomY + deltaY;

    if (mapTopYnew <= 0 && mapBottomYnew >= getHeight()) {
      baseMap.setTranslateY(mapTopYnew);
    }
  }

  void draw() {
    // double width = canvas.getWidth();
    // double height = canvas.getHeight();

    // var gc = canvas.getGraphicsContext2D();
    // gc.clearRect(0, 0, width, height);

    // gc.setStroke(Color.RED);
    // gc.strokeLine(0, 0, width, height);
    // gc.strokeLine(0, height, width, 0);
  }

  @Override
  protected void layoutChildren () {
    // super.layoutChildren();
    // // Position and size canvas, accounting for border and padding
    // final var x = snappedLeftInset();
    // final var y = snappedTopInset();
    // final var w = snapSizeX(getWidth()) - x - snappedRightInset();
    // final var h = snapSizeY(getHeight()) - y - snappedBottomInset();
    // canvas.setLayoutX(x);
    // canvas.setLayoutY(y);
    // canvas.setWidth(w);
    // canvas.setHeight(h);
  }
}
