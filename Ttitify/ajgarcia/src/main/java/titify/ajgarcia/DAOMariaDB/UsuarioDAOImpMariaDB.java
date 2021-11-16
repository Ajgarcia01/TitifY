package titify.ajgarcia.DAOMariaDB;
/*
 * @author Jgl_11
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import titify.ajgarcia.DAO.UsuarioDAO;
import titify.ajgarcia.model.Artista;
import titify.ajgarcia.model.Disco;
import titify.ajgarcia.model.ListaReproduccion;
import titify.ajgarcia.model.Usuario;
import titify.ajgarcia.utils.ConexionBD;

public class UsuarioDAOImpMariaDB extends Usuario implements UsuarioDAO {
	//Consultas
	private static final String INSERT="INSERT INTO usuario (id,nombre,pass,correo,foto) VALUES (?,?,?,?,?)";
	private static final String EDITAR="UPDATE usuario SET nombre=?,pass=?,correo=? WHERE id=?";
	private static final String BORRAR="DELETE FROM usuario WHERE id=?";
	private static final String MOSTRARTODOS="SELECT id,nombre,pass,correo,foto FROM usuario";
	private static final String MOSTRARTODOSxNOMBRE="SELECT id,nombre,pass,correo,foto FROM usuario WHERE nombre LIKE ?";
	private static final String MOSTRARxID="SELECT id,nombre,pass,correo,foto FROM usuario WHERE id=?";
	private static final String USERLOG="SELECT nombre,pass FROM usuario WHERE nombre=? AND pass=?";
	private static final String USERSEARCH="SELECT nombre FROM usuario WHERE nombre=?";
	private static final String SUSCRIBE="INSERT INTO usuario_listareproduccion (id_usuario, id_lr) VALUES (?,?)";
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	public UsuarioDAOImpMariaDB() {
		
	}
	
	public UsuarioDAOImpMariaDB(int id,String nombre,String pass,String correo,String foto) {
		super(id,nombre,pass,correo,foto);
	}
	
	public UsuarioDAOImpMariaDB(int id,int id2) {
		super(id,id2);
	}
	
	
	/*
	 * @param Usuario
	 * 
	 * @return añade a la base de datos con los parametros que se le han pasado, de mano de la consulta
	 */
	
	@Override
	public void add(Usuario a) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(INSERT,ps.RETURN_GENERATED_KEYS);
				ps.setInt(1,a.getId());
				ps.setString(2,a.getNombre());
				ps.setString(3,a.getPass());
				ps.setString(4,a.getCorreo());
				ps.setString(5,a.getFoto());
				ps.executeUpdate();
				rs=ps.getGeneratedKeys();
				if(rs.next()) {
					this.id=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					ps.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * @param Usuario
	 * 
	 * @return edita  de la base de datos con los parametros que se le han pasado, de mano de la consulta
	 */
	
	@Override
	public void editar(Usuario a) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(EDITAR);
				ps.setString(1,a.getNombre());
				ps.setString(2,a.getPass());
				ps.setString(3,a.getCorreo());
				ps.setInt(4,a.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					ps.close();
				}catch (Exception e) {
					
				}
			}
		}
		
	}
	
	
	/*
	 * @param Usuario
	 * 
	 * @return elmina de la base de datos con los parametros que se le han pasado, de mano de la consulta
	 */
	
	
	@Override
	public void borrar(Usuario a) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(BORRAR);
				ps.setInt(1, a.getId());
				ps.executeUpdate();
				this.id=-1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					ps.close();
				}catch (Exception e) {
					
				}
			}
		}
		
	}

	/*
	 * @param Usuario
	 * 
	 * @return devuelve una lista de usuarios, en este caso todos los usuarios que haya en la BBDD
	 */
	
	@Override
	public List<Usuario> mostrarTodos() {
		List<Usuario> resultado=new ArrayList<>();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOS);
				rs=ps.executeQuery();
				while(rs.next()) {
					resultado.add(new UsuarioDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("pass"),
							rs.getString("correo"),
							rs.getString("foto")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					ps.close();
					rs.close();
				}catch (Exception e) {
					
				}
			}
		}
		return resultado;
		
	}

	/*
	 * @param Usuario
	 * 
	 * @return devuelve un usuario, en este caso el usuario que contenga el id que le hemos pasado por parametro
	 */
	
	@Override
	public Usuario mostrar(int id) {
		Usuario resultado=new UsuarioDAOImpMariaDB();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARxID);
				ps.setInt(1, id);
				rs=ps.executeQuery();
				while(rs.next()) {
					resultado=new UsuarioDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("pass"),
							rs.getString("correo"),
							rs.getString("foto"));
				}
				//fin de extraer el id generado automaticamente
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					ps.close();
					rs.close();
				}catch (Exception e) {
					
				}
			}
		}
		return resultado;
		
	}
	
	/*
	 * @param Lista de Usuario
	 * 
	 * @return devuelve una lista de usuarios, en este caso todos los usuarios que contengan el nombre pasado por parametro
	 */
	
	@Override
	public Usuario buscarPorNombre(String Nombre) {
		Usuario resultado=new UsuarioDAOImpMariaDB();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOSxNOMBRE);
				ps.setString(1, Nombre);
				rs=ps.executeQuery();
				while(rs.next()) {
					resultado=new UsuarioDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("pass"),
							rs.getString("correo"),
							rs.getString("foto"));
				}
				//fin de extraer el id generado automaticamente
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("No hay resultados");
			}finally {
				try {
					ps.close();
					rs.close();
				}catch (Exception e) {
					
				}
			}
		}
		return resultado;
		
	}
	
	/*
	 * @param Usuario
	 * 
	 * @return devuelve un true si el usuario y la contraseña del user son correctas y lo logea y un false si los datos no coinciden
	 */
	
	public boolean logearse(String usuario,String password) {
		
		boolean log=false;
		
		con= ConexionBD.getConexion();
		
		
		if(con!=null) {
			try {
				
				PreparedStatement q=con.prepareStatement(USERLOG);
				q.setString(1, usuario);
				q.setString(2, password);
				ResultSet rs=q.executeQuery();
				
				if(rs.next()) {
					log=true;
				}else
					log=false;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return log;
	}
	
	/*
	 * @param Usuario
	 * 
	 * @return devuelve un true si el usuario se encuentra en la bbdd y un false si no existe
	 */
	
	public boolean buscarUser(String usuario) {
		
		boolean log=false;
		
		con= ConexionBD.getConexion();
		
		
		if(con!=null) {
			try {
				
				PreparedStatement q=con.prepareStatement(USERSEARCH);
				q.setString(1, usuario);
				ResultSet rs=q.executeQuery();
				
				if(rs.next()) {
					log=true;
				}else
					log=false;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return log;
	}
	
	
	/*
	 * @param id_usuario,id_lp
	 * 
	 * @return suscribe a un usuario en concreto a una lista de reproduccion
	 */
	
	public void suscribirse(int id_usuario,int id_lp) throws SQLException {
		con=ConexionBD.getConexion();
		if(con!=null) {
		try {
			ps=con.prepareStatement(SUSCRIBE);
			ps.setInt(1, id_usuario);
			ps.setInt(2, id_lp);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			}catch (Exception e) {
				System.out.println(e);
			}
		   }
		  }
		 }	
		}
