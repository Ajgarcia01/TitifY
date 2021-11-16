package titify.ajgarcia.model;

import java.util.ArrayList;
import java.util.List;
/*
 * @author Jgl_11
 */
public class Usuario {
	protected int id;
	protected String nombre;
	protected String pass;
	protected String correo;
	protected String foto;
	protected List<Cancion> canciones;
	protected List<ListaReproduccion>listas;
	private static Usuario singletoon;
	ListaReproduccion listaReproduccion;
	
	public static Usuario get_Instance() {
		if(singletoon==null) {
			singletoon=new Usuario();	
		}	
		return singletoon;
	}
	
	public Usuario() {
		this.id=-1;
		this.nombre="";
		this.correo="";
		this.foto="";
		canciones=new ArrayList<Cancion>();
		listas=new ArrayList<ListaReproduccion>();
	}
	
	public Usuario(int id,String nombre,String pass,String correo,String foto) {
		this.id=id;
		this.nombre=nombre;
		this.pass=pass;
		this.correo=correo;
		this.foto=foto;
		canciones=new ArrayList<Cancion>();
		listas=new ArrayList<ListaReproduccion>();
	}
	
	public Usuario(String nombre,String pass,String correo,String foto) {
		this.nombre=nombre;
		this.pass=pass;
		this.correo=correo;
		this.foto=foto;
		
	}
	
	public Usuario(String nombre,String correo,String foto) {
		this.nombre=nombre;
		this.correo=correo;
		this.foto=foto;
		canciones=new ArrayList<Cancion>();
		listas=new ArrayList<ListaReproduccion>();
	}
	
	public Usuario(int id, int id2) {
		this.id=id;
		id2=listaReproduccion.getId();
	}
	
	public Usuario(String nombre,String pass,String correo,int id) {
		this.nombre=nombre;
		this.pass=pass;
		this.correo=correo;
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setNacionalidad(String correo) {
		this.correo = correo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

	public List<ListaReproduccion> getListas() {
		return listas;
	}

	public void setListas(List<ListaReproduccion> listas) {
		this.listas = listas;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + "******" + ", correo=" + correo + ", foto=" + foto;
	}

	
}
