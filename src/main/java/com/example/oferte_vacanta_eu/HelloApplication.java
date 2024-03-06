package com.example.oferte_vacanta_eu;
import com.example.oferte_vacanta_eu.repo.*;
import com.example.oferte_vacanta_eu.service.*;
import com.example.oferte_vacanta_eu.controller.*;
import com.example.oferte_vacanta_eu.domain.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class HelloApplication extends Application {
    ///bun /////
    Service service;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.service = new Service(new repoLocation("jdbc:postgresql://localhost:5432/oferte_vacanta","postgres","-"),
                new repoHotel("jdbc:postgresql://localhost:5432/oferte_vacanta","postgres","-"),
                new repoOff("jdbc:postgresql://localhost:5432/oferte_vacanta","postgres","-"),
                new repoClient("jdbc:postgresql://localhost:5432/oferte_vacanta","postgres","-"),
                new repoRezervare("jdbc:postgresql://localhost:5432/oferte_vacanta","postgres","-")
        )
        ;

        primaryStage.setTitle("START PAGE");
        startView(primaryStage);
        primaryStage.show();


        Parameters param = getParameters();
        List<String> list = param.getRaw();
        System.out.println(list.size());
        for(String clientId : list){
            Long id = Long.parseLong(clientId);
            System.out.println(id);

            //!!!!!
            getUsers(id);
        }
    }

    private void startView(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/views/startView.fxml"));
        AnchorPane Layout = fxmlLoader.load();
        stage.setScene(new Scene(Layout));

        MainController mainController = fxmlLoader.getController();
        mainController.setService(this.service);
    }

    public void getUsers(Long clientId) {
        for (client c : service.getClients()) {
            if (Objects.equals(clientId, c.getId())) {
                try {
                    Stage stageClient = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/views/clientView.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    stageClient.setTitle(c.getName());
                    stageClient.setScene(scene);
                    ClientController clientController = fxmlLoader.getController();
                    clientController.setService(service, clientId);
                    stageClient.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}