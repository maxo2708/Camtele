import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.File;

public class editPostController {

    final FileChooser fileChooser = new FileChooser();
    private File file = null;

    // Input variables for posts
    @FXML private ImageView newImage;
    @FXML private TextArea descInput;
    @FXML private TextField locInput;

    @FXML void selectPhoto(MouseEvent event) {
        file = fileChooser.showOpenDialog(((Node)(event.getSource())).getScene().getWindow());
        newImage.setImage(new Image(file.toURI().toString()));
    }
    @FXML void uploadPost(ActionEvent event) throws Exception{
        if (Main.currentPost == null) {
            Post post = new Post(Main.currentAcc, file.toURI().toString(), descInput.getText());
            post.setLocation(locInput.getText());
            Main.currentAcc.getPosts().add(post);
            Main.currentPost = post;
        } else {
            if (!descInput.getText().equals("")) {
            Main.currentPost.setDescription(descInput.getText());
            }
        }
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Main.replaceBigScene("viewPost.fxml");
    }

    public void initialize() {
        if (Main.currentPost != null) {
            newImage.setImage(new Image(Main.currentPost.getImageURI()));
            descInput.setPromptText(Main.currentPost.getDescription());
            locInput.setPromptText(Main.currentPost.getLocation());
        }
    }
}
