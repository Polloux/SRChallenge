module com.example.srchallenge {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    opens com.example.srchallenge.api;
    opens com.example.srchallenge.model;
    exports com.example.srchallenge;
    exports com.example.srchallenge.controller;
    opens com.example.srchallenge.controller to javafx.fxml;
    opens com.example.srchallenge;
    opens com.example.srchallenge.model.alternative;
}