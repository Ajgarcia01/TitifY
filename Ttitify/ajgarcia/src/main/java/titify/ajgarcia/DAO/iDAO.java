package titify.ajgarcia.DAO;

import java.util.List;

public interface iDAO <T>{
	void guardar();
	void editar();
	void borrar();
	List<T> mostrarTodos();
}
