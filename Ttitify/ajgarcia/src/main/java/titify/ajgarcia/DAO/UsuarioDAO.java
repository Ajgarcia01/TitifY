package titify.ajgarcia.DAO;

import java.util.List;

import titify.ajgarcia.model.Usuario;

public interface UsuarioDAO extends iDAO<Usuario> {
	Usuario buscarPorNombre(String Nombre);
}
