package titify.ajgarcia.DAO;

import java.util.List;

import titify.ajgarcia.DAOMariaDB.ListaReproduccionDAOImpMariaDB;
import titify.ajgarcia.model.Cancion;
import titify.ajgarcia.model.ListaReproduccion;
import titify.ajgarcia.model.Usuario;

public interface ListaReproduccionDAO extends iDAO<ListaReproduccion> {
	List<ListaReproduccion> buscarPorNombre(String nombre);
	List<Usuario> mostrarUsuarios(int users);
	List<Cancion> mostrarCanciones(int id_playlist);
	
}
