import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.File;

public class editUserController {

    final FileChooser fileChooser = new FileChooser();
    private File file = null;

    // Input variables for user
    @FXML private TextField unInput, nnInput;
    @FXML private PasswordField pwdInput, sqInput;
    @FXML private TextArea bioInput;
    @FXML private ImageView avatar;

    @FXML void createAccount(ActionEvent event) throws Exception {
        if (unInput.getText().length() > 0 && pwdInput.getText().length() > 0 && sqInput.getText().length() > 0) {
            Main.currentAcc = new Account(unInput.getText(), pwdInput.getText(), sqInput.getText());
            Main.accounts.add(Main.currentAcc);
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Main.replaceSmallScene("profile.fxml");
        } else {
            Main.openNewStage("error.fxml");
            //TODO: Else throw some error indication
        }
    }
    @FXML void avatarSelect(MouseEvent event) {
        file = fileChooser.showOpenDialog(((Node) (event.getSource())).getScene().getWindow());
        if (file != null) {
            avatar.setImage(new Image(file.toURI().toString()));
        }
    }
    @FXML void finishProfile(ActionEvent event) throws Exception {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Main.selectAcc = Main.currentAcc; // todo check if okay

        if (!nnInput.getText().equals("")) {
            Main.currentAcc.setNickname(nnInput.getText());
        } if (!bioInput.getText().equals("")) {
            Main.currentAcc.setBio(bioInput.getText());
        } if (file != null) {
            Main.currentAcc.setAvatar(file.toURI().toString());
        }
        Main.replaceBigScene("userProfile.fxml");
    } // user

    public void initialize() {
        if (Main.currentAcc != null) {
            if (!Main.currentAcc.getNickname().equals("")) {
                nnInput.setPromptText(Main.currentAcc.getNickname());
            } if (!Main.currentAcc.getBio().equals("")) {
                bioInput.setPromptText(Main.currentAcc.getBio());
            } if (!Main.currentAcc.getAvatar().equals("")) {
                avatar.setImage(new Image(Main.currentAcc.getAvatar())); // todo ???? who knows
            }

        }
    }
}