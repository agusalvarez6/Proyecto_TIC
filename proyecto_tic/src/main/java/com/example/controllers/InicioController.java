import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InicioController {

    @FXML
    private Label Registrarse_label;

    @FXML
    private Label ingresar_label;

    @FXML
    void GoToLogIn(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/login.fxml"));
            Parent logInRoot = loader.load();

            Stage logInStage = new Stage();
            logInStage.setTitle("Log In"); // Set a title for the new window

            Scene logInScene = new Scene(logInRoot);

            logInStage.setScene(logInScene);
            logInStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GoToSignIn(ActionEvent event) {
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
