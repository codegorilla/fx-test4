package sample;

import javafx.application.Application;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class App extends Application {

  private final int START_WIDTH  = 960;
  private final int START_HEIGHT = 540;

  //private StackPane root;
  private AnchorPane root;

  MapView map;

  @Override
  public void init () throws Exception {
    System.out.println("Initializing application...");
    var javaVersion = System.getProperty("java.version");
    var javafxVersion = System.getProperty("javafx.version");
  }

  @Override
  public void start (Stage stage) throws Exception {

    // Create map view
    map = new MapView();

    //root = new StackPane();
    //root.getChildren().add(map);

    root = new AnchorPane();
    root.getChildren().add(map);
    root.setTopAnchor(map, 0.0);
    root.setLeftAnchor(map, 0.0);
    root.setBottomAnchor(map, 0.0);
    root.setRightAnchor(map, 0.0);

    stage.setTitle("Track Commander");
    stage.setScene(new Scene(root, START_WIDTH, START_HEIGHT));
    stage.show();
  }

  public static void main (String[] args) {
    App.launch(args);
  }
}
