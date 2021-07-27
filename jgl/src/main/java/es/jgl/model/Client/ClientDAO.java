package es.jgl.model.Client;

import java.util.Date;

public class ClientDAO extends Client {
	protected int dni;
	protected String name;
	protected String surname;
	protected int age;
	protected Date born;
	
	//CONSULTAS
	private final static String SEARCHNAME="";
	
	
	
	//CONSTRUCTORES
	public ClientDAO(){
		super();
	}
	
	
	public ClientDAO(int dni, String name, String surname,int age, Date born){
		super(dni,name,surname,age,born);
	}
	
	public ClientDAO(int dni){
		super(dni);
	}
	
	public ClientDAO(String name,String surname){
		super(name,surname);
	}
	

	
	
	//METODOS PARA HACER X FUNCION
	
	
	
}
