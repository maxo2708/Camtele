import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PostController {

    @FXML private TextField search;
    @FXML private Label searchTerm;

    // View variables for post
    @FXML private ImageView post, newPost;
    @FXML private TextField commInput;
    @FXML private TextArea description;
    @FXML private Label username, likes, date, locTag;
    @FXML private Button editLikeButton, regViewButton, logButton, commentButton;

    @FXML private Label user1, date1, comment1,
    user2, date2, comment2, user3, date3, comment3,
    user4, date4, comment4, user5, date5, comment5;
    private ArrayList<Label> comms;

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
    @FXML void addComment(ActionEvent event) {
        if (!commInput.getText().isEmpty()) {
            Main.currentPost.addComment(new Comment(Main.currentAcc.getUsername(), commInput.getText()));
            setComments();
        }
    } // posts

    @FXML void userSelect(MouseEvent event) throws Exception{
        Main.selectAcc = Main.accounts.get(username.getText());
        Main.replaceBigScene("userProfile.fxml");
    }
    @FXML void searchSelect(ActionEvent event) throws Exception{
        if (search.getText().equals("")) {
            return;
        }
        if (search.getText().charAt(0) == '@') {
            Main.selectAcc = Main.accounts.get(search.getText().substring(1));
            if (Main.selectAcc != null) {
                Main.replaceBigScene("userProfile.fxml");
            }
        } else if (search.getText().charAt(0) == '#') {
            Main.currentTag = Main.accounts.getTag().get(search.getText().substring(1));
            Main.replaceBigScene("feed.fxml");
        }

    }
    @FXML void feedSelect(MouseEvent event) throws Exception {
        Main.replaceBigScene("feed.fxml");
    }
    @FXML void regViewSelect(ActionEvent event) throws Exception{
        if (Main.currentAcc == null) {
            Main.openNewStage("signup.fxml");
        } else {
            Main.selectAcc = Main.currentAcc;
            Main.replaceBigScene("userProfile.fxml");
        }
    }
    @FXML void logSelect(ActionEvent event) throws Exception{
        if (Main.currentAcc == null) {
            Main.openNewStage("login.fxml");
        } else {
            Main.currentAcc = null;
            Main.replaceBigScene("feed.fxml");
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
        date.setText(formatDate(Main.currentPost.getTimeCreated()));
        locTag.setText(Main.currentPost.getLocation());

        // Establish array of comment labels
        comms = new ArrayList<Label>();
        comms.add(user1); comms.add(date1); comms.add(comment1);
        comms.add(user2); comms.add(date2); comms.add(comment2);
        comms.add(user3); comms.add(date3); comms.add(comment3);
        comms.add(user4); comms.add(date4); comms.add(comment4);
        comms.add(user5); comms.add(date5); comms.add(comment5);
        setComments();
        hideComments();
    }
    private void setComments() {
        for (int i = 0; i < Math.min(Main.currentPost.getComments().size(), comms.size() / 3); i++) {
            // user
            comms.get(i * 3).setText(Main.currentPost.getComments().get(i).getFrom());
            // date
            comms.get((i * 3) + 1).setText(formatDate(Main.currentPost.getComments().get(i).getTimeCreated()));
            // content
            comms.get((i * 3) + 2).setText(Main.currentPost.getComments().get(i).getMessageBody());
        }
    }
    private void hideComments() {
        for (int i = 0; i < comms.size(); i++) {
            if (comms.get(i).getText().equals(comms.get(i).getId())) {
                comms.get(i).setText("");
            }
        }
    }
    private String formatDate(LocalDateTime oldDate) {
        String newDate = oldDate.format(DateTimeFormatter.ofPattern("MM.dd HH:mm"));
        return newDate;
    }

    public void initialize() {
        setEverything();
        Main.selectAcc = Main.accounts.get(Main.currentPost.getAuthor());
        if (Main.currentAcc == null) {
            newPost.setDisable(true);
            newPost.setOpacity(0);
            commentButton.setDisable(true);
            editLikeButton.setOpacity(0);
            regViewButton.setText("Register");
            logButton.setText("Login");
        } else {
            regViewButton.setText("Profile");
            if (Main.currentAcc.equals(Main.selectAcc)) {
                editLikeButton.setText("Edit");
            } else {
                if (Main.currentPost.getLikes().get(Main.currentAcc.getUsername()) == null) {
                    editLikeButton.setText("Like");
                } else {
                    editLikeButton.setText("Dislike");
                }
            }
        }
    }
}
