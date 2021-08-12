package es.jgl.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import es.jgl.utils.ConexBD;

public class ClientDAO extends Client {
	protected int dni;
	protected static String name;
	protected static String surname;
	protected Date born;
	
	//CONSULTAS
	private final static String SEARCHNAME="";
	
	
	
	//CONSTRUCTORES
	public ClientDAO(){
		super();
	}
	
	
	public ClientDAO(int dni, String name, String surname, Date born){
		super(dni,name,surname,born);
	}
	
	public ClientDAO(int dni){
		super(dni);
	}
	
	public ClientDAO(String name,String surname){
		super(name,surname);
	}
	

	
	
	//METODOS PARA HACER X FUNCION
	
	public static boolean searchXname(String name,String surname) {
		boolean valid=false;
				
		Connection conex= ConexBD.getConexion();
		
		if(conex!=null) {
			try {
				PreparedStatement q=conex.prepareStatement(SEARCHNAME);
				q.setString(0, name);
				q.setString(1, surname);
				ResultSet rs= q.executeQuery();
				
				if(rs.next()) {
					valid=true;
				}else
					valid=false;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return !valid;
	}
	
	public static boolean searchXDNI(int dni) {
		boolean valid=false;
		return !valid;
	}
	
	public static boolean searcXall(String name,String surname,int dni) {
		boolean valid=false;
		return !valid;
	}
	
}
