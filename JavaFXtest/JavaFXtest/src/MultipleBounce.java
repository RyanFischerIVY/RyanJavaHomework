

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MultipleBounce extends Application {
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


//Image image2 = new Image("https://www.bing.com/images/search?view=detailV2&ccid=BGFa9NdC&id=3344CAC21993505E19699FCC4857F168A612D89C&thid=OIP.BGFa9NdCc6kb-eXVLT4hmQHaHO&mediaurl=https%3a%2f%2fimg.favpng.com%2f23%2f10%2f7%2fc-programming-language-logo-microsoft-visual-studio-net-framework-png-favpng-WLLTMqZhSPAk9q3DTh993fZnh.jpg&cdnurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fR.04615af4d74273a91bf9e5d52d3e2199%3frik%3dnNgSpmjxV0jMnw%26pid%3dImgRaw%26r%3d0&exph=800&expw=820&q=C%23+Programming+Logo&FORM=IRPRST&ck=F6D8326F93957CDE1A14AF9D98F7E0F9&selectedIndex=1&itb=0");
    //Image image3 = new Image("https://www.bing.com/images/search?view=detailV2&ccid=lHb%2bby%2bZ&id=0D70B8BDD0499A6791ECFC020EC0C4D8217A1ECC&thid=OIP.lHb-by-Z3SiY8ywOE_aR2QAAAA&mediaurl=https%3a%2f%2fe7.pngegg.com%2fpngimages%2f889%2f976%2fpng-clipart-the-c-programming-language-computer-programming-programming-miscellaneous-blue-thumbnail.png&cdnurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fR.9476fe6f2f99dd2898f32c0e13f691d9%3frik%3dzB56IdjEwA4C%252fA%26pid%3dImgRaw%26r%3d0&exph=332&expw=348&q=C%23+Programming+Logo&FORM=IRPRST&ck=75D5330F2282D88991D262D2B89BBF44&selectedIndex=0&itb=0");
    //Image image4 = new Image("https://www.bing.com/images/search?view=detailV2&ccid=9Rx749DF&id=3F9AD2D71852D2FB9C63BA5848F3F5E03F8E22E2&thid=OIP.9Rx749DFW3hc6Qa2IaZN2AAAAA&mediaurl=https%3a%2f%2fi.redd.it%2fogzpwqpf8gv51.png&cdnurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fR.f51c7be3d0c55b785ce906b621a64dd8%3frik%3d4iKOP%252bD180hYug%26pid%3dImgRaw%26r%3d0&exph=370&expw=327&q=holy+c+logo&FORM=IRPRST&ck=A53F7AE3B5941DA2B09B31470757A135&selectedIndex=0&itb=1");