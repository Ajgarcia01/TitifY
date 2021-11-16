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

import titify.ajgarcia.DAO.ListaReproduccionDAO;
import titify.ajgarcia.model.Artista;
import titify.ajgarcia.model.Cancion;
import titify.ajgarcia.model.Disco;
import titify.ajgarcia.model.ListaReproduccion;
import titify.ajgarcia.model.Usuario;
import titify.ajgarcia.utils.ConexionBD;

public class ListaReproduccionDAOImpMariaDB extends ListaReproduccion implements ListaReproduccionDAO{
	//CONSULTAS
	private static final String INSERT="INSERT INTO listareproduccion (id,nombre,descripcion,creador) VALUES (?,?,?,?)";
	private static final String EDITAR="UPDATE listareproduccion SET nombre=?,descripcion=? WHERE id=?";
	private static final String BORRAR="DELETE FROM listareproduccion WHERE id=?";
	private static final String MOSTRARTODOS="SELECT id,nombre,descripcion,creador FROM listareproduccion";
	private static final String MOSTRARTODOSxNOMBRE="SELECT id,nombre,descripcion,creador FROM listareproduccion WHERE nombre LIKE ?";
	private static final String MOSTRARTODOSxID="SELECT id,nombre,descripcion,creador FROM listareproduccion WHERE id=?";
	private static final String MostrarCANCIONES="SELECT c.id,c.nombre,c.duracion,c.genero,c.reproducciones FROM cancion_listareproduccion AS cl, cancion as c, listareproduccion as lr WHERE cl.id_cancion=c.id AND cl.id_lr=lr.id AND lr.id=?";
	private static final String MostrarUSUARIOS="SELECT usuario.id,usuario.nombre,usuario.correo,usuario.pass,usuario.foto FROM usuario_listareproduccion as ul, usuario, listareproduccion as lp WHERE ul.id_usuario=usuario.id AND ul.id_lr=lp.id AND lp.id=?";
	private static final String AddCancionPlayList="INSERT INTO cancion_listareproduccion (id_cancion, id_lr) VALUES (?,?)";
	
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	List<Cancion>canciones;
	
	public ListaReproduccionDAOImpMariaDB() {
		
	}
	
	public ListaReproduccionDAOImpMariaDB(int id, String nombre,String descripcion,Usuario creador) {
		super(id,nombre,descripcion,creador);
	}
	
	
	public ListaReproduccionDAOImpMariaDB(int id) {
		super(id);
	}
	
	@Override
	public void add(ListaReproduccion a) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(INSERT,ps.RETURN_GENERATED_KEYS);
				ps.setInt(1, a.getId());
				ps.setString(2,a.getNombre());
				ps.setString(3,a.getDescripcion());
				ps.setObject(4, a.getCreador().getId());
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
	public void editar(ListaReproduccion a) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(EDITAR);
				ps.setString(1,a.getNombre());
				ps.setString(2,a.getDescripcion());
				ps.setInt(3, a.getId());
				ps.executeUpdate();
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
	public void borrar(ListaReproduccion a) {
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(BORRAR);
				ps.setInt(1, this.id);
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

	@Override
	public List<ListaReproduccion> mostrarTodos() {
		List<ListaReproduccion> resultado=new ArrayList<ListaReproduccion>();
		con=ConexionBD.getConexion();
		
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOS);
				rs=ps.executeQuery();
				while(rs.next()) {
					UsuarioDAOImpMariaDB dd=new UsuarioDAOImpMariaDB();
					Usuario d=dd.mostrar(rs.getInt("id"));
					resultado.add(new ListaReproduccionDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("descripcion"),
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
		return resultado;
		
	}


	@Override
	public ListaReproduccion mostrar(int id) {
		ListaReproduccion resultado=new ListaReproduccionDAOImpMariaDB();
		con=ConexionBD.getConexion();
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOSxID);
				ps.setInt(1, id);
				rs=ps.executeQuery();
				while(rs.next()) {
					UsuarioDAOImpMariaDB dd=new UsuarioDAOImpMariaDB();
					Usuario d=dd.mostrar(rs.getInt("id"));
					resultado=new ListaReproduccionDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("descripcion"),
							d);
					
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
	public List<ListaReproduccion> buscarPorNombre(String nombre) {
		List<ListaReproduccion> resultado=new ArrayList<ListaReproduccion>();
		con=ConexionBD.getConexion();
		
		if(con!=null) {
			try {
				ps=con.prepareStatement(MOSTRARTODOSxNOMBRE);
				ps.setString(1, nombre);
				rs=ps.executeQuery();
				while(rs.next()) {
					UsuarioDAOImpMariaDB dd=new UsuarioDAOImpMariaDB();
					Usuario d=dd.mostrar(rs.getInt("id"));
					resultado.add(new ListaReproduccionDAOImpMariaDB(rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("descripcion"),
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
		return resultado;
		
	}

	@Override
    public List<Cancion> mostrarCanciones(int id_playlist) {
        List<Cancion> result=new ArrayList<Cancion>();
        
        con=ConexionBD.getConexion();
        if(con!=null) {
            try {
                ps=con.prepareStatement(MostrarCANCIONES);
                ps.setInt(1, id_playlist);
                System.out.println(id_playlist);
                rs=ps.executeQuery();
                
                while(rs.next()) {
                    CancionDAOImpMariaDB c=new CancionDAOImpMariaDB();
                    DiscoDAOImpMariaDB dd=new DiscoDAOImpMariaDB();
					dd.mostrar(rs.getInt("id"));
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setDuracion(rs.getInt("duracion"));
                    c.setGenero(rs.getString("genero"));
                    c.setReproducciones(rs.getInt("reproducciones"));
                    c.setDisco(dd.mostrar(rs.getInt("id")));
                    result.add(c);
                    
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

	@Override
	public List<Usuario> mostrarUsuarios(int listaid) {
        List<Usuario> result=new ArrayList<Usuario>();
        
        con=ConexionBD.getConexion();
        if(con!=null) {
            try {
                ps=con.prepareStatement(MostrarUSUARIOS);
                ps.setInt(1, listaid);
                rs=ps.executeQuery();
                
                while(rs.next()) {
                    UsuarioDAOImpMariaDB c=new UsuarioDAOImpMariaDB();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setCorreo(rs.getString("correo"));
                    c.setPass(rs.getString("pass"));
                    c.setFoto(rs.getString("foto"));
                    result.add(c);
                    
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

	public void AddCancionPlayList(int id_cancion,int id_lr) throws SQLException {
		con=ConexionBD.getConexion();
		if(con!=null) {
		try {
			ps=con.prepareStatement(AddCancionPlayList);
			ps.setInt(1, id_cancion);
			ps.setInt(2, id_lr);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			}catch (Exception e) {
				
			}
		}
	}

}

}
