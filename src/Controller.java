import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.File;

public class Controller {

    final FileChooser fileChooser = new FileChooser();
    private File file = null;

    @FXML private TextField search;
    @FXML private Label searchTerm;
    @FXML private Button tagButton, tagged;

    @FXML private ImageView newPost, image1, image2, image3, image4, image5, image6;

    @FXML void condAction(ActionEvent event) {
        username.setText("un");

    } // varied button on user profile
    @FXML void feedSelect(ActionEvent event) throws Exception{
        Main.replaceBigScene("registered.fxml");

    }
    @FXML void followTag(ActionEvent event) {
        System.out.println(search.getText());
        // what?
    }
    @FXML void registerSelect(ActionEvent event) throws Exception {
        Main.openNewStage("signup.fxml");
        // todo how to know if register or edit? if logged in already;
        // todo also switch with the login?
    }
    @FXML void loginSelect(ActionEvent event) throws Exception{
        Main.openNewStage("login.fxml");
    }
    @FXML void attemptLogin(ActionEvent event) throws Exception{
        Account accAttempt = Main.accounts.get(unInput.getText());
        if (accAttempt != null) {
            boolean loggedIn = accAttempt.checkPassword(pwdInput.getText());
            if (loggedIn) {
                Main.currentAcc = accAttempt;
                ((Node)(event.getSource())).getScene().getWindow().hide();
                Main.replaceBigScene("registered.fxml");
            } else {
                //TODO: State that password is incorrect
            }
        } else {
            // TODO: State that username does not exist
        }
    }
    @FXML void searchSelect(ActionEvent event) {
        searchTerm.setText(search.getText());
        if (Main.currentAcc != null) {
            tagButton.setText("Follow " + search.getText());
            tagButton.setDisable(false);
        }
    }
    @FXML void logoutSelect(ActionEvent event) throws Exception{
        Main.replaceBigScene("Unregistered.fxml");
    }
    @FXML void notifSelect(ActionEvent event) {
        // todo make notif stage?
    }
    @FXML void profileSelect(ActionEvent event) throws Exception{
        // username.setText(Main.currentAcc.getUsername());
        Main.replaceBigScene("userProfile.fxml");
    }

    @FXML void forgotPasswordSelect(ActionEvent event) throws Exception{
        Main.openNewStage("forgotPassword.fxml");
    }
    @FXML void changePassword(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }



    @FXML void imageSelect(MouseEvent event) throws Exception{
        Main.openNewStage("viewPost.fxml");
    }

    @FXML void displayTagged(ActionEvent event) {
        // make tagged screen
    }

    @FXML void uploadPost(MouseEvent event) throws Exception{
        Main.openNewStage("post.fxml");

    }

    @FXML void addComment(ActionEvent event) {

    }

    @FXML void changeLike(ActionEvent event) {

    } // navigate

    // Input variables for user
    @FXML private TextField unInput, nnInput;
    @FXML private PasswordField pwdInput, sqInput;
    @FXML private TextArea bioInput;
    @FXML private ImageView avatar;

    // View variables for user
    @FXML private Button condProfile;
    @FXML private Label posts, followers, following, username, nickname;
    @FXML private TextArea bio;

    @FXML void createAccount(ActionEvent event) throws Exception{
        Main.currentAcc = new Account(unInput.getText(),pwdInput.getText(), sqInput.getText());
        Main.accounts.add(Main.currentAcc);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Main.replaceSmallScene("profile.fxml");
    }
    @FXML void avatarSelect(MouseEvent event) {
        file = fileChooser.showOpenDialog(((Node)(event.getSource())).getScene().getWindow());
        Main.currentAcc.setAvatar(file.toURI().toString()); //todo may be broken?
    }
    @FXML void finishProfile(ActionEvent event) throws Exception{
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Main.replaceBigScene("registered.fxml");
        Main.currentAcc.setNickname(nnInput.getText());
        Main.currentAcc.setBio(bioInput.getText());
    } // user

    // Input variables for posts
    @FXML private ImageView newImage;
    @FXML private TextArea descInput;
    @FXML private TextField locInput;

    // View variables for post
    @FXML private ImageView post;
    @FXML private TextArea description;
    @FXML private Label likes, date, locTag;
    @FXML private Button condLike;

    @FXML void selectPhoto(MouseEvent event) {
        file = fileChooser.showOpenDialog(((Node)(event.getSource())).getScene().getWindow());
        newImage = new ImageView(file.toURI().toString());
    }
    @FXML void createPost(ActionEvent event) {
        file = fileChooser.showOpenDialog(((Node)(event.getSource())).getScene().getWindow());
        Post post = new Post(Main.currentAcc, file.toURI().toString(), descInput.getText());
        Main.currentAcc.getPosts().add(post);
        posts.setText(Main.currentAcc.getPosts().size() + " Posts");
        ((Node)(event.getSource())).getScene().getWindow().hide();

    } // posts

    public void initialize () {

    }
}
