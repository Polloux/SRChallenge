module com.example.srchallenge {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.text;
    requires com.google.gson;

    exports com.example.srchallenge;
    exports com.example.srchallenge.controller;
    exports com.example.srchallenge.api;
    exports com.example.srchallenge.model;
    exports com.example.srchallenge.model.alternative;

    opens com.example.srchallenge.api;
    opens com.example.srchallenge.model;
    opens com.example.srchallenge.controller to javafx.fxml;
    opens com.example.srchallenge;
    opens com.example.srchallenge.model.alternative;
}