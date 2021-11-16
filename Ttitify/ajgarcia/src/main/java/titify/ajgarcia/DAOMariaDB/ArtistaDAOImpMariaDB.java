package titify.ajgarcia.DAOMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import titify.ajgarcia.DAO.ArtistaDAO;
import titify.ajgarcia.DAO.iDAO;
import titify.ajgarcia.model.Artista;
import titify.ajgarcia.model.Cancion;
import titify.ajgarcia.utils.ConexionBD;

public class ArtistaDAOImpMariaDB extends Artista implements ArtistaDAO{
	//CONSULTAS
	private static final String INSERT="INSERT INTO artista (nombre,nacionalidad,foto) VALUES (?,?,?)";
	private static final String EDITAR="UPDATE artista SET nombre=?,nacionalidad=? WHERE id=?";
	private static final String BORRAR="DELETE FROM artista WHERE id=?";
	private static final String MOSTRARTODOS="SELECT id,nombre,nacionalidad,foto FROM artista";
	private static final String MOSTRARTODOSxNOMBRE="SELECT id,nombre,nacionalidad,foto FROM artista WHERE nombre LIKE ?";
	private static final String MOSTRARTODOSxID="SELECT id,nombre,nacionalidad,foto FROM artista WHERE id=?";
	
	
	
	
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	public ArtistaDAOImpMariaDB () {
		super();
	}
	
	public ArtistaDAOImpMariaDB (int id,String nombre,String nacionalidad,String foto) {
		super(id,nombre,nacionalidad,foto);
	}
	
	
	public ArtistaDAOImpMariaDB(int id,String nombre,String nacionalidad) {
		super(id,nombre,nacionalidad);
	}
				
	@Override
	public void add(Artista a) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(INSERT,ps.RETURN_GENERATED_KEYS);
				ps.setString(1,a.getNombre());
				ps.setString(2,a.getNacionalidad());
				ps.setString(3,a.getFoto());
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
	

	@Override
	public void editar(Artista a) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(EDITAR);
				ps.setString(1,a.getNombre());
				ps.setString(2,a.getNacionalidad());
				ps.setInt(3, a.getId());
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

	@Override
	public void borrar(Artista a) {
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
	
	@Override
	public Artista mostrar(int id) {
		Artista resultado=new ArtistaDAOImpMariaDB();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOSxID);
				ps.setInt(1, id);
				rs=ps.executeQuery();
				while(rs.next()) {
					resultado=new ArtistaDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("nacionalidad"),
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

	@Override
	public List<Artista> mostrarTodos() {
		List<Artista> resultado=new ArrayList<Artista>();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOS);
				rs=ps.executeQuery();
				while(rs.next()) {
					resultado.add(new ArtistaDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("nacionalidad"),
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
	@Override
	public List <Artista> buscarPorNombre(String Nombre) {
		List<Artista> resultado=new ArrayList<Artista>();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOSxNOMBRE);
				ps.setString(1, Nombre);
				rs=ps.executeQuery();
				while(rs.next()) {
					resultado.add(new ArtistaDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("nacionalidad"),
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
	
}
