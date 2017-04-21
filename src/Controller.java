import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.BufferedInputStream;
import java.io.File;

public class Controller {

    final FileChooser fileChooser = new FileChooser();
    private File file = null;

    @FXML private Button condProfile;
    @FXML private TextField search;
    @FXML private Label searchTerm;
    @FXML private Button tagButton;
    @FXML private ImageView image1, image2, image3, image4, image5, image6;

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
                Main.openNewStage("error.fxml");
            }
        } else {
            Main.openNewStage("error.fxml");
        }
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

    // Input variables for user
    @FXML private TextField unInput, nnInput;
    @FXML private PasswordField pwdInput, sqInput;
    @FXML private TextArea bioInput;

    @FXML void createAccount(ActionEvent event) throws Exception{
        if (unInput.getText().length() > 0 && pwdInput.getText().length() > 0 && sqInput.getText().length() > 0) {
            Main.currentAcc = new Account(unInput.getText(),pwdInput.getText(), sqInput.getText());
            Main.accounts.add(Main.currentAcc);
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Main.replaceSmallScene("profile.fxml");
        } else {
            //TODO: Else throw some error indication
            Main.currentAcc = new Account(unInput.getText(), pwdInput.getText(), sqInput.getText());
            Main.accounts.add(Main.currentAcc);
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Main.replaceSmallScene("profile.fxml");
        }
    }
    @FXML void avatarSelect(MouseEvent event) {
        file = fileChooser.showOpenDialog(((Node)(event.getSource())).getScene().getWindow());
        Main.currentAcc.setAvatar(file.toURI().toString()); //todo may be broken? Brandon: Do you ever store this URI in a javafx variable?


    }
    @FXML void finishProfile(ActionEvent event) throws Exception{
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Main.replaceBigScene("registered.fxml");
        Main.currentAcc.setNickname(nnInput.getText());
        Main.currentAcc.setBio(bioInput.getText());
    } // user

    @FXML void searchSelect(ActionEvent event) {
        searchTerm.setText(search.getText());
    }
    @FXML void logoutSelect(ActionEvent event) throws Exception{
        Main.currentAcc = null;
        Main.replaceBigScene("Unregistered.fxml");
    }
    @FXML void profileSelect(ActionEvent event) throws Exception{
        // condProfile.setText("Edit"); todo same null problem, work around is always treat as edit initially
        Main.replaceBigScene("userProfile.fxml");
        // image1.setImage();
        // todo set images + figure out how that would work
    }
    @FXML void createPost(MouseEvent event) throws Exception{
        Main.openNewStage("post.fxml");
    } // basics


    public void initialize () {

    }
}
