package titify.ajgarcia.DAOMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import titify.ajgarcia.DAO.CancionDAO;
import titify.ajgarcia.model.Cancion;
import titify.ajgarcia.model.Disco;
import titify.ajgarcia.utils.ConexionBD;

public class CancionDAOImpMariaDB extends Cancion implements CancionDAO{
	//Consultas
	private static final String INSERT="INSERT INTO cancion (id,nombre,duracion,genero,reproducciones,id_disco) VALUES (?,?,?,?,?,?)";
	private static final String EDITAR="UPDATE cancion SET nombre=?,reproducciones=? WHERE id=?";
	private static final String BORRAR="DELETE FROM cancion WHERE id=?";
	private static final String MOSTRARTODOS="SELECT id,nombre,duracion,genero,reproducciones,id_disco FROM cancion";
	private static final String MOSTRARTODOSxNOMBRE="SELECT id,nombre,duracion,genero,reproducciones,id_disco FROM cancion WHERE nombre LIKE ?";
	private static final String BUSCARxGENERO="SELECT id,nombre,duracion,genero,reproducciones,id_disco FROM cancion WHERE genero LIKE ?";
	private static final String MOSTRARxID="SELECT id,nombre,duracion,genero,reproducciones,id_disco FROM cancion WEHERE id=?";
	
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	public CancionDAOImpMariaDB(){
		
	}
	
	public CancionDAOImpMariaDB(int id,String nombre, int duracion, String genero, int reproducciones){
		super(id,nombre,duracion,genero,reproducciones);
	}
	
	public CancionDAOImpMariaDB(int id,String nombre, int duracion, String genero, int reproducciones,Disco d){
		super(id,nombre,duracion,genero,reproducciones,d);
	}
	
	public CancionDAOImpMariaDB(String nombre,  int duracion,int reproducciones){
		super(nombre,duracion,reproducciones);
	}

	public CancionDAOImpMariaDB(int int1, int int2, int int3) {
		// TODO Auto-generated constructor stub
	}

	
	 /*
		 * @param cancion
		 * 
		 * @return añade a la base de datos con los parametros que se le han pasado, de mano de la consulta
	 */
	
	@Override
	public void add(Cancion a) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(INSERT,ps.RETURN_GENERATED_KEYS);
				ps.setInt(1,a.getId());
				ps.setString(2,a.getNombre());
				ps.setInt(3,a.getDuracion());
				ps.setString(4,a.getGenero());
				ps.setInt(5,a.getReproducciones());
				ps.setObject(6, a.getDisco().getId());
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

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			
		}
		
	}

	
	 /*
	 * @param cancion
	 * 
	 * @return edita de la base de datos con los parametros que se le han pasado, de mano de la consulta
	 */
	
	@Override
	public void editar(Cancion a) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(EDITAR);
				ps.setString(1,a.getNombre());
				ps.setInt(2,a.getReproducciones());
				ps.setInt(3, a.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			
		}
		
	}

	
	/*
	 * @param cancion
	 * 
	 * @return borra de la base de datos con los parametros que se le han pasado, de mano de la consulta
	 */
	
	
	@Override
	public void borrar(Cancion a) {
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
		
	}
	
	
	/*
	 * @param Lista de canciones
	 * 
	 * @return devuelve una lista de canciones, en este caso todas las canciones de la BBDD
	 */
	

	@Override
	public List<Cancion> mostrarTodos() {
		
		List<Cancion>result=new ArrayList<Cancion>();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOS);
				rs=ps.executeQuery();
				while(rs.next()) {
					DiscoDAOImpMariaDB dd=new DiscoDAOImpMariaDB();
					Disco d=dd.mostrar(rs.getInt("id"));
					result.add(new CancionDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getInt("duracion"),
							rs.getString("genero"),
							rs.getInt("reproducciones"),
							d));
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
		return result;
	}
	

	/*
	 * @param Cancion
	 * 
	 * @return devuelve una cancion, en este caso la que tenga el id que le hemos pasado
	 */
	
	
	@Override
	public Cancion mostrar(int id) {
		Cancion resultado=new CancionDAOImpMariaDB();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARxID);
				ps.setInt(1, id);
				rs=ps.executeQuery();
				while(rs.next()) {
					DiscoDAOImpMariaDB dd=new DiscoDAOImpMariaDB();
					Disco d=dd.mostrar(rs.getInt("id"));
					resultado=new CancionDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getInt("duracion"),
							rs.getString("genero"),
							rs.getInt("reproducciones"),
							d);
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
	 * @param Lista de canciones
	 * 
	 * @return devuelve una lista de canciones, en este caso todas las canciones que contengan el nombre que le hemos pasado por parametro
	 */
	

	@Override
	public List<Cancion> buscarPorNombre(String nombre) {

		List<Cancion>result=new ArrayList<Cancion>();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOSxNOMBRE);
				ps.setString(1, nombre);
				rs=ps.executeQuery();
				while(rs.next()) {
					DiscoDAOImpMariaDB dd=new DiscoDAOImpMariaDB();
					Disco d=dd.mostrar(rs.getInt("id"));
					result.add(new CancionDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getInt("duracion"),
							rs.getString("genero"),
							rs.getInt("reproducciones"),
							d));
					
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
		return result;
	}
	
	/*
	 * @param Lista de canciones
	 * 
	 * @return devuelve una lista de canciones, en este caso todas las canciones que contengan el genero que le hemos pasado por parametro
	 */
	
	
	@Override
	public List<Cancion> buscarPorGenero(String genero) {

		List<Cancion>result=new ArrayList<Cancion>();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(BUSCARxGENERO);
				ps.setString(1, genero);
				rs=ps.executeQuery();
				while(rs.next()) {
					DiscoDAOImpMariaDB dd=new DiscoDAOImpMariaDB();
					Disco d=dd.mostrar(rs.getInt("id"));
					result.add(new CancionDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getInt("duracion"),
							rs.getString("genero"),
							rs.getInt("reproducciones"),
							d));
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
		return result;
	}
	
	
}
