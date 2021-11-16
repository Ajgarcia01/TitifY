package titify.ajgarcia.pruebas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import titify.ajgarcia.DAOMariaDB.ArtistaDAOImpMariaDB;
import titify.ajgarcia.DAOMariaDB.CancionDAOImpMariaDB;
import titify.ajgarcia.DAOMariaDB.DiscoDAOImpMariaDB;
import titify.ajgarcia.DAOMariaDB.ListaReproduccionDAOImpMariaDB;
import titify.ajgarcia.DAOMariaDB.UsuarioDAOImpMariaDB;
import titify.ajgarcia.model.Artista;
import titify.ajgarcia.model.Cancion;
import titify.ajgarcia.model.Disco;
import titify.ajgarcia.model.ListaReproduccion;
import titify.ajgarcia.model.Usuario;

public class ejecutable {

	public static void main(String[] args) throws ParseException {
		/*
		DiscoDAOImpMariaDB dd1=new DiscoDAOImpMariaDB(1,"One shot","2021-12-31","imagen",1500);
		DiscoDAOImpMariaDB dd2=new DiscoDAOImpMariaDB(2,"One clip","2008-10-31","imagen",5000);
		
		Disco d2=dd1.mostrar(1);
		

		Cancion c=new Cancion(2, "Manolo", 4, "Heavy Metal", 5000,d2);
		CancionDAOImpMariaDB dd=new CancionDAOImpMariaDB();
		dd.borrar(c);
		System.out.println(c);
		System.out.println("Cambiado");
		//UsuarioDAOImpMariaDB dd=new UsuarioDAOImpMariaDB();
		//dd.buscarPorNombre("Jgl_11");
		
		//ArtistaDAOImpMariaDB dd=new ArtistaDAOImpMariaDB();
		//dd.mostrar(1);
		//System.out.println(dd);
		
		
		ListaReproduccionDAOImpMariaDB dd=new ListaReproduccionDAOImpMariaDB();
		List<ListaReproduccion> lista=dd.mostrarTodos();
		for(ListaReproduccion s:lista) {
			System.out.println(s);
		}
		*/
		
		ListaReproduccionDAOImpMariaDB d=new ListaReproduccionDAOImpMariaDB();
		List<Usuario> list=d.mostrarUsuarios(1);
		for(Usuario s:list) {
			System.out.println(s);
		}
		
		
	}

}
