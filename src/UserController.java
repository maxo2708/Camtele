import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class UserController {

    // View variables for user
    @FXML
    private Button tagged, editFollowButton, logButton;
    @FXML
    private Label posts, followers, following, username, nickname;
    @FXML
    private TextField search;
    @FXML
    private TextArea bio;
    @FXML
    private ImageView avatar, newPost, image1, image2, image3;

    @FXML
    void editFollowAccount(ActionEvent event) throws Exception {
        if (Main.currentAcc.equals(Main.selectAcc)) {
            Main.openNewStage("profile.fxml");
        } else {
            if (editFollowButton.getText().equals("Follow")) {
                // todo and so on...
            }
        }

    } // varied button on user profile

    @FXML
    void feedSelect(ActionEvent event) throws Exception {
        if (Main.currentAcc == null) {
            Main.replaceBigScene("Unregistered.fxml");
        } else {
            Main.replaceBigScene("registered.fxml");
        }
    }

    @FXML
    void searchSelect(ActionEvent event) {
        //todo open registered with search term passed
    }

    @FXML
    void logSelect(ActionEvent event) throws Exception {
        if (Main.currentAcc == null) {
            Main.openNewStage("login.fxml");
        } else {
            Main.currentAcc = null;
            Main.replaceBigScene("Unregistered.fxml");
        }
    }

    @FXML
    void selectImage1(MouseEvent event) throws Exception {
        if (Main.currentAcc.getPosts().size() >= 1) {
            Main.currentPost = Main.currentAcc.getPosts().get(0);
            Main.openNewStage("viewPost.fxml");
        }
    }

    @FXML
    void selectImage2(MouseEvent event) throws Exception {
        if (Main.currentAcc.getPosts().size() >= 2) {
            Main.currentPost = Main.currentAcc.getPosts().get(1);
            Main.openNewStage("viewPost.fxml");
        }
    }

    @FXML
    void selectImage3(MouseEvent event) throws Exception {
        if (Main.currentAcc.getPosts().size() >= 3) {
            Main.currentPost = Main.currentAcc.getPosts().get(2);
            Main.openNewStage("viewPost.fxml");
        }
    }

    @FXML
    void displayTagged(ActionEvent event) {
        // todo make tagged screen
    }

    @FXML
    void createPost(MouseEvent event) throws Exception {
        Main.currentPost = null;
        Main.openNewStage("post.fxml");
    }

    private void setEverything(Account acc) {
        username.setText(acc.getUsername());
        nickname.setText(acc.getNickname());
        bio.setText(acc.getBio());
        posts.setText(acc.getPosts().size() + " Posts");
        if (!acc.getAvatar().equals("")) {
            avatar.setImage(new Image(acc.getAvatar()));
        }
        followers.setText(acc.getFollowers().size() + " Followers");
        following.setText(acc.getFollowing().size() + " Following");
        setImages(acc);
    }

    private void setImages(Account acc) {
        if (acc.getPosts().size() >= 1) {
            image1.setImage(new Image(acc.getPosts().get(0).getImageURI()));
            if (acc.getPosts().size() >= 2) {
                image2.setImage(new Image(acc.getPosts().get(1).getImageURI()));
                if (acc.getPosts().size() >= 3) {
                    image3.setImage(new Image(acc.getPosts().get(2).getImageURI()));
                }
            }
        }
    }

    public void initialize() {
        setEverything(Main.selectAcc);
        if (Main.currentAcc == null) {
            newPost.setDisable(true);
            newPost.setOpacity(0);
            editFollowButton.setDisable(true);
            logButton.setText("Login");
        } else {
            if (Main.currentAcc.equals(Main.selectAcc)) {
                editFollowButton.setText("Edit");
                tagged.setText("Photos of You");
            } else {
                editFollowButton.setText("Follow"); // todo based on user
                tagged.setText("Photos of " + username.getText());
            }
        }
    }
}