module titify.ajgarcia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jaxb.api;
    requires javafx.base;
	requires java.base;
	requires javafx.graphics;

    opens titify.ajgarcia to javafx.fxml,javafx.base;
    opens titify.ajgarcia.model to javafx.base;
    exports titify.ajgarcia;
}
