import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {

    Posts posts;

    @FXML private TextField search;
    @FXML private Label searchTerm;
    @FXML private Button tagButton;
    @FXML private ImageView image1, image2, image3, image4, image5, image6;

    @FXML private TextField unInput;
    @FXML private PasswordField pwdInput, sqInput;

    @FXML void registerSelect(ActionEvent event) throws Exception {
        Main.openNewStage("signup.fxml");
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
    @FXML void changePassword(ActionEvent event) throws  Exception{
        Account account = Main.accounts.get(unInput.getText());
        if (account != null && account.checkSecurityAnswer(sqInput.getText())) {
            account.setPassword(pwdInput.getText());
        } else {
            Main.openNewStage("error.fxml"); // todo check this
        }
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML void selectImage1(MouseEvent event) throws Exception{
        if (posts.size() >= 1) {
            Main.currentPost = posts.get(0);
            Main.openNewStage("viewPost.fxml");
        }
    }
    @FXML void selectImage2(MouseEvent event) throws Exception{
        if (posts.size() >= 2) {
            Main.currentPost = posts.get(1);
            Main.openNewStage("viewPost.fxml");
        }
    }
    @FXML void selectImage3(MouseEvent event) throws Exception{
        if (posts.size() >= 3) {
            Main.currentPost = posts.get(2);
            Main.openNewStage("viewPost.fxml");
        }
    }
    @FXML void selectImage4(MouseEvent event) throws Exception{
        if (posts.size() >= 4) {
            Main.currentPost = posts.get(3);
            Main.openNewStage("viewPost.fxml");
        }
    }
    @FXML void selectImage5(MouseEvent event) throws Exception{
        if (posts.size() >= 5) {
            Main.currentPost = posts.get(4);
            Main.openNewStage("viewPost.fxml");
        }
    }
    @FXML void selectImage6(MouseEvent event) throws Exception{
        if (posts.size() >= 6) {
            Main.currentPost = posts.get(5);
            Main.openNewStage("viewPost.fxml");
        }
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
            if (Main.currentAcc != null) {
                Main.replaceBigScene("registered.fxml");
            } else {
                Main.replaceBigScene("Unregistered.fxml");
            }
        }

    }
    @FXML void logoutSelect(ActionEvent event) throws Exception{
        Main.currentAcc = null;
        Main.replaceBigScene("Unregistered.fxml");
    }
    @FXML void profileSelect(ActionEvent event) throws Exception{
        Main.selectAcc = Main.currentAcc;
        Main.replaceBigScene("userProfile.fxml");
    }
    @FXML void createPost(MouseEvent event) throws Exception{
        Main.currentPost = null;
        Main.openNewStage("post.fxml");
    } // basics

    private void setImages() {
        if (image1 != null && posts.size() >= 1) {
            image1.setImage(new Image(posts.get(0).getImageURI()));
            if (posts.size() >= 2) {
                image2.setImage(new Image(posts.get(1).getImageURI()));
                if (posts.size() >= 3) {
                    image3.setImage(new Image(posts.get(2).getImageURI()));
                    if (posts.size() >= 4) {
                        image4.setImage(new Image(posts.get(3).getImageURI()));
                        if (posts.size() >= 5) {
                            image5.setImage(new Image(posts.get(4).getImageURI()));
                            if (posts.size() >= 6) {
                                image6.setImage(new Image(posts.get(5).getImageURI()));
                            }
                        }
                    }
                }
            }
        }
    }
    public void initialize () {
        if (Main.currentTag == null) {
            if (Main.currentAcc != null) {
                posts = Main.currentAcc.getFeed();
            } else {
                // Get posts from all of the users
                posts = new Posts();
                for (int i = 0; i < Main.accounts.size(); i++) {
                    posts.add(Main.accounts.get(i).getPosts());
                }
            }
        } else {
            searchTerm.setText(Main.currentTag.getName());
            posts = Main.currentTag.getPosts();
            Main.currentTag = null;
        }
        setImages();
    }
}
