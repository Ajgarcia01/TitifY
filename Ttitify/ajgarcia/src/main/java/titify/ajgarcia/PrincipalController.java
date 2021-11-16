package titify.ajgarcia;
/*
 * @author Jgl_11
 */
	import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import titify.ajgarcia.DAOMariaDB.UsuarioDAOImpMariaDB;
import titify.ajgarcia.model.Usuario;
import titify.ajgarcia.utils.ControlMessages;

	public class PrincipalController implements Initializable {
		
		    @FXML
		    private Button contenido;

		    @FXML
		    private Button configuracion;
		    
		    @FXML
		    private TextField username;
		    
		    @FXML
		    private Button suscribirse_principal;
		    

		   
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			String user=Usuario.get_Instance().getNombre();
			Usuario.get_Instance().getId();
			String ad="Admin";
			if(user.matches(ad)) {
				contenido.setDisable(false);
			}else {
				contenido.setDisable(true);
			}
			
			username.setText("BIENVENIDO a TitiFy "+user);
			
		}   
 
	    @FXML
	    private void switchToContent() throws IOException {
	    	App.setRoot("pantalla_ventanas");
	    }
	    
	    @FXML
	    private void switchToSuscribre() throws IOException {
	    	App.setRoot("pantalla_suscribe");
	    }
	    
	    @FXML
	    private void switchToSettings() throws IOException {
	    	App.setRoot("pantalla_settings");
	    }
	    
	   
	    @FXML
	    public void atras() throws IOException {
	     App.setRoot("pantalla_login");
	    }

		
	
	}