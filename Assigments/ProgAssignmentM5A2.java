import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

//Reminder that the circle starts as white so it isnt visible at first
public class ProgAssignmentM5A2 extends Application {

    private Circle circle = new Circle(60);

    private StackPane pane = new StackPane();

    @Override
    public void start(Stage primaryStage) {


    circle.setFill(Color.WHITE);

    circle.setOnMousePressed(e -> {
      circle.setFill(Color.BLACK);
    });

    circle.setOnMouseReleased(e -> {
      circle.setFill(Color.WHITE);
    });

    pane.getChildren().add(circle);


    Scene scene = new Scene(pane, 140, 140);
    primaryStage.setTitle("M5A2");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}