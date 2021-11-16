package titify.ajgarcia.DAO;

import java.util.List;

import titify.ajgarcia.model.Cancion;

public interface CancionDAO extends iDAO<Cancion>{
	//List<Cancion> buscarPorDuracion(int duracion);
	List<Cancion> buscarPorNombre(String nombre);
	List<Cancion> buscarPorGenero(String genero);
}
