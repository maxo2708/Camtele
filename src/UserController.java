import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class UserController {

    // FileChooser fileChooser = new FileChooser(); todo maybe delete
    // private File file = null;

    @FXML private TextField search;
    @FXML private Label searchTerm;
    @FXML private Button tagged;

    // View variables for user
    @FXML private Button condProfile;
    @FXML private Label posts, followers, following, username, nickname;
    @FXML private TextArea bio;
    @FXML private ImageView avatar, newPost, image1, image2, image3, image4, image5, image6;

    @FXML void condAction(ActionEvent event) {

    } // varied button on user profile

    @FXML void feedSelect(ActionEvent event) throws Exception{
        Main.replaceBigScene("registered.fxml");

    }
    @FXML void searchSelect(ActionEvent event) {
        searchTerm.setText(search.getText());
    }
    @FXML void logoutSelect(ActionEvent event) throws Exception{
        Main.currentAcc = null;
        Main.replaceBigScene("Unregistered.fxml");
    }
    @FXML void profileSelect(ActionEvent event) throws Exception{
        condProfile.setText("Edit");
        Main.replaceBigScene("userProfile.fxml");
        // image1.setImage();
        // todo set images + figure out how that would work
    }

    @FXML void imageSelect(MouseEvent event) throws Exception{
        Main.openNewStage("viewPost.fxml");
    }
    @FXML void displayTagged(ActionEvent event) {
        // make tagged screen
    }

    @FXML void createPost(MouseEvent event) throws Exception{
        Main.openNewStage("post.fxml");
    }

    public void initialize() {
        username.setText(Main.currentAcc.getUsername());
        nickname.setText(Main.currentAcc.getNickname());
        bio.setText(Main.currentAcc.getBio());
        posts.setText(Main.currentAcc.getPosts().size() + " Posts");
        // avatar = new ImageView(Main.currentAcc.getAvatar()); todo images
        avatar.setImage(new Image(Main.currentAcc.getAvatar()));
        followers.setText(Main.currentAcc.getFollowers().size() + " Followers");
        following.setText(Main.currentAcc.getFollowing().size() + " Following");
        tagged.setText("Photos of " + username.getText());
    }
}
