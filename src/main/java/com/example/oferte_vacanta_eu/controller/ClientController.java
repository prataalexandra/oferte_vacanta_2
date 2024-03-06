package com.example.oferte_vacanta_eu.controller;
import com.example.oferte_vacanta_eu.domain.*;
import com.example.oferte_vacanta_eu.repo.*;
import com.example.oferte_vacanta_eu.service.*;
import com.example.oferte_vacanta_eu.controller.MessageAllert;
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

public class ClientController {
    ///BUTOANE SI NEBUNII
    @FXML
    public TableView<offers> tableView;
    @FXML
    private TableColumn<offers, String> hotelColoana;
    @FXML
    public TableColumn<offers, String> locatieColoana;
    @FXML
    public TableColumn<offers, LocalDate> startdateColoana;
    @FXML
    public TableColumn<offers,LocalDate> enddateColoana;

    @FXML
    public TableView<hotel> hotelTable;
    @FXML
    public TableColumn<hotel,String> numeHotelColoana;
    @FXML
    public DatePicker dataPicker;
    @FXML
    public TextField nrNoptiField;


    private Service service;
    private Long idClient;


    ObservableList<offers> model= FXCollections.observableArrayList();
    ObservableList<hotel> modelHotel= FXCollections.observableArrayList();

    public void setService(Service service,Long idClient) {
        this.service = service;
        this.idClient=idClient;
        initModel();
    }

    @FXML
    public void initialize() {
        tableView.setItems(model);

        startdateColoana.setCellValueFactory(new PropertyValueFactory<offers, LocalDate>("start"));
        enddateColoana.setCellValueFactory(new PropertyValueFactory<offers, LocalDate>("end"));

        hotelColoana.setCellValueFactory(c -> {
            offers off=c.getValue();
            for(hotel h: service.getHotels())
            {
                if(off.getHotel().equals(h.getId()))
                    return new ReadOnlyObjectWrapper<String>(h.getName());
            }
            return null;
        });

        locatieColoana.setCellValueFactory(c -> {
            offers off=c.getValue();
            for(hotel h: service.getHotels())
            {
                if(off.getHotel().equals(h.getId())){
                    Double idLocatie=h.getLid();
                    for(location l: service.getLocations())
                        if(l.getId().equals(idLocatie))
                            return new ReadOnlyObjectWrapper<String>(l.getName());
                }
            }
            return null;
        });

        tableView.setItems(model);


        hotelTable.setItems(modelHotel);
        numeHotelColoana.setCellValueFactory(new PropertyValueFactory<hotel, String>("name"));
    }

    private void initModel() {
        for(offers off : this.service.getOffersAvailable(idClient)){
            model.add(off);
        }

        for(hotel h : this.service.getHotels()){
            modelHotel.add(h);
        }
    }

    public void handleRezerva(ActionEvent event){
        if(hotelTable.getSelectionModel().getSelectedItem() == null)
            return;
        hotel hotel = hotelTable.getSelectionModel().getSelectedItem();

        LocalDate start = dataPicker.getValue();
        Integer noNights = Integer.parseInt(nrNoptiField.getText());
        Double idHotel=hotel.getId();

        service.adaugaRezervare(idClient,idHotel,start,noNights);
    }
}
