module titify.ajgarcia {
    requires javafx.controls;
    requires javafx.fxml;

    opens titify.ajgarcia to javafx.fxml;
    exports titify.ajgarcia;
}
