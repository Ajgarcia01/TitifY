module es.jgl {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.jgl to javafx.fxml;
    exports es.jgl;
}
