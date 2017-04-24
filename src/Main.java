import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {

    static Post currentPost;
    static Accounts accounts;
    static Account currentAcc, selectAcc;
    static Tag currentTag;
    static String error;
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
        setTestUsers();

        root = FXMLLoader.load(getClass().getResource("display/feed.fxml"));
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
            AnchorPane page = FXMLLoader.load(Main.class.getResource("display/" + fxml));
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

    static void setTestUsers() {
        // tester user
        if (accounts.get("socialsloth") == null) {
            Account art = new Account("socialsloth", "bradypus", "allofem");
            art.setAvatar("file:/C:/Users/Clare/Pictures/1Camtele/ORASTrainer.png");
            art.setNickname("Juju");
            art.setBio("This is my art blog. uwu \nCatch me on dA and tumblr as well!");
            accounts.add(art);
        }
        if (accounts.get("Brandon") == null) {
            Account brandon = new Account("Brandon", "password", "red");
            brandon.setAvatar("file:/C:/Users/Clare/Pictures/1Camtele/brandon1.jpg");
            brandon.setNickname("brozek");
            brandon.setBio("This is my only social media account.");
            accounts.add(brandon);
        }
        if (accounts.get("sneakysnek") == null) {
            Account snek = new Account("sneakysnek", "slither", "green");
            snek.setAvatar("file:/C:/Users/Clare/Pictures/1Camtele/snake4.jpg");
            snek.setNickname("pythonprojectpartner");
            snek.setBio("Hissssssss");
            accounts.add(snek);
        }
        if (accounts.get("immortalhuskyboy") == null) {
            Account husky = new Account("immortalhuskyboy", "barkbark", "white");
            husky.setAvatar("file:/C:/Users/Clare/Pictures/1Camtele/huskyprofile.jpg");
            husky.setNickname("huskee");
            husky.setBio("Cats aren't the only ones with 9 lives.");
            accounts.add(husky);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
