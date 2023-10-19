import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.example.entities.Account;
import com.example.services.AccountService;

@Component
public class SignInController {

    @FXML
    private PasswordField contrasena1_signin_field;

    @FXML
    private PasswordField contrasena2_signin_field;

    @FXML
    private Button signin_button;

    @FXML
    private TextField usuario_signin_field;

    @Autowired
    private AccountService accountService;

    @FXML
    void saveUser(ActionEvent event) {
        String username = usuario_signin_field.getText();
        String password = contrasena1_signin_field.getText();
        
        // Verifica que las contraseñas coincidan (puedes agregar más validaciones si es necesario)
        if (!password.equals(contrasena2_signin_field.getText())) {
            // Muestra un mensaje de error o realiza alguna acción apropiada.
            return;
        }

        // Crea un nuevo objeto de usuario
        Account nuevoUsuario = new Account();
        nuevoUsuario.setUsername(username);
        nuevoUsuario.setPassword(password);

        // Llama al servicio para guardar el usuario
        Account usuarioGuardado = accountService.saveAccount(nuevoUsuario);

        if (usuarioGuardado != null) {
            // El usuario se ha guardado con éxito, puedes realizar acciones adicionales si es necesario.
        } else {
            // Ocurrió un error al guardar el usuario, muestra un mensaje de error o realiza alguna acción apropiada.
        }
    }
}

    /*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomePane.setStyle("-fx-background-color: #2C2C2C");
        loginPane.setStyle("-fx-background-color: #2C2C2C");
        welcomeText.setStyle("-fx-fill: #FFFFFF");
        usuarioTextField.setStyle("-fx-background-color: #FFFFFF");
        contrasenaPasswordField.setStyle("-fx-background-color: #FFFFFF");
        confirmContrasenaPasswordField.setStyle("-fx-background-color: #FFFFFF");
        crearCuentaButton.setStyle("-fx-background-color: #FFFFFF");
    }
    

    @FXML
    public void saveUser(javafx.event.ActionEvent actionEvent)  {
        Account account = new Account();
        String usuario = usuario_signin_field.getText();
        String contrasena = contrasena1_signin_field.getText();
        String confirmContrasena = contrasena2_signin_field.getText();
        if (contrasena.equals(confirmContrasena)) {
            account.setUsername(usuario);
            account.setPassword(contrasena);
            account.setRole("Client");
            accountService.saveAccount(account);
        }
    }
    */

