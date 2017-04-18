import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.File;

public class Controller {

    Accounts accounts = new Accounts();
    Account currentAcc = null;

    final FileChooser fileChooser = new FileChooser();
    private File file;
    @FXML private TextField search;
    @FXML private Button tagButton;

    @FXML private ImageView post;
    @FXML private TextArea description;
    @FXML private Button condLike;
    @FXML private Label likes;
    @FXML private Label date;
    @FXML private Label locTag;

    @FXML private ImageView newImage;
    @FXML private TextArea descInput;
    @FXML private TextField locInput;

    @FXML private TextField unInput;
    @FXML private PasswordField pwdInput;
    @FXML private PasswordField sqInput;
    @FXML private TextField nnInput;
    @FXML private TextArea bioInput;
    @FXML private ImageView avatar;

    @FXML private Label searchTerm;
    @FXML private Button condProfile;
    @FXML private Label posts;
    @FXML private Label followers;
    @FXML private Label following;
    @FXML private Button tagged;
    @FXML private Label username;
    @FXML private Label nickname;
    @FXML private TextArea bio;

    @FXML private ImageView newPost;
    @FXML private ImageView image1;
    @FXML private ImageView image2;
    @FXML private ImageView image3;
    @FXML private ImageView image4;
    @FXML private ImageView image5;
    @FXML private ImageView image6;

    @FXML void changePage(MouseEvent event) {

    } // pagination feature
    @FXML void condAction(ActionEvent event) {

    } // varied button on user profile

    @FXML void feedSelect(ActionEvent event) {

    }
    @FXML void avatarSelect(MouseEvent event) {
        file = fileChooser.showOpenDialog(((Node)(event.getSource())).getScene().getWindow());
        avatar = new ImageView(file.toURI().toString());
    }
    @FXML void followTag(ActionEvent event) {
        System.out.println(search.getText());
        // what?
    }

    @FXML void selectPhoto(MouseEvent event) {
        file = fileChooser.showOpenDialog(((Node)(event.getSource())).getScene().getWindow());
        newImage = new ImageView(file.toURI().toString());
    }
    @FXML void createPost(ActionEvent event) {
        file = fileChooser.showOpenDialog(((Node)(event.getSource())).getScene().getWindow());
        Post post = new Post(currentAcc, file.toURI().toString(), descInput.getText());
        currentAcc.getPosts().add(post);
        posts.setText(currentAcc.getPosts().size() + " Posts");
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML void registerSelect(ActionEvent event) throws Exception {
        Main.openNewStage("signup.fxml");
        // how to know if register or edit? if logged in already;
        // also switch with the login?
    }
    @FXML void loginSelect(ActionEvent event) throws Exception{
        Main.openNewStage("login.fxml");
    }
    @FXML void attemptLogin(ActionEvent event) throws Exception{
        // Terrible Assumption: Account wanted is in first index of accounts
        boolean loggedIn = accounts.get(0).checkPassword(pwdInput.getText());
        if (loggedIn) {
            currentAcc = accounts.get(0);
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Main.replaceSceneContent("registered.fxml");
        } else {
            // States that password is incorrect
        }

    }
    @FXML void searchSelect(ActionEvent event) {
        searchTerm.setText(search.getText());
        tagButton.setText("Follow " + search.getText());
        tagButton.setDisable(false);
    }
    @FXML void logoutSelect(ActionEvent event) throws Exception{
        Main.replaceSceneContent("Unregistered.fxml");
    }
    @FXML void notifSelect(ActionEvent event) {
        // make notif stage?
    }
    @FXML void profileSelect(ActionEvent event) throws Exception{
        Main.replaceSceneContent("userProfile.fxml");
    }
    @FXML void forgotPasswordSelect(ActionEvent event) throws Exception{
        Main.openNewStage("forgotPassword.fxml");
    }
    @FXML void changePassword(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


    @FXML void finishProfile(ActionEvent event) throws Exception{
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Main.replaceSceneContent("userProfile.fxml");
        currentAcc.setNickname(nnInput.getText());
        currentAcc.setBio(bioInput.getText());
        currentAcc.setAvatar(file.toURI().toString());
        username.setText(currentAcc.getUsername());
        nickname.setText(currentAcc.getNickname());
        posts.setText(currentAcc.getPosts().size() + " Posts");
        followers.setText("0 Followers");
        following.setText("0 Following");
        bio.setText(currentAcc.getBio());
    }
    @FXML void createAccount(ActionEvent event) throws Exception{
        currentAcc = new Account(unInput.getText(),pwdInput.getText());
        accounts.add(currentAcc);
        System.out.println(sqInput.getText());
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Main.openNewStage("profile.fxml");
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

    }

}
