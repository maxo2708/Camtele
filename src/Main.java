import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {
    // Clare is awesome :)

    static Post currentPost;
    static Accounts accounts;
    static Account currentAcc;
    private static Stage base, popup;
    private static Parent root;

    @Override public void start(Stage primaryStage) throws Exception{
//        // Deserializing accounts.ser
        try {
            FileInputStream fileIn = new FileInputStream("accounts.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Main.accounts = (Accounts) in.readObject();
            in.close(); fileIn.close();
            System.out.println("Serialized data is read.");
        }
        catch(FileNotFoundException e) {
            // Create a new accounts structures
            Main.accounts = new Accounts();
        }
        catch (IOException e2) { e2.printStackTrace(); return; }
        catch (ClassNotFoundException e3) { e3.printStackTrace(); return; }

        if (Main.accounts == null) {
            Main.accounts = new Accounts();
        }

        //accounts = new Accounts();
        root = FXMLLoader.load(getClass().getResource("display/Unregistered.fxml"));
        base = primaryStage;
        primaryStage.setTitle("Camtele");
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override public void stop() {
        // Serializing Accounts
        try {
            FileOutputStream fileOut = new FileOutputStream("accounts.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Main.accounts);
            out.close(); fileOut.close();
            System.out.println("Serialized data is saved in accounts.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    /* static void replaceBigPC(String fxml, Account account) throws Exception{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("display/" + fxml));
            Parent page = fxmlLoader.load();
            PostController postController = fxmlLoader.<PostController>getController();
            postController.setAccount(account);
            base.setScene(new Scene(page, 600, 400));
            base.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */

    public static void main(String[] args) {
        launch(args);
    }
}
