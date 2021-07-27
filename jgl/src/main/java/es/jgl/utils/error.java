package es.jgl.utils;

import javafx.scene.control.Alert;


/*
 * Clase para mostrar alertar de error en los controllers
*/
public class error {
		public static void control(String title, String context) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle(title);
			alert.setContentText(context);
			alert.showAndWait();
	}
}
