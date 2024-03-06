module com.example.oferte_vacanta_eu {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.oferte_vacanta_eu to javafx.fxml;
    exports com.example.oferte_vacanta_eu;


    opens com.example.oferte_vacanta_eu.domain to javafx.fxml;
    exports com.example.oferte_vacanta_eu.domain;

    opens com.example.oferte_vacanta_eu.repo to javafx.fxml;
    exports com.example.oferte_vacanta_eu.repo;

    opens com.example.oferte_vacanta_eu.service to javafx.fxml;
    exports com.example.oferte_vacanta_eu.service;

    opens com.example.oferte_vacanta_eu.controller to javafx.fxml;
    exports com.example.oferte_vacanta_eu.controller;
}