package display;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private TextField unInput;

    @FXML
    private PasswordField pwdInput;

    @FXML
    private PasswordField sqInput; // signup var

    @FXML
    void createAccount(ActionEvent event) {

    }

    @FXML
    void pageBack(ActionEvent event) {

    } // signup methods

    @FXML
    private TextField search;

    @FXML
    private Label searchTerm;

    @FXML
    private Button tagButton;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6; // unreg var

    @FXML
    void followTag(ActionEvent event) {

    }

    @FXML
    void loginSelect(ActionEvent event) {

    }

    @FXML
    void registerSelect(ActionEvent event) {

    }

    @FXML
    void searchSelect(ActionEvent event) {

    } // unreg methods

    @FXML
    private TextField imageURL;

    @FXML
    private TextArea description;

    @FXML
    private TextField location; // post data var

    @FXML
    void createPost(ActionEvent event) {

    } // post data methods

    @FXML
    private Label username;

    @FXML
    private Button condProfile;

    @FXML
    private Label posts;

    @FXML
    private Label followers;

    @FXML
    private Label following;

    @FXML
    private Button tagged; // user profile var

    @FXML
    void changePage(MouseEvent event) {

    }

    @FXML
    void condAction(ActionEvent event) {

    }

    @FXML
    void image1Select(MouseEvent event) {

    }

    @FXML
    void image2Select(MouseEvent event) {

    }

    @FXML
    void image3Select(MouseEvent event) {

    }

    @FXML
    void logoutSelect(ActionEvent event) {

    }

    @FXML
    void notifSelect(ActionEvent event) {

    }

    @FXML
    void profileSelect(ActionEvent event) {

    }

    @FXML
    void displayTagged(ActionEvent event) {

    }

    @FXML
    void uploadPost(MouseEvent event) {

    } // user profile methods

    @FXML
    private TextField nickname;

    @FXML
    private TextArea bio;

    @FXML
    private ImageView avatar; // create profile var

    @FXML
    void avatarSelect(MouseEvent event) {

    }

    @FXML
    void finishProfile(ActionEvent event) {

    } // create profile methods

    @FXML
    void attemptLogin(ActionEvent event) {

    }

    @FXML
    void forgotPasswordSelect(ActionEvent event) {

    } // login methods

    @FXML
    void changePassword(ActionEvent event) {

    } // forgot pwd method

    @FXML
    private ImageView newPost;

    @FXML
    void selectPhoto(MouseEvent event) {

    } // new post

    @FXML
    private ImageView post;

    @FXML
    private Button condLike;

    @FXML
    private Label likes;

    @FXML
    private Label displayTime;

    @FXML
    private Label displayLocation; // view post var

    @FXML
    void addComment(ActionEvent event) {

    }

    @FXML
    void changeLike(ActionEvent event) {

    } // view post methods


}
