import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;


import java.io.File;

public class PostController {

    FileChooser fileChooser = new FileChooser();
    private File file = null;

    @FXML private TextField search;
    @FXML private Label searchTerm;

    // Input variables for posts
    @FXML private ImageView newImage;
    @FXML private TextArea descInput;
    @FXML private TextField locInput;

    // View variables for post
    @FXML private ImageView post;
    @FXML private TextArea description;
    @FXML private Label likes, date, locTag;
    @FXML private Button condLike;

    @FXML void changeLike(ActionEvent event) {

    }
    @FXML void addComment(ActionEvent event) {
        String com = ""; // Replace with actual comment input
        int postNum = 0; // Replace with actual post number
        Main.currentAcc.getFeed(Main.currentAcc).get(postNum).addComment(new Comment(Main.currentAcc.getUsername(), com));
    }
    @FXML void selectPhoto(MouseEvent event) {
        file = fileChooser.showOpenDialog(((Node)(event.getSource())).getScene().getWindow());
        newImage = new ImageView(file.toURI().toString());
    }
    @FXML void uploadPost(ActionEvent event) {
        file = fileChooser.showOpenDialog(((Node)(event.getSource())).getScene().getWindow());
        Post post = new Post(Main.currentAcc, file.toURI().toString(), descInput.getText());
        Main.currentAcc.getPosts().add(post);
        ((Node)(event.getSource())).getScene().getWindow().hide();

    } // posts

    @FXML void searchSelect(ActionEvent event) {
        searchTerm.setText(search.getText());
    }
    @FXML void feedSelect(ActionEvent event) throws Exception{
        Main.replaceBigScene("registered.fxml");

    }
    @FXML void logoutSelect(ActionEvent event) throws Exception{
        Main.currentAcc = null;
        Main.replaceBigScene("Unregistered.fxml");
    }
    @FXML void createPost(MouseEvent event) throws Exception{
        Main.openNewStage("post.fxml");
    } // basics

    public void initialize() {
        // post.setImage(); todo same image shit
        // description.setText(); todo pull image info from selected image??


        //post.setImage(new Image("INSERT URI HERE"));

    }
}
