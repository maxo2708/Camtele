import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class errorController {
    @FXML private Label errorMessage;

    public void initialize() {
        errorMessage.setText(Main.error);
    }
}
