module es.jgl {
	 requires javafx.controls;
	    requires javafx.fxml;
		requires java.sql;
		requires java.base;
		requires javafx.graphics;
		requires jaxb.api;
		requires com.jfoenix;
		requires java.xml;
		requires javafx.base;
		requires java.desktop;

    opens es.jgl to javafx.fxml,javafx.base,com.jfoenix;
    exports es.jgl;
}
