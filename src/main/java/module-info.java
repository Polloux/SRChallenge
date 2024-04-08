module com.example.srchallenge {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.srchallenge to javafx.fxml;
    exports com.example.srchallenge;
    exports com.example.srchallenge.controller;
    opens com.example.srchallenge.controller to javafx.fxml;
}