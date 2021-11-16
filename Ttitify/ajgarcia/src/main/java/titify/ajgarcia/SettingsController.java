package titify.ajgarcia;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import titify.ajgarcia.DAOMariaDB.ArtistaDAOImpMariaDB;
import titify.ajgarcia.DAOMariaDB.CancionDAOImpMariaDB;
import titify.ajgarcia.DAOMariaDB.DiscoDAOImpMariaDB;
import titify.ajgarcia.DAOMariaDB.ListaReproduccionDAOImpMariaDB;
import titify.ajgarcia.DAOMariaDB.UsuarioDAOImpMariaDB;
import titify.ajgarcia.model.Artista;
import titify.ajgarcia.model.Cancion;
import titify.ajgarcia.model.Disco;
import titify.ajgarcia.model.ListaReproduccion;
import titify.ajgarcia.model.Usuario;
import titify.ajgarcia.utils.ControlMessages;

/*
 * @author Jgl_11
 */

public class SettingsController {
	ObservableList<String> obsTipos= FXCollections.observableArrayList("Artista","Disco","Cancion","Lista De Reproduccion","Usuario");
	ArtistaDAOImpMariaDB aDAO= new ArtistaDAOImpMariaDB();
	Artista a=new Artista();
	DiscoDAOImpMariaDB dDAO= new DiscoDAOImpMariaDB();
	Disco d=new Disco();
	CancionDAOImpMariaDB cDAO= new CancionDAOImpMariaDB();
	Cancion c=new Cancion();
	ListaReproduccionDAOImpMariaDB lDAO=new ListaReproduccionDAOImpMariaDB();
	ListaReproduccion lp=new ListaReproduccion();
	UsuarioDAOImpMariaDB uDAO=new UsuarioDAOImpMariaDB();
	Usuario u=new Usuario();
    @FXML
    private ImageView fondo;

    @FXML
    private ComboBox<String> comboTipo;
    

    @FXML
    private ComboBox<String> comboTipo2;

    @FXML
    private TextField tipo;

    @FXML
    private ComboBox<Disco> comboDisco;

    @FXML
    private TextField deseado;

    @FXML
    private Button boton_aceptar;

    @FXML
    private TextField id_text;

    @FXML
    private ComboBox<Cancion> comboCancion;

    @FXML
    private ComboBox<ListaReproduccion> comboLista;

    @FXML
    private ComboBox<Usuario> comboUsuario;

    @FXML
    private ComboBox<Artista> comboArtista;
    @FXML
    private ComboBox<Artista> comboArtista2;
    
    @FXML
    private ComboBox<Disco> comboDisco2;

    @FXML
    private ComboBox<Usuario> comboCreador2;

    @FXML
    private TextField artista;

    @FXML
    private TextField disco;

    @FXML
    private TextField cancion;

    @FXML
    private TextField lista;

    @FXML
    private TextField usuario;

    @FXML
    private Button salida;
    
    @FXML
    private TextField artista_add;

    @FXML
    private TextField disco_add;

    @FXML
    private TextField cancion_add;

    @FXML
    private TextField lista_add;

    @FXML
    private TextField usuario_add;

    @FXML
    private TextField nombre_astista;

    @FXML
    private TextField nacionalidad_Artista;

    @FXML
    private TextField foto_disco;

    @FXML
    private TextField reproducciones_cancion;

    @FXML
    private TextField duracion_cancion;

    @FXML
    private TextField genero_cancion;

    @FXML
    private TextField nombre_disco;

    @FXML
    private TextField nombre_cancion;

    @FXML
    private TextField nombre_lista;

    @FXML
    private TextField descripcion_lista;

    @FXML
    private TextField nombre_usuario;

    @FXML
    private TextField pass_usuario;

    @FXML
    private TextField correo_usuario;

    @FXML
    private DatePicker fecha;

    @FXML
    private TextField foto_usuario;

    @FXML
    private TextField reproducciones_disco;
    
    @FXML
    private TextField editar_artista_text;

    @FXML
    private TextField editar_disco_text;

    @FXML
    private TextField editar_cancion_text;

    @FXML
    private TextField lista_cancion_text;

    @FXML
    private TextField editar_nombre_artista;

    @FXML
    private TextField editar_nacionalidad_artista;

    @FXML
    private TextField editar_reproducciones_disco;

    @FXML
    private TextField editar_reproducciones_cancion;

    @FXML
    private TextField editar_duracion_cancion;

    @FXML
    private TextField editar_nombre_disco;

    @FXML
    private TextField editar_nombre_cancion;

    @FXML
    private TextField editar_nombre_lista;

    @FXML
    private TextField editar_descripcion_lista;

    @FXML
    private TextField editar_nombre_usuario;

    @FXML
    private TextField editar_pass;

    @FXML
    private TextField editar_correo_usuario;

    @FXML
    private TextField editar_elegirtipo_text;

    @FXML
    private ComboBox<String> editar_tipo_box;

    @FXML
    private TextField edit_usuario_text;

    @FXML
    private ComboBox<Artista> edit_combo_artista;

    @FXML
    private ComboBox<Disco> edit_combo_disco;

    @FXML
    private ComboBox<Cancion> edit_combo_cancion;

    @FXML
    private ComboBox<ListaReproduccion> edit_combo_lista;

    @FXML
    private ComboBox<Usuario> edit_combo_usuario;

    @FXML
    private Button editar_button;
    @FXML
    private ComboBox<ListaReproduccion> LISTA_ANANIR;

    @FXML
    private ComboBox<Cancion> CANCIONES_ANANIR;

    @FXML
    private TextField ELEGIRPLAYLIST;

    @FXML
    private TextField ELEGIRCANCION;
    
    @FXML
    private Button ANANIR_BUTTON;

    
	@FXML
    public void atras() throws IOException {
     App.setRoot("pantalla_principal");
    }
	
	@FXML
	private void initialize() {
		comboTipo.setItems(obsTipos);
		comboTipo2.setItems(obsTipos);
		editar_tipo_box.setItems(obsTipos);
		comboArtista.setItems(FXCollections.observableArrayList(aDAO.mostrarTodos()));
		comboArtista2.setItems(FXCollections.observableArrayList(aDAO.mostrarTodos()));
		comboDisco.setItems(FXCollections.observableArrayList(dDAO.mostrarTodos()));
		comboDisco2.setItems(FXCollections.observableArrayList(dDAO.mostrarTodos()));
		comboCancion.setItems(FXCollections.observableArrayList(cDAO.mostrarTodos()));
		comboLista.setItems(FXCollections.observableArrayList(lDAO.mostrarTodos()));
		comboUsuario.setItems(FXCollections.observableArrayList(uDAO.mostrarTodos()));
		comboCreador2.setItems(FXCollections.observableArrayList(uDAO.mostrarTodos()));
		edit_combo_artista.setItems(FXCollections.observableArrayList(aDAO.mostrarTodos()));
		edit_combo_disco.setItems(FXCollections.observableArrayList(dDAO.mostrarTodos()));
		edit_combo_cancion.setItems(FXCollections.observableArrayList(cDAO.mostrarTodos()));
		edit_combo_lista.setItems(FXCollections.observableArrayList(lDAO.mostrarTodos()));
		edit_combo_usuario.setItems(FXCollections.observableArrayList(uDAO.mostrarTodos()));
		LISTA_ANANIR.setItems(FXCollections.observableArrayList(lDAO.mostrarTodos()));
		CANCIONES_ANANIR.setItems(FXCollections.observableArrayList(cDAO.mostrarTodos()));
		
	}
	
	@FXML
    public void seleccionarTipoEliminar() throws IOException {
		String resultado=comboTipo.getValue();
		
		switch (resultado) {
		case "Artista":
			a.setId(comboArtista.getSelectionModel().getSelectedItem().getId());
			aDAO.borrar(a);
			ControlMessages.mensajeAdvertencia("Eliminado", "Artista eliminado con exito");
			break;
			
		case "Disco":
			d.setId(comboDisco.getSelectionModel().getSelectedItem().getId());
			dDAO.borrar(d);
			ControlMessages.mensajeAdvertencia("Eliminado", "Disco eliminado con exito");
			break;
			
		case "Cancion":
			c.setId(comboCancion.getSelectionModel().getSelectedItem().getId());
			cDAO.borrar(c);
			ControlMessages.mensajeAdvertencia("Eliminado", "Cancion eliminado con exito");
			break;
		case "Lista De Reproduccion":
			lp.setId(comboLista.getSelectionModel().getSelectedItem().getId());
			lDAO.borrar(lp);
			ControlMessages.mensajeAdvertencia("Eliminado", "Lista de Reproduccion eliminado con exito");
			break;
		case "Usuario":
			u.setId(comboUsuario.getSelectionModel().getSelectedItem().getId());
			uDAO.borrar(u);
			ControlMessages.mensajeAdvertencia("Eliminado", "Usuario eliminado con exito");
			break;
		default:
			break;
		}
    }
	
	@FXML
    public void seleccionarTipoAdd() throws IOException {
		String resultado=comboTipo2.getValue();
		String nombre;int reproducciones;String repro;
		
		if(comboTipo2.isArmed()) {
			ControlMessages.mensajeError("ERROR","Debes de elegir una opcion");
		}else {
				switch (resultado) {
		case "Artista":
			nombre=nombre_astista.getText();
			String nacionalidad=nacionalidad_Artista.getText();
			Artista a1=new Artista(nombre, nacionalidad, "URL");
			aDAO.add(a1);
			ControlMessages.mensajeAdvertencia("Añadido", "Artista añadido con exito");
			break;
			
		case "Disco":
			nombre=nombre_disco.getText();
			repro=reproducciones_disco.getText();
			reproducciones=Integer.parseInt(repro);
			LocalDate f=fecha.getValue();
			Disco d1=new Disco(nombre, f, "URL", reproducciones, comboArtista2.getSelectionModel().getSelectedItem());
			dDAO.add(d1);
			ControlMessages.mensajeAdvertencia("Añadido", "Disco añadido con exito");
			break;
			
		case "Cancion":
			nombre=nombre_cancion.getText();
			String duracion=duracion_cancion.getText();
			int time=Integer.parseInt(duracion);
			repro=reproducciones_cancion.getText();
			reproducciones=Integer.parseInt(repro);
			String genero=genero_cancion.getText();
			Cancion c1=new Cancion(nombre, time, genero, reproducciones,  comboDisco2.getSelectionModel().getSelectedItem());
			cDAO.add(c1);
			ControlMessages.mensajeAdvertencia("Añadido", "Cancion añadido con exito");
			break;
		case "Lista De Reproduccion":
			nombre=nombre_lista.getText();
			String descripcion=descripcion_lista.getText();
			ListaReproduccion l1=new ListaReproduccion(nombre, descripcion, comboCreador2.getSelectionModel().getSelectedItem());
			lDAO.add(l1);
			ControlMessages.mensajeAdvertencia("Añadido", "Lista de Reproduccion añadido con exito");
			break;
		case "Usuario":
			nombre=nombre_usuario.getText();
			String pass=pass_usuario.getText();String correo=correo_usuario.getText();String foto=foto_usuario.getText();
			Usuario u1=new Usuario(nombre, pass ,correo, foto);
			uDAO.add(u1);
			ControlMessages.mensajeAdvertencia("Añadido", "Usuario añadido con exito");
			break;
		default:
			break;
		}
	  }
    }
	
	@FXML
    public void seleccionarTipoEdit() throws IOException {
		String resultado=editar_tipo_box.getValue();
		String nombre;int reproducciones;String repro;String nacionalidad;
		
		if(editar_tipo_box.isArmed()) {
			ControlMessages.mensajeError("ERROR","Debes de elegir una opcion");
		}else {
			
			switch (resultado) {
		case "Artista":
			nombre=editar_nombre_artista.getText();
			nacionalidad=editar_nacionalidad_artista.getText();
			Artista a1=new Artista(nombre, nacionalidad, edit_combo_artista.getSelectionModel().getSelectedItem().getId());
			aDAO.editar(a1);
			ControlMessages.mensajeAdvertencia("Editado", "Artista editado con exito");
			break;
			
		case "Disco":
			nombre=editar_nombre_disco.getText();
			repro=editar_reproducciones_disco.getText();
			reproducciones=Integer.parseInt(repro);
			Disco d1=new Disco(nombre,reproducciones,edit_combo_disco.getSelectionModel().getSelectedItem().getId());
			dDAO.editar(d1);
			ControlMessages.mensajeAdvertencia("Editado", "Disco editado con exito");
			break;
			
		case "Cancion":
			nombre=editar_nombre_cancion.getText();
			repro=reproducciones_cancion.getText();
			reproducciones=Integer.parseInt(repro);
			Cancion c1=new Cancion(nombre,reproducciones,edit_combo_cancion.getSelectionModel().getSelectedItem().getId());
			cDAO.editar(c1);
			ControlMessages.mensajeAdvertencia("Editado", "Cancion editada con exito");
			break;
		case "Lista De Reproduccion":
			nombre=editar_nombre_lista.getText();
			String descripcion=editar_descripcion_lista.getText();
			ListaReproduccion l1=new ListaReproduccion(nombre, descripcion, edit_combo_lista.getSelectionModel().getSelectedItem().getId());
			lDAO.editar(l1);
			ControlMessages.mensajeAdvertencia("Editado", "Lista de Reproduccion editada con exito");
			break;
		case "Usuario":
			nombre=editar_nombre_usuario.getText();
			String pass=editar_pass.getText();String correo=editar_correo_usuario.getText();
			Usuario u1=new Usuario(nombre, pass ,correo, edit_combo_usuario.getSelectionModel().getSelectedItem().getId());
			uDAO.editar(u1);
			ControlMessages.mensajeAdvertencia("Editado", "Usuario editado con exito");
			break;
		default:
			break;
		}
	  }
    }
	
	@FXML
	private void anadirCancion() throws SQLException {
		ListaReproduccionDAOImpMariaDB u1=new ListaReproduccionDAOImpMariaDB();
		int id_lista=LISTA_ANANIR.getSelectionModel().getSelectedItem().getId();
		int id_cancion=CANCIONES_ANANIR.getSelectionModel().getSelectedItem().getId();
		u1.AddCancionPlayList(id_cancion,id_lista);
		ControlMessages.mensajeAdvertencia("Añadido", "Cancion añadida con exito");
		
	}
}
