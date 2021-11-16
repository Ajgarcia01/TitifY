package titify.ajgarcia;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import titify.ajgarcia.DAOMariaDB.UsuarioDAOImpMariaDB;
import titify.ajgarcia.model.Usuario;
import titify.ajgarcia.utils.ControlMessages;
/*
 * @author Jgl_11
 */
public class LoginController {
		@FXML
	    private TextField nombre;

	    @FXML
	    private Button entrar;

	    @FXML
	    private PasswordField pass;
	    
	    @FXML
	    private Button crearcuenta;

	    
	    @FXML
	    public void iniciarSesion() throws IOException {
			String usuario = this.nombre.getText();
			String password = this.pass.getText();
			Usuario.get_Instance().setNombre(usuario);
			Usuario.get_Instance().setId(0);
			UsuarioDAOImpMariaDB user = new UsuarioDAOImpMariaDB();
			this.nombre.clear();
			this.pass.clear();
			if (user.logearse(usuario, password)==true) {
				Usuario.get_Instance().setId(user.buscarPorNombre(usuario).getId());
				App.setRoot("pantalla_principal");
			} else {
				ControlMessages.mensajeError("ERROR EN LOS DATOS", "Revise los datos, son erroneos");
			}
	    }
	    @FXML
	    private void switchToRegister() throws IOException {
	    	App.setRoot("pantalla_register");
	    }
	    
}
