package titify.ajgarcia;

import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import titify.ajgarcia.DAOMariaDB.ListaReproduccionDAOImpMariaDB;
import titify.ajgarcia.DAOMariaDB.UsuarioDAOImpMariaDB;
import titify.ajgarcia.model.ListaReproduccion;
import titify.ajgarcia.model.Usuario;
import titify.ajgarcia.utils.ControlMessages;
/*
 * @author Jgl_11
 */
public class SuscribeController {
	UsuarioDAOImpMariaDB u1=new UsuarioDAOImpMariaDB();
	ListaReproduccionDAOImpMariaDB l1=new ListaReproduccionDAOImpMariaDB();
	
	/*
	 * CAMPOS DE SCENE BUILDER
	*/	
	
    @FXML
    private ImageView FONDO;

    @FXML
    private ComboBox<ListaReproduccion> LISTAS;

    @FXML
    private TextField listas_text;

    @FXML
    private Button boton_suscribirse;
    
    @FXML
    private Button salida;

    	
    @FXML
	private void initialize() {
    	LISTAS.setItems(FXCollections.observableArrayList(l1.mostrarTodos()));
    	Usuario.get_Instance().getId();
    	System.out.println(Usuario.get_Instance().getId());
    }
    
    /*
	 * @param id_cancion,id_usuario
	 * 
	 * @return setea el id de la cancion y del usuario y lo añade a la tabla de en medio de la BBDD usuario_listareproduccion, 
	 * invocaria a usuarios que se suscriben a una lista de reproduccion
	*/
    
    @FXML
    private void suscribe() throws SQLException {
    	int id_cancion=LISTAS.getSelectionModel().getSelectedItem().getId();
    	int id_usuario=Usuario.get_Instance().getId();
    	u1.suscribirse(id_usuario, id_cancion);
    	System.out.println(id_usuario+id_cancion);
    	ControlMessages.mensajeAdvertencia("Suscrito", "Te has suscrito con exito");
    }
    
    
    /*
	 * @return volver atras, a la pantalla del login
	*/
    
    @FXML
    public void atras() throws IOException {
     App.setRoot("pantalla_login");
    }
}
