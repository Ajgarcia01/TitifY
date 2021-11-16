package titify.ajgarcia.model;

import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion {
	protected int id;
	protected String nombre;
	protected String descripcion;
	protected Usuario creador;
	protected List<Usuario> suscriptores;
	protected List<Cancion> canciones;
	
	
	public ListaReproduccion() {
		this.id=-1;
		this.nombre="";
		this.descripcion="";
		suscriptores=new ArrayList<Usuario>();
		canciones=new ArrayList<Cancion>();
	}
	
	public ListaReproduccion(int id, String nombre,String descripcion,Usuario creador) {
		this.id=id;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.creador=creador;
		suscriptores=new ArrayList<Usuario>();
		canciones=new ArrayList<Cancion>();
	}
	
	public ListaReproduccion(String nombre,String descripcion,Usuario creador) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.creador=creador;
		suscriptores=new ArrayList<Usuario>();
		canciones=new ArrayList<Cancion>();
	}
	
	
	public ListaReproduccion(int id, String nombre,String descripcion,Usuario creador,List<Cancion>canciones) {
		this.id=id;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.creador=creador;
		suscriptores=new ArrayList<Usuario>();
		canciones=new ArrayList<Cancion>();
	}

	public ListaReproduccion(String nombre,String descripcion,int id) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.id=id;
	}
	
	public ListaReproduccion(int id) {
		this.id=id;
		canciones=new ArrayList<Cancion>();
	}
	
	public ListaReproduccion(Usuario creador) {
		this.creador=creador;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	
	

	public List<Usuario> getSuscriptores() {
		return suscriptores;
	}

	public void setSuscriptores(List<Usuario> suscriptores) {
		this.suscriptores = suscriptores;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	@Override
	public String toString() {
		return "ListaReproduccion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", creador="
				+ creador.getNombre();
	}
	
	
	
}
