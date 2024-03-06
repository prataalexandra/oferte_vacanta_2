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
import com.example.oferte_vacanta_eu.HelloApplication;

public class MainController {
    ///INITIALIZARE NEBUNII ALE FERESTREI
    @FXML
    public ComboBox<String> locations;
    @FXML
    public TableView<hotel> hotelTable;
    @FXML
    private TableColumn<hotel, String> numeColoana;
    @FXML
    public TableColumn<hotel, String> typeColoana;
    @FXML
    public TableColumn<hotel, Integer> pretColoana;
    @FXML
    public TableColumn<hotel,Integer> roomsColoana;
    @FXML
    public TableColumn<hotel,Integer> columnX;

    private Service service;

    ObservableList<hotel> hotelList= FXCollections.observableArrayList();
    ObservableList<String> locationsList= FXCollections.observableArrayList();

    public void setService(Service service) {
        this.service = service;
        initModel();
    }

    @FXML
    public void initialize() {
        locations.setItems(locationsList);

        numeColoana.setCellValueFactory(new PropertyValueFactory<hotel, String>("name"));
        typeColoana.setCellValueFactory(new PropertyValueFactory<hotel, String>("type"));
        roomsColoana.setCellValueFactory(new PropertyValueFactory<hotel, Integer>("rooms"));
        pretColoana.setCellValueFactory(new PropertyValueFactory<hotel, Integer>("price"));

        hotelTable.setItems(hotelList);
    }
    private void initModel() {
        for(location location : this.service.getLocations()){
            locationsList.add(location.getName());
        }

        //!! aici nu pun hoteluri ca le pun doar acnd se selecteaza ceva din ComboBox
    }

      ///COMBO COMBO COMBO COMBO COMBO
    public void handleCombo(ActionEvent event) {
        if(locations.getSelectionModel().getSelectedItem() == null)
            return;
        String location = locations.getSelectionModel().getSelectedItem();
        Double lid = service.getLocationId(location);

        hotelList.clear();
        for(hotel hotel: service.getHotels()){
            if(hotel.getLid().intValue() == lid.intValue()){
                hotelList.add(hotel);
            }
        }
    }
      ///BUTON CAUTARE OFERTE - BUTON CAUTARE OFERTE - BUTON CAUTARE OFERTE- BUTON CAUTARE OFERTE
    public void handleOff(ActionEvent event) {
        if(hotelTable.getSelectionModel().getSelectedItem() == null)
            return;
        hotel hotel = (hotel) hotelTable.getSelectionModel().getSelectedItem();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/views/offerView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("OFERTE PAGE");
            OffController offController = fxmlLoader.getController();

            offController.setService(service,hotel);
            stage.show();
            //((Node)(event.getSource())).getScene().getWindow().hide(); //ca sa ascunda prima fereastra
        } catch(Exception e) {
            MessageAllert.showErrorMessage(null, e.getMessage());
        }
    }



}
