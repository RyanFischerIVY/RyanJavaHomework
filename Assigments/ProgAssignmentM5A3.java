import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class ProgAssignmentM5A3 extends Application {

    @Override
    public void start(Stage primaryStage) {

    BorderPane root = new BorderPane();
    Pane centerPane = new Pane(); 
    root.setCenter(centerPane);
    //Creates the text that changes color
    Text text = new Text();
    text.setText("Show Colors");

    //Scroll bars, max, min, and default values
    ScrollBar sbRed = new ScrollBar();
    ScrollBar sbBlue = new ScrollBar();
    ScrollBar sbGreen = new ScrollBar();
    ScrollBar sbOpacity = new ScrollBar();

    sbRed.setMin(0); sbRed.setMax(255); sbRed.setValue(0);
    sbGreen.setMin(0); sbGreen.setMax(255); sbGreen.setValue(0);
    sbBlue.setMin(0); sbBlue.setMax(255); sbBlue.setValue(0);
    sbOpacity.setMin(0); sbOpacity.setMax(1); sbOpacity.setValue(1);

    VBox controls = new VBox(8); 
    controls.setPadding(new Insets(0, 10, 10, 10)); 
    
    
    Label lblRed = new Label("Red");
    Label lblGreen = new Label("Green");
    Label lblBlue = new Label("Blue");
    Label lblOpacity = new Label("Opacity");
    //Puts all the labels and scroll bars into their own boxes, bundles them together
    VBox colRed = new VBox(4, lblRed, sbRed);
    VBox colGreen = new VBox(4, lblGreen, sbGreen);
    VBox colBlue = new VBox(4, lblBlue, sbBlue);
    VBox colOpacity = new VBox(4, lblOpacity, sbOpacity);
    VBox colText = new VBox(4, text);

    colRed.setAlignment(Pos.CENTER);
    colGreen.setAlignment(Pos.CENTER);
    colBlue.setAlignment(Pos.CENTER);
    colOpacity.setAlignment(Pos.CENTER);
    colText.setAlignment(Pos.CENTER);

    controls.setPadding(new Insets(0, 10, 10, 10));
    controls.getChildren().addAll(colText, colRed, colGreen, colBlue, colOpacity);

    //Method that updeates teh color an dopacity when the scroll bars are touched
    Runnable updateColor = () -> {
        Color c = Color.rgb(
            (int) Math.round(sbRed.getValue()),
            (int) Math.round(sbGreen.getValue()),
            (int) Math.round(sbBlue.getValue()),
            sbOpacity.getValue()
        );
        text.setFill(c);
    };

    sbRed.valueProperty().addListener((obs, oldV, newV) -> updateColor.run());
    sbGreen.valueProperty().addListener((obs, oldV, newV) -> updateColor.run());
    sbBlue.valueProperty().addListener((obs, oldV, newV) -> updateColor.run());
    sbOpacity.valueProperty().addListener((obs, oldV, newV) -> updateColor.run());

    updateColor.run();
 
    root.setBottom(controls);
 

    Scene scene = new Scene(root, 200, 250);
    primaryStage.setTitle("M5A3");
    primaryStage.setScene(scene);
    primaryStage.show();

   }
}
