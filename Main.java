import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage base;

    @Override public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("display/Unregistered.fxml"));
        setBaseStage(primaryStage);
        primaryStage.setTitle("Camtele");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    @FXML public static void openNewStage(String fxml) throws Exception{
        try {
        AnchorPane page = FXMLLoader.load(Main.class.getResource("display/" + fxml));
        Stage stage = new Stage();
        stage.setTitle("Camtele");
        stage.setScene(new Scene(page));
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @FXML public static void replaceSceneContent(String fxml) throws Exception{
        try {
            Parent page = FXMLLoader.load(Main.class.getResource("display/" + fxml));
            base.setScene(new Scene(page, 600, 400));
            base.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setBaseStage(Stage stage) { base = stage; }
    public static Stage getBaseStage() { return base; }

    public static void main(String[] args) {
        launch(args);
    }
}
