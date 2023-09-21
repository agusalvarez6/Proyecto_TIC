import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class logincontroller {

    @FXML
    private PasswordField contrasena_field;

    @FXML
    private Button login_button;

    @FXML
    private Button signin_view_button;

    @FXML
    private TextField usuario_field;

    @FXML
    void login_try(ActionEvent event) {
        // Here, you can add login logic if needed.
    }

    @FXML
    void signin_view(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/signIn.fxml"));
            Parent signInRoot = loader.load();

            Stage signInStage = new Stage();
            signInStage.setTitle("Sign In"); // Set a title for the new window

            Scene signInScene = new Scene(signInRoot);

            signInStage.setScene(signInScene);
            signInStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
