
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ProgAssignmentM5A1 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Pane pane = new HBox(10);
    pane.setPadding(new Insets(5, 5, 5, 5));

    //Logos for C, C++, C#, and Holy C
    Image image = new Image("https://toppng.com/public/uploads/preview/c-programming-icon-c-programming-language-logo-11562945679duaxtn3yq0.png");
    ImageView imageView2 = new ImageView(image);
    imageView2.setFitHeight(100);
    imageView2.setFitWidth(100);
    pane.getChildren().add(imageView2);
    

    Image image2 = new Image("https://logodix.com/logo/1137946.png");
    ImageView imageView3 = new ImageView(image2);
    imageView3.setFitHeight(100);
    imageView3.setFitWidth(100);
    pane.getChildren().add(imageView3);

    Image image3 = new Image("https://image.shutterstock.com/image-vector/c-sharp-programming-language-sign-260nw-1953851587.jpg");
    ImageView imageView4 = new ImageView(image3);
    imageView4.setFitHeight(100);
    imageView4.setFitWidth(100);
    pane.getChildren().add(imageView4);

    Image image4 = new Image("https://tiermaker.com/images/templates/nacho-stability-check-15792880/157928801684463319.png");
    ImageView imageView5 = new ImageView(image4);
    imageView5.setFitHeight(100);
    imageView5.setFitWidth(100);
    pane.getChildren().add(imageView5);
    

    
    Scene scene = new Scene(pane, 640, 480);
    primaryStage.setTitle("M5A1");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
