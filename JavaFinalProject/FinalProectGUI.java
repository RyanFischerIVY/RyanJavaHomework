
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;


public class FinalProectGUI extends Application {

    
    private Pane centerPane;
    private Text statusText;

    @Override
    public void start(Stage primaryStage) {

    BorderPane root = new BorderPane();
    centerPane = new Pane();
    root.setCenter(centerPane);

    
    statusText = new Text("Create your character to begin!");
    statusText.setWrappingWidth(360); 

    
    showStartScreen();

    Scene scene = new Scene(root, 400, 300);
    primaryStage.setTitle("M5A3");
    primaryStage.setScene(scene);
    primaryStage.show();

   }

    //Create a character screen
    private void showStartScreen() {
        centerPane.getChildren().clear();

        Text prompt = new Text("Enter name and choose class:");
        TextField nameField = new TextField();
        nameField.setPromptText("Your name");

        RadioButton rbA = new RadioButton("Warrior");
        RadioButton rbB = new RadioButton("Mage");
        ToggleGroup group = new ToggleGroup();
        rbA.setToggleGroup(group);
        rbB.setToggleGroup(group);

        Button createBtn = new Button("Create Character");
        createBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            if (rbA.isSelected()) {
                statusText.setText("Welcome " + (name.isEmpty() ? "Stranger" : name) + " the Warrior!");
                statusText.setFill(Color.RED);
                showMainMenu();
            } else if (rbB.isSelected()) {
                statusText.setText("Welcome " + (name.isEmpty() ? "Stranger" : name) + " the Mage!");
                statusText.setFill(Color.BLUE);
                showMainMenu();
            } else {
                statusText.setText("Please select a class.");
                statusText.setFill(Color.BLACK);
            }
        });

        VBox startScreen = new VBox(8, prompt, nameField, new HBox(10, rbA, rbB), createBtn, statusText);
        startScreen.setPadding(new Insets(12));
        centerPane.getChildren().add(startScreen);
    }

    //Main menu
    private void showMainMenu() {
        centerPane.getChildren().clear();

        Button adv = new Button("Adventure");
        adv.setOnAction(e -> {
            statusText.setText("You venture forth...");
            
        });

        Button chck = new Button("Check Stats");
        chck.setOnAction(e -> {
            statusText.setText("Stats: (placeholder)");
        });

        Button shp = new Button("Shop");
        shp.setOnAction(e -> {
            statusText.setText("Welcome to the shop. (placeholder)");
        });

        Button back = new Button("Quit");
        back.setOnAction(e -> System.exit(0));

        VBox menu = new VBox(10, statusText, adv, chck, shp, back);
        menu.setPadding(new Insets(12));
        centerPane.getChildren().add(menu);
    }

}