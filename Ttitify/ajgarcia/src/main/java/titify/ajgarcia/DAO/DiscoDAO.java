package titify.ajgarcia.DAO;

import java.util.Date;
import java.util.List;

import titify.ajgarcia.model.Disco;

public interface DiscoDAO extends iDAO<Disco>{
	List<Disco> buscarPorNombre(String nombre);
}
