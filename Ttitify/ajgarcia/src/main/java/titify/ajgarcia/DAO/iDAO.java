package titify.ajgarcia.DAO;

import java.util.List;

import titify.ajgarcia.model.Artista;

public interface iDAO <T>{
	void add(T a);
	void editar(T a);
	void borrar(T a);
	List<T> mostrarTodos();
	T mostrar(int id);
}
