package titify.ajgarcia.model;

import java.util.ArrayList;
import java.util.List;

public class Artista {
	protected int id;
	protected String nombre;
	protected String nacionalidad;
	protected String foto;
	protected List<Disco> discos;
	
	public Artista() {
		this.id=-1;
		this.nombre="";
		this.nacionalidad="";
		this.foto="";
		discos=new ArrayList<Disco>();
		
	}

	public Artista(int id,String nombre,String nacionalidad,String foto) {
		this.id=id;
		this.nombre=nombre;
		this.nacionalidad=nacionalidad;
		this.foto=foto;
		discos=new ArrayList<Disco>();
	}
	
	public Artista(String nombre,String nacionalidad,String foto) {
		this.nombre=nombre;
		this.nacionalidad=nacionalidad;
		this.foto=foto;
		discos=new ArrayList<Disco>();
	}
	
	public Artista(String nombre,String nacionalidad,int  id) {
		this.nombre=nombre;
		this.id=id;
		this.nacionalidad=nacionalidad;
	}
	
	public Artista(int id,String nombre,String nacionalidad) {
		this.nombre=nombre;
		this.nacionalidad=nacionalidad;
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public List<Disco> getDiscos() {
		return discos;
	}

	public void setDiscos(List<Disco> discos) {
		this.discos = discos;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", foto=" + foto +"]";
	}
	

	
}
