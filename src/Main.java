import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    static Accounts accounts;
    static Account currentAcc;
    private static Stage base, popup;
    private static Parent root;

    @Override public void start(Stage primaryStage) throws Exception{
        accounts = new Accounts();
        root = FXMLLoader.load(getClass().getResource("display/Unregistered.fxml"));
        base = primaryStage;
        primaryStage.setTitle("Camtele");
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void openNewStage(String fxml) throws Exception{
        try {
            AnchorPane page = FXMLLoader.load((Main.class.getResource("display/" + fxml)));
            popup = new Stage();
            popup.setTitle("Camtele");
            popup.setScene(new Scene(page));
            popup.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void replaceSmallScene(String fxml) throws Exception{
        root = FXMLLoader.load(Main.class.getResource("display/" + fxml));
        popup.setScene(new Scene(root, 400, 250));
        popup.show();
    }
    static void replaceBigScene(String fxml) throws Exception{
        try {
            Parent page = FXMLLoader.load(Main.class.getResource("display/" + fxml));
            base.setScene(new Scene(page, 600, 400));
            base.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
