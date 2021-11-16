package titify.ajgarcia.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Disco {
	protected int id;
	protected String nombre;
	protected LocalDate fechapublicacion;
	protected String foto;
	protected int reproducciones;
	protected List<Cancion> canciones;
	protected Artista artista;

	public Disco() {
		this.id=-1;
		this.nombre="";
		this.fechapublicacion=null;
		this.foto="";
		this.reproducciones=-1;
		canciones=new ArrayList<Cancion>();
	}
	
	public Disco(int id,String nombre, LocalDate fechapublicacion, String foto, int reproducciones) {
		this.id=id;
		this.nombre=nombre;
		this.fechapublicacion=fechapublicacion;
		this.foto=foto;
		this.reproducciones=reproducciones;
		canciones=new ArrayList<Cancion>();
	}
	
	
	public Disco(int id,String nombre, LocalDate fechapublicacion, String foto, int reproducciones, Artista a) {
		this.id=id;
		this.nombre=nombre;
		this.fechapublicacion=fechapublicacion;
		this.foto=foto;
		this.reproducciones=reproducciones;
		this.artista=a;
		canciones=new ArrayList<Cancion>();
	}
	
	public Disco(String nombre, LocalDate fechapublicacion, String foto, int reproducciones, Artista a) {
		this.nombre=nombre;
		this.fechapublicacion=fechapublicacion;
		this.foto=foto;
		this.reproducciones=reproducciones;
		this.artista=a;
		canciones=new ArrayList<Cancion>();
	}
	
	
	public Disco(String nombre,int reproducciones,int id) {
		this.nombre=nombre;
		this.reproducciones=reproducciones;
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

	public LocalDate getFechapublicacion() {
		return fechapublicacion;
	}

	public void setFechapublicacion(LocalDate fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getReproducciones() {
		return reproducciones;
	}

	public void setReproducciones(int reproducciones) {
		this.reproducciones = reproducciones;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "Disco [id=" + id + ", nombre=" + nombre + ", fechapublicacion=" + fechapublicacion + ", foto=" + foto
				+ ", reproducciones=" + reproducciones +" , "+artista.getNombre();
	}


}

