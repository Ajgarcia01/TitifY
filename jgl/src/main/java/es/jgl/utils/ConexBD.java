package es.jgl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;







public class ConexBD {
	public ConexBD(){}
	ConexBD(String server,String database,String username,String password){
		
	}
	
	/*
	 * Atributos
	*/

	/*
	 * Conexion con la BBDD
	*/
	private static Connection con;
	
	//url`s que cargan los metodos con el xml`s que contienen los datos de la conexion 
	public static String server= XMLReader.conexionINFO("server");
	public static String database= XMLReader.conexionINFO("database");
	public static String user= XMLReader.conexionINFO("user");
	public static String password= XMLReader.conexionINFO("password");
	
	
	/*
	 * metodo para conectar con la BBDD
	*/
		public static void conectar() {
			try {
	            //Paso 1: establecer la conexion
				Class.forName("com.mysql.cj.jdbc.Driver");

	            con = DriverManager.getConnection(server+"/"+database,user,password);
	            
	            System.out.println("Conectado correctamente a la Base de Datos");
	   
	       
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				
				} catch (SQLException e) {
					con=null;
	            e.printStackTrace();
				}
			}
		
		/*
		 * metodo para conectar en los DAO con la BBDD
		*/
		public static Connection getConexion() {
			if(con==null) {
				conectar();
			}
			
			return con;
		}
		
		
				
	}

