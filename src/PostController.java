import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PostController {

    Account poster;

    @FXML private TextField search;
    @FXML private Label searchTerm;

    // View variables for post
    @FXML private ImageView post, newPost;
    @FXML private TextField comment;
    @FXML private TextArea description;
    @FXML private Label username, likes, date, locTag;
    @FXML private Button editLikeButton, logButton, commentButton;

    @FXML private Label user1, date1, comment1,
    user2, date2, comment2, user3, date3, comment3,
    user4, date4, comment4, user5, date5, comment5;

    @FXML void editLikePost(ActionEvent event) throws Exception{
        if (poster.equals(Main.currentAcc)) {
            Main.openNewStage("post.fxml");
        } else {
            if (editLikeButton.getText().equals("Like")){
                Main.currentPost.likePost(Main.currentAcc);
                editLikeButton.setText("Unlike");
                likes.setText(Main.currentPost.getLikes().size() + " Likes");
            } else {
                Main.currentPost.dislikePost(Main.currentAcc);
                editLikeButton.setText("Like");
                likes.setText(Main.currentPost.getLikes().size() + " Likes");
            }
        }
    }
    @FXML void likeComment(ActionEvent event) {

    }
    @FXML void addComment(ActionEvent event) {
        String com = ""; // todo Replace with actual comment input
        int postNum = 0; // todo Replace with actual post number
        Main.currentAcc.getFeed().get(postNum).addComment(new Comment(Main.currentAcc.getUsername(), com));
    } // posts

    // todo username select
    @FXML void searchSelect(ActionEvent event) {
        searchTerm.setText(search.getText());
    }
    @FXML void feedSelect(ActionEvent event) throws Exception{
        if (Main.currentAcc == null) {
            Main.replaceBigScene("Unregistered.fxml");
        } else {
            Main.replaceBigScene("registered.fxml");
        }
    }
    @FXML void logSelect(ActionEvent event) throws Exception{
        if (Main.currentAcc == null) {
            Main.openNewStage("signup.fxml");
        } else {
            Main.currentAcc = null;
            Main.replaceBigScene("Unregistered.fxml");
        }
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
        poster = Main.accounts.get(Main.currentPost.getAuthor());
        if (Main.currentAcc == null) {
            newPost.setDisable(true);
            newPost.setOpacity(0);
            locTag.setDisable(true);
            commentButton.setDisable(true);
            editLikeButton.setDisable(true);
            logButton.setText("Login");
            // todo locTag
        } else {
            if (Main.currentAcc.equals(poster)) {
                editLikeButton.setText("Edit");
            } else {
                editLikeButton.setText("Like");
            }
        }
    }
}
