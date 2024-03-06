package com.example.oferte_vacanta_eu.controller;
import com.example.oferte_vacanta_eu.domain.*;
import com.example.oferte_vacanta_eu.repo.*;
import com.example.oferte_vacanta_eu.service.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;

public class OffController {
    ///BUTOANE SI NEBUNII
    @FXML
    public DatePicker startDate;
    @FXML
    public DatePicker endDate;
    @FXML
    public ListView offList;
    private Service service;
    private hotel hotel;

    ObservableList<String> offModel = FXCollections.observableArrayList();

    public void setService(Service service, hotel hotel) {
        this.service = service;
        this.hotel = hotel;
        //initModel();
    }

    @FXML
    public void initialize() {
        offList.setItems(offModel);
    }

/*
    ///BUTON CAUTARE-- BUTON CAUTARE---- BUTON CAUTARE
    public void handleSearch(ActionEvent event) {
        if (endDate.getValue() == null || startDate.getValue() == null)
            return;
        LocalDate sd = startDate.getValue();
        LocalDate ed = endDate.getValue();
        offModel.clear();
        for (offers off : service.getOffers()) {
            if (off.getStart().compareTo(sd) < 0 && off.getEnd().compareTo(ed) > 0 && this.hotel.getId().equals(off.getHotel())) {
                offModel.add(off.getId() + ":"
                        + off.getPercent() + "% începe la "
                        + off.getStart().toString()
                        + " până la " + off.getEnd().toString());
            }
        }
*/
        public void handleSearch (ActionEvent event){
            if (endDate.getValue() == null || startDate.getValue() == null) {
                return;
            }

            LocalDate sd = startDate.getValue();
            LocalDate ed = endDate.getValue();
            offModel.clear();

            for (offers off : service.getOffers()) {
                LocalDate offerStart = off.getStart();
                LocalDate offerEnd = off.getEnd();

                // Verifică dacă data de început a ofertei este mai mare sau egală cu data de început selectată
                // și dacă data de sfârșit a ofertei este mai mică sau egală cu data de sfârșit selectată
                // și dacă oferta este pentru hotelul curent
                if (offerStart.compareTo(sd) >= 0 && offerEnd.compareTo(ed) <= 0 && this.hotel.getId().equals(off.getHotel())) {
                    offModel.add(off.getId() + ": " + off.getPercent() + "% începe la "
                            + offerStart.toString() + " până la " + offerEnd.toString());
                }
            }
        }


    }
