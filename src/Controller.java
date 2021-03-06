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
    @FXML private ImageView image1, image2, image3, image4, image5, image6, newPost;
    @FXML private Button regViewButton, logButton;

    @FXML void selectImage1(MouseEvent event) throws Exception{
        if (posts.size() >= 1) {
            Main.currentPost = posts.get(0);
            Main.replaceBigScene("viewPost.fxml");
        }
    }
    @FXML void selectImage2(MouseEvent event) throws Exception{
        if (posts.size() >= 2) {
            Main.currentPost = posts.get(1);
            Main.replaceBigScene("viewPost.fxml");
        }
    }
    @FXML void selectImage3(MouseEvent event) throws Exception{
        if (posts.size() >= 3) {
            Main.currentPost = posts.get(2);
            Main.replaceBigScene("viewPost.fxml");
        }
    }
    @FXML void selectImage4(MouseEvent event) throws Exception{
        if (posts.size() >= 4) {
            Main.currentPost = posts.get(3);
            Main.replaceBigScene("viewPost.fxml");
        }
    }
    @FXML void selectImage5(MouseEvent event) throws Exception{
        if (posts.size() >= 5) {
            Main.currentPost = posts.get(4);
            Main.replaceBigScene("viewPost.fxml");
        }
    }
    @FXML void selectImage6(MouseEvent event) throws Exception{
        if (posts.size() >= 6) {
            Main.currentPost = posts.get(5);
            Main.replaceBigScene("viewPost.fxml");
        }
    }

    @FXML void feedSelect(MouseEvent event) throws Exception {
        Main.replaceBigScene("feed.fxml");
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
    @FXML void logSelect(ActionEvent event) throws Exception{
        if (Main.currentAcc == null) {
            Main.openNewStage("login.fxml");
        } else {
            Main.currentAcc = null;
            Main.replaceBigScene("feed.fxml");
        }
    }
    @FXML void regViewSelect(ActionEvent event) throws Exception{
        if (Main.currentAcc == null) {
            Main.openNewStage("signup.fxml");
        } else {
            Main.selectAcc = Main.currentAcc;
            Main.replaceBigScene("userProfile.fxml");
        }
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
        if (Main.currentAcc == null) {
            newPost.setDisable(true);
            newPost.setOpacity(0);
            regViewButton.setText("Register");
            logButton.setText("Login");
        } else {
            regViewButton.setText("Profile");
            logButton.setText("Logout");
        }
        if (Main.currentTag == null) {
            searchTerm.setOpacity(0);
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
