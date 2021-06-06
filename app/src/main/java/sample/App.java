package sample;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.paint.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.transform.Rotate;

import javafx.stage.Stage;

public class App extends Application {

  private final int START_WIDTH  = 960;
  private final int START_HEIGHT = 540;

  private final double EPSILON = 0.0;

  private StackPane root;
  //private AnchorPane root;
  private Group world;
  private Group local;

  MapView mapView;

  BaseMap baseMap;

  @Override
  public void init () throws Exception {
    System.out.println("Initializing application...");
    var javaVersion = System.getProperty("java.version");
    var javafxVersion = System.getProperty("javafx.version");
  }

  @Override
  public void start (Stage stage) throws Exception {

    // Create map view
    mapView = new MapView();

    root = new StackPane();
    root.getChildren().add(mapView);

    //world.getChildren().add(mapView);
    //root = new StackPane();
    //root.getChildren().add(circle);

    //root = new AnchorPane();
    //root.getChildren().add(map);
    //root.setTopAnchor(map, 0.0);
    //root.setLeftAnchor(map, 0.0);
    //root.setBottomAnchor(map, 0.0);
    //root.setRightAnchor(map, 0.0);

    stage.setTitle("Track Commander");
    stage.setScene(new Scene(root, START_WIDTH, START_HEIGHT));
    stage.show();
  }

  public static void main (String[] args) {
    App.launch(args);
  }
}
