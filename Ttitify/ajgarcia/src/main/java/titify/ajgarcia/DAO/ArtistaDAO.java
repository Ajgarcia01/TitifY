package titify.ajgarcia.DAO;

import java.util.List;

import titify.ajgarcia.model.Artista;

public interface ArtistaDAO extends iDAO<Artista>{
	List <Artista> buscarPorNombre(String Nombre);
	

}
