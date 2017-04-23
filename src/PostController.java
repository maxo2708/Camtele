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

    /* public void setAccount (Account account) {
        this.account = account;
    }*/

    @FXML private TextField search;
    @FXML private Label searchTerm;

    // View variables for post
    @FXML private ImageView post;
    @FXML private TextArea description;
    @FXML private Label username, likes, date, locTag;
    @FXML private Button condLike;

    @FXML void editPost(ActionEvent event) throws Exception{
        Main.openNewStage("post.fxml");
    }
    @FXML void addComment(ActionEvent event) {
        String com = ""; // Replace with actual comment input
        int postNum = 0; // Replace with actual post number
        Main.currentAcc.getFeed().get(postNum).addComment(new Comment(Main.currentAcc.getUsername(), com));
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
        Main.currentPost = null;
        Main.openNewStage("post.fxml");
    } // basics

    public void initialize() {
        post.setImage(new Image(Main.currentPost.getImageURI()));
        description.setText(Main.currentPost.getDescription());
        username.setText(Main.currentPost.getAuthor());
        likes.setText(Main.currentPost.getLikes().size() + " Likes");
        date.setText(Main.currentPost.getTimeCreated().toString());
        // todo locTag
    }
}
