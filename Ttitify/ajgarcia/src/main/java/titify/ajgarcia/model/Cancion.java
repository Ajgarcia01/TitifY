package titify.ajgarcia.model;
/*
 * @author Jgl_11
 */

public class Cancion {
	protected int id;
	protected String nombre;
	protected int duracion;
	protected String genero;
	protected int reproducciones;
	protected Disco disco;
	
	

	public Cancion() {
		this.id=-1;
		this.nombre="";
		this.duracion=-1;
		this.genero="";
		this.disco=null;
		this.reproducciones=-1;
	}
	
	public Cancion(int id,String nombre, int duracion, String genero, int reproducciones,Disco d) {
		this.id=id;
		this.nombre=nombre;
		this.duracion=duracion;
		this.genero=genero;
		this.disco=d;
		this.reproducciones=reproducciones;
	}
	
	public Cancion(String nombre, int duracion, String genero, int reproducciones, Disco d) {
		this.nombre=nombre;
		this.duracion=duracion;
		this.genero=genero;
		this.disco=d;
		this.reproducciones=reproducciones;
		this.disco=d;
	}
	
	public Cancion(int id,String nombre, int duracion, String genero, int reproducciones) {
		this.id=id;
		this.nombre=nombre;
		this.duracion=duracion;
		this.genero=genero;
		this.reproducciones=reproducciones;
	}
	
	public Cancion(String nombre,int reproducciones,int id) {
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

	public int getDuracion() {
		return duracion;
	}

	public void setFechapublicacion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setFoto(String genero) {
		this.genero = genero;
	}

	public int getReproducciones() {
		return reproducciones;
	}

	public void setReproducciones(int reproducciones) {
		this.reproducciones = reproducciones;
	}
	

	public Disco getDisco() {
		return disco;
	}

	public void setDisco(Disco disco) {
		this.disco = disco;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Cancion [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", genero=" + genero
				+ ", reproducciones=" + reproducciones + ", disco=" + disco.getNombre() + "]";
	}
	
	




}
