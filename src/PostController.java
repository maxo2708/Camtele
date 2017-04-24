import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class PostController {

    @FXML private TextField search;
    @FXML private Label searchTerm;

    // View variables for post
    @FXML private ImageView post, newPost;
    @FXML private TextField commInput;
    @FXML private TextArea description;
    @FXML private Label username, likes, date, locTag;
    @FXML private Button editLikeButton, logButton, commentButton;

    @FXML private Label user1, date1, comment1,
    user2, date2, comment2, user3, date3, comment3,
    user4, date4, comment4, user5, date5, comment5;
    private ArrayList<Label> coms;

    @FXML void editLikePost(ActionEvent event) throws Exception{
        if (Main.currentAcc.equals(Main.selectAcc)) {
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
        Main.currentPost.addComment(new Comment(Main.currentAcc.getUsername(), commInput.getText()));
        setComments();
    } // posts

    @FXML void userSelect(MouseEvent event) throws Exception{
        Main.selectAcc = Main.accounts.get(username.getText());
        Main.replaceBigScene("userProfile.fxml");
    }
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
            Main.openNewStage("login.fxml");
        } else {
            Main.currentAcc = null;
            Main.replaceBigScene("Unregistered.fxml");
        }
    }
    @FXML void createPost(MouseEvent event) throws Exception{
        Main.currentPost = null;
        Main.openNewStage("post.fxml");
    } // basics

    private void setEverything() {
        post.setImage(new Image(Main.currentPost.getImageURI()));
        description.setText(Main.currentPost.getDescription());
        username.setText(Main.currentPost.getAuthor());
        likes.setText(Main.currentPost.getLikes().size() + " Likes");
        date.setText(Main.currentPost.getTimeCreated().toString());
        locTag.setText(Main.currentPost.getLocation());

        // Establish array of comment labels
        coms = new ArrayList<Label>();
        coms.add(user1); coms.add(date1); coms.add(comment1);
        coms.add(user2); coms.add(date2); coms.add(comment2);
        coms.add(user3); coms.add(date3); coms.add(comment3);
        coms.add(user4); coms.add(date4); coms.add(comment4);
        coms.add(user5); coms.add(date5); coms.add(comment5);

        setComments();
    }
    private void setComments() {
        for (int i = 0; i < Math.min(Main.currentPost.getComments().size(), coms.size() / 3); i++) {
            // user
            coms.get(i * 3).setText(Main.currentPost.getComments().get(i).getFrom());
            // date
            coms.get((i * 3) + 1).setText(Main.currentPost.getComments().get(i).getTimeCreated().toString());
            // content
            coms.get((i * 3) + 2).setText(Main.currentPost.getComments().get(i).getMessageBody());
        }
    }

    public void initialize() {
        setEverything();
        Main.selectAcc = Main.accounts.get(Main.currentPost.getAuthor());
        if (Main.currentAcc == null) {
            newPost.setDisable(true);
            newPost.setOpacity(0);
            locTag.setDisable(true);
            commentButton.setDisable(true);
            editLikeButton.setDisable(true);
            logButton.setText("Login");


        } else {
            if (Main.currentAcc.equals(Main.selectAcc)) {
                editLikeButton.setText("Edit");
            } else {
                editLikeButton.setText("Like"); // todo check like/dislike based on current user
            }
        }
    }
}
