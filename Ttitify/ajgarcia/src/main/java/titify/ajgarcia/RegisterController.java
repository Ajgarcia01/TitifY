package titify.ajgarcia;

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

public class RegisterController implements Initializable{
	public static Stage rootstage;	
		@FXML
	    private TextField email;

	    @FXML
	    private TextField foto_text;
	    
	    @FXML
	    private ImageView foto_perfil;
	    @FXML
	    private ImageView foto_fondo;

	    @FXML
	    private Button seleccionar_foto;
	    
	    @FXML
	    private TextField nombre;

	    @FXML
	    private Button registrarse;
	    
	    @FXML
	    private PasswordField pass;
	    
	    
	    File imgFile;
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	seleccionar_foto.setOnAction(event -> {
		        FileChooser fileChooser = new FileChooser();
		        fileChooser.setTitle("Buscar Imagen");

		        // Agregar filtros para facilitar la busqueda
		        fileChooser.getExtensionFilters().addAll(
		                new FileChooser.ExtensionFilter("All Images", "*.*"),
		                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
		                new FileChooser.ExtensionFilter("PNG", "*.png")
		        );

		        // Obtener la imagen seleccionada
		        imgFile = fileChooser.showOpenDialog(rootstage);

		        // Mostar la imagen
		        if (imgFile != null) {
		            Image image = new Image("file:" + imgFile.getAbsolutePath());
		            foto_perfil.setImage(image);
		        }
		    });
	    }
	    
	    @FXML
	    public void registrarUsuario() throws IOException {
			String usuario = this.nombre.getText();
			String password = this.pass.getText();
			String correo = this.email.getText();
			String foto= imgFile.getAbsolutePath();
			Usuario a=new Usuario(usuario,password,correo,foto);
			UsuarioDAOImpMariaDB user = new UsuarioDAOImpMariaDB();
			this.nombre.clear();
			this.pass.clear();
			this.email.clear();
			if (user.buscarUser(usuario)==false) {
				user.add(a);
				System.out.println(a);
				App.setRoot("pantalla_principal");
				ControlMessages.mensajeAdvertencia("Correcto","Usuario introducido con exito");
			} else {
				ControlMessages.mensajeError("ERROR EN LOS DATOS", "Revise los datos, son erroneos");
			}
	    }
	    

}
