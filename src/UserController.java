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

    @FXML void condAction(ActionEvent event) throws Exception{
        Main.openNewStage("profile.fxml");
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
    }

    @FXML void selectImage1(MouseEvent event) throws Exception{
        if (Main.currentAcc.getPosts().size() >= 1) {
            Main.currentPost = Main.currentAcc.getPosts().get(0);
            Main.openNewStage("viewPost.fxml");
        }
    }
    @FXML void selectImage2(MouseEvent event) throws Exception{
        if (Main.currentAcc.getPosts().size() >= 2) {
            Main.currentPost = Main.currentAcc.getPosts().get(1);
            Main.openNewStage("viewPost.fxml");
        }
    }
    @FXML void selectImage3(MouseEvent event) throws Exception{
        if (Main.currentAcc.getPosts().size() >= 3) {
            Main.currentPost = Main.currentAcc.getPosts().get(2);
            Main.openNewStage("viewPost.fxml");
        }
    }

    @FXML void displayTagged(ActionEvent event) {
        // todo make tagged screen
    }

    @FXML void createPost(MouseEvent event) throws Exception{
        Main.currentPost = null;
        Main.openNewStage("post.fxml");
    }

    public void initialize() {
        username.setText(Main.currentAcc.getUsername());
        nickname.setText(Main.currentAcc.getNickname());
        bio.setText(Main.currentAcc.getBio());
        posts.setText(Main.currentAcc.getPosts().size() + " Posts");
        if (!Main.currentAcc.getAvatar().equals("")) {
            avatar.setImage(new Image(Main.currentAcc.getAvatar()));
        }
        followers.setText(Main.currentAcc.getFollowers().size() + " Followers");
        following.setText(Main.currentAcc.getFollowing().size() + " Following");
        if (Main.currentAcc.getPosts().size() >= 1) {
            image1.setImage(new Image(Main.currentAcc.getPosts().get(0).getImageURI()));
            if (Main.currentAcc.getPosts().size() >= 2) {
                image2.setImage(new Image(Main.currentAcc.getPosts().get(1).getImageURI()));
                if (Main.currentAcc.getPosts().size() >= 3) {
                    image3.setImage(new Image(Main.currentAcc.getPosts().get(2).getImageURI()));
                }
            }
        }
        tagged.setText("Photos of " + username.getText());

    }
}
