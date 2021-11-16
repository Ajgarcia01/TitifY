package titify.ajgarcia;

import java.io.IOException;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class ContenidoController {

@FXML
private TabPane tabpaneGENERAL;

@FXML
private Tab tab_artista;

@FXML
private TableView<Artista> artistas;

@FXML
private TableColumn<Artista, Integer> id_artista;

@FXML
private TableColumn<Artista, String> nombre_artista;

@FXML
private TableColumn<Artista, String> nacionalidad_artista;

@FXML
private TableColumn<Artista,String> foto_artista;

@FXML
private Tab tab_discos;

@FXML
private TableView<Disco> discos;

@FXML
private TableColumn<Disco, Integer> d_id;

@FXML
private TableColumn<Disco, String> d_foto;

@FXML
private TableColumn<Disco, String> d_f;

@FXML
private TableColumn<Disco, String> d_name;

@FXML
private TableColumn<Disco, String> d_artista;

@FXML
private TableColumn<Disco, Integer> d_reproducciones;

@FXML
private TableView<Cancion> canciones;

@FXML
private TableColumn<Cancion, Integer> c_id;

@FXML
private TableColumn<Cancion, String> c_name;

@FXML
private TableColumn<Cancion, Integer> c_duracion;

@FXML
private TableColumn<Cancion, String> c_genero;

@FXML
private TableColumn<Cancion, Integer> c_repro;

@FXML
private TableColumn<Cancion, String> c_disco;

@FXML
private TableView<ListaReproduccion> listas;

@FXML
private TableColumn<ListaReproduccion, Integer> l_id;

@FXML
private TableColumn<ListaReproduccion, String> l_nombre;

@FXML
private TableColumn<ListaReproduccion, String> l_descripcion;

@FXML
private TableColumn<ListaReproduccion, String> l_genero;

@FXML
private TableColumn<ListaReproduccion, Integer> l_suscriptores;

@FXML
private TableColumn<ListaReproduccion, String> l_creador;


@FXML
private TableView<Usuario> usuarios;

@FXML
private TableColumn<Usuario, Integer> u_id;

@FXML
private TableColumn<Usuario, String> u_nombre;

@FXML
private TableColumn<Usuario, String> u_correo;

@FXML
private TableColumn<Usuario, String> u_foto;

@FXML
private Button salida;



@FXML
public void initialize() throws IOException {
  tablaArtistas();
  tablaDiscos();
  tablaListasReproduccion();
  tablaCanciones();
  tablaUsuarios();
}


@FXML
private void tablaArtistas()throws IOException  {
	
	
		ArtistaDAOImpMariaDB aDAO = new ArtistaDAOImpMariaDB();
		artistas.setItems(FXCollections.observableArrayList(aDAO.mostrarTodos()));
		this.id_artista.setCellValueFactory(new PropertyValueFactory<Artista, Integer>("id"));
		this.nombre_artista.setCellValueFactory(new PropertyValueFactory<Artista, String>("nombre"));
		this.nacionalidad_artista.setCellValueFactory(new PropertyValueFactory<Artista, String>("nacionalidad"));
		this.foto_artista.setCellValueFactory(new PropertyValueFactory<Artista, String>("foto"));
		
	
}

@FXML
private void tablaDiscos()throws IOException  {
	DiscoDAOImpMariaDB aDAO = new DiscoDAOImpMariaDB();
	discos.setItems(FXCollections.observableArrayList(aDAO.mostrarTodos()));
	this.d_id.setCellValueFactory(new PropertyValueFactory<Disco,Integer>("id"));
	this.d_name.setCellValueFactory(new PropertyValueFactory<Disco,String>("nombre"));
	this.d_f.setCellValueFactory(new PropertyValueFactory<Disco,String>("fechapublicacion"));
	this.d_foto.setCellValueFactory(new PropertyValueFactory<Disco,String>("foto"));
	this.d_reproducciones.setCellValueFactory(new PropertyValueFactory<Disco,Integer>("reproducciones"));
	this.d_artista.setCellValueFactory(eachDisk-> new SimpleStringProperty(eachDisk.getValue().getArtista().getNombre()));
}


@FXML
private void tablaListasReproduccion()throws IOException  {
	ListaReproduccionDAOImpMariaDB lDAO= new ListaReproduccionDAOImpMariaDB();
	listas.setItems(FXCollections.observableArrayList(lDAO.mostrarTodos()));
	this.l_id.setCellValueFactory(new PropertyValueFactory<ListaReproduccion,Integer>("id"));
	this.l_nombre.setCellValueFactory(new PropertyValueFactory<ListaReproduccion,String>("nombre"));
	this.l_descripcion.setCellValueFactory(new PropertyValueFactory<ListaReproduccion,String>("descripcion"));
	this.l_creador.setCellValueFactory(eachDisk-> new SimpleStringProperty(eachDisk.getValue().getCreador().getNombre()));
}


@FXML
private void tablaCanciones()throws IOException  {
	CancionDAOImpMariaDB cDAO= new CancionDAOImpMariaDB();
	canciones.setItems(FXCollections.observableArrayList(cDAO.mostrarTodos()));
	this.c_id.setCellValueFactory(new PropertyValueFactory<Cancion,Integer>("id"));
	this.c_name.setCellValueFactory(new PropertyValueFactory<Cancion,String>("nombre"));
	this.c_duracion.setCellValueFactory(new PropertyValueFactory<Cancion,Integer>("duracion"));
	this.c_genero.setCellValueFactory(new PropertyValueFactory<Cancion,String>("genero"));
	this.c_repro.setCellValueFactory(new PropertyValueFactory<Cancion,Integer>("reproducciones"));
	this.c_disco.setCellValueFactory(eachCancion-> new SimpleStringProperty(eachCancion.getValue().getDisco().getNombre()));
}


@FXML
private void tablaUsuarios()throws IOException  {
	UsuarioDAOImpMariaDB uDAO= new UsuarioDAOImpMariaDB();
	usuarios.setItems(FXCollections.observableArrayList(uDAO.mostrarTodos()));
	this.u_id.setCellValueFactory(new PropertyValueFactory<Usuario,Integer>("id"));
	this.u_nombre.setCellValueFactory(new PropertyValueFactory<Usuario,String>("nombre"));
	this.u_correo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("correo"));
	this.u_foto.setCellValueFactory(new PropertyValueFactory<Usuario,String>("foto"));
}

@FXML
public void atras() throws IOException {
 App.setRoot("pantalla_principal");
}
}
