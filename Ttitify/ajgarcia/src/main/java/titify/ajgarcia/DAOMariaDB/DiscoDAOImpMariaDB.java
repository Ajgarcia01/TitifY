package titify.ajgarcia.DAOMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import titify.ajgarcia.DAO.DiscoDAO;
import titify.ajgarcia.model.Artista;
import titify.ajgarcia.model.Cancion;
import titify.ajgarcia.model.Disco;
import titify.ajgarcia.utils.ConexionBD;

public class DiscoDAOImpMariaDB extends Disco implements DiscoDAO{
	//CONSULTAS
		private static final String INSERT="INSERT INTO disco (id,nombre,fechapublicacion,foto,reproducciones,id_artista) VALUES (?,?,?,?,?,?)";
		private static final String EDITAR="UPDATE disco SET nombre=?,reproducciones=? WHERE id=?";
		private static final String BORRAR="DELETE FROM disco WHERE id=?";
		private static final String MOSTRARTODOS="SELECT id,nombre,fechapublicacion,foto,reproducciones,id_artista FROM disco";
		private static final String MOSTRARTODOSxNOMBRE="SELECT id,nombre,fechapublicacion,foto,reproducciones,id_artista FROM disco WHERE nombre LIKE ?";
		private static final String MOSTRARxID="SELECT id,nombre,fechapublicacion,foto,reproducciones,id_artista FROM disco WHERE id=?";
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	public DiscoDAOImpMariaDB () {
		
	}
	
	public DiscoDAOImpMariaDB (int id,String nombre, LocalDate fechapublicacion, String foto, int reproducciones) {
		super(id,nombre,fechapublicacion,foto,reproducciones);
	}
	
	public DiscoDAOImpMariaDB (int id,String nombre, LocalDate fechapublicacion, String foto, int reproducciones,Artista a) {
		super(id,nombre,fechapublicacion,foto,reproducciones,a);
	}
	
	/*
	 * @param disco
	 * 
	 * @return añade a la base de datos con los parametros que se le han pasado, de mano de la consulta
	 */
	
	
	@Override
	public void add(Disco d) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(INSERT,ps.RETURN_GENERATED_KEYS);
				ps.setInt(1, d.getId());
				ps.setString(2,d.getNombre());
				ps.setDate(3,java.sql.Date.valueOf(d.getFechapublicacion()));
				ps.setString(4,d.getFoto());
				ps.setInt(5,d.getReproducciones());
				ps.setObject(6, d.getArtista().getId());
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
	 * @param disco
	 * 
	 * @return edita de la base de datos con los parametros que se le han pasado, de mano de la consulta
	 */
	
	@Override
	public void editar(Disco d) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(EDITAR);
				ps.setString(1,d.getNombre());
				ps.setInt(2,d.getReproducciones());
				ps.setInt(3, d.getId());
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
	 * @param disco
	 * 
	 * @return elimina de la base de datos con los parametros que se le han pasado, de mano de la consulta
	 */
	
	@Override
	public void borrar(Disco d) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(BORRAR);
				ps.setInt(1, d.getId());
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
	 * @param Disco
	 * 
	 * @return devuelve un disco, en este caso el que contenga el id que le hayamos pasado por parametro
	 */
	
	
	@Override
	public Disco mostrar(int id) {
		Disco resultado=new DiscoDAOImpMariaDB();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARxID);
				ps.setInt(1, id);
				rs=ps.executeQuery();
				while(rs.next()) {
					ArtistaDAOImpMariaDB dd=new ArtistaDAOImpMariaDB();
					Artista d=dd.mostrar(rs.getInt("id_artista"));
					resultado=new DiscoDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getDate("fechapublicacion").toLocalDate(),
							rs.getString("foto"),
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
	 * @param Lista de discos
	 * 
	 * @return devuelve una lista de discos, en este caso todos los discos de la BBDD
	 */
	
	@Override
	public List<Disco> mostrarTodos() {
		List<Disco> resultado=new ArrayList<Disco>();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOS);
				rs=ps.executeQuery();
				while(rs.next()) {
					ArtistaDAOImpMariaDB dd=new ArtistaDAOImpMariaDB();
					Artista d=dd.mostrar(rs.getInt("id_artista"));
					resultado.add(new DiscoDAOImpMariaDB(rs.getInt("id"),
					rs.getString("nombre"),
					rs.getDate("fechapublicacion").toLocalDate(),
					rs.getString("foto"),
					rs.getInt("reproducciones"),
					d));
				
				}
			} catch (SQLException e) {
				
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
	 * @param Lista de discos
	 * 
	 * @return devuelve una lista de discos, en este caso todas los discos que contengan el nombre que le hemos pasado por parametro
	 */
	
	@Override
	public List<Disco> buscarPorNombre(String nombre) {
		List<Disco> resultado=new ArrayList<Disco>();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOSxNOMBRE);
				ps.setString(1, nombre);
				rs=ps.executeQuery();
				while(rs.next()) {
					ArtistaDAOImpMariaDB dd=new ArtistaDAOImpMariaDB();
					Artista d=dd.mostrar(rs.getInt("id_artista"));
					resultado.add(new DiscoDAOImpMariaDB(rs.getInt("id"),
					rs.getString("nombre"),
					rs.getDate("fechapublicacion").toLocalDate(),
					rs.getString("foto"),
					rs.getInt("reproducciones"),
					d));
				
				}
			} catch (SQLException e) {
				
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
}	
