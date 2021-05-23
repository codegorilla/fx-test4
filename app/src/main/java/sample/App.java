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

  //private StackPane root;
  //private AnchorPane root;
  private Group world;
  private Group local;

  //MapView map;

  @Override
  public void init () throws Exception {
    System.out.println("Initializing application...");
    var javaVersion = System.getProperty("java.version");
    var javafxVersion = System.getProperty("javafx.version");
  }

  @Override
  public void start (Stage stage) throws Exception {

    // Create map view
    //map = new MapView();

    var image = new Image("images/hawaii-topo-large.png");
    var iv1 = new ImageView();
    iv1.setImage(image);

    var x0 = 0.0 + EPSILON;
    var y0 = 0.0 + EPSILON;
    var x1 = 100.0 + EPSILON;
    var y1 = 0.0 + EPSILON;
    var x2 = 0.0 + EPSILON;
    var y2 = 100.0 + EPSILON;

    var rX0 = -(50.0 + EPSILON);
    var rY0 = -(50.0 + EPSILON);
    var rW = 100.0;
    var rH = 100.0;

//    Circle circle = new Circle(x0, y0, 50);
    Rectangle rect = new Rectangle(rX0, rY0, rW, rH);

    Line xAxisLocal = new Line(x0, y0, x1, y1);
    xAxisLocal.setStroke(Color.RED);
    xAxisLocal.setStrokeWidth(2.0);

    Line yAxisLocal = new Line(x0, y0, x2, y2);
    yAxisLocal.setStroke(Color.GREEN);
    yAxisLocal.setStrokeWidth(2.0);

    // Never rotate a group, because it rotates about the center of the
    // layout bounds, not (0,0)! Center of layout bounds is computed based on
    // The children! Instead, add a transform object.

    Rotate rot = new Rotate(45.0);

    local = new Group();
    local.getChildren().add(rect);
    local.getChildren().addAll(xAxisLocal, yAxisLocal);
    local.getTransforms().add(rot);

    //rect.setRotate(45.0);
    //local.setRotate(45.0);



    //circle.setCenterX(50);
    //circle.setCenterY(50);
    //circle.setLayoutX(100);
    //root.setLayoutX(100);
    //root.setLayoutY(100);

    // var x0 = 0.0 + EPSILON;
    // var y0 = 0.0 + EPSILON;
    // var x1 = 200.0 + EPSILON;
    // var y1 = 0.0 + EPSILON;
    // var x2 = 0.0 + EPSILON;
    // var y2 = 200.0 + EPSILON;

    var x3 = 200.0 + EPSILON;
    var y3 = 0.0 + EPSILON;
    var x4 = 0.0 + EPSILON;
    var y4 = 200.0 + EPSILON;

    Line xAxis = new Line(x0, y0, x3, y3);
    xAxis.setStroke(Color.RED);
    xAxis.setStrokeWidth(2.0);
    Line yAxis = new Line(x0, y0, x4, y4);
    yAxis.setStroke(Color.GREEN);
    yAxis.setStrokeWidth(2.0);
    world = new Group();
    world.getChildren().addAll(xAxis, yAxis);
    world.getChildren().add(local);
    world.setTranslateX(100.0 + 0.0);
    world.setTranslateY(100.0 + 0.0);
    world.getChildren().add(iv1);
    //root = new StackPane();
    //root.getChildren().add(circle);

    //root = new AnchorPane();
    //root.getChildren().add(map);
    //root.setTopAnchor(map, 0.0);
    //root.setLeftAnchor(map, 0.0);
    //root.setBottomAnchor(map, 0.0);
    //root.setRightAnchor(map, 0.0);

    stage.setTitle("Track Commander");
    stage.setScene(new Scene(world, START_WIDTH, START_HEIGHT));
    stage.show();
  }

  public static void main (String[] args) {
    App.launch(args);
  }
}
