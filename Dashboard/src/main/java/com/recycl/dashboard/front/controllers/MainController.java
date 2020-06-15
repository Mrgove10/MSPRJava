package com.recycl.dashboard.front.controllers;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.back.Beans.DemandeEnlevement;
import com.recycl.dashboard.back.DAO.DemandeEnlevementDAO;
import com.recycl.dashboard.front.helpers.AlertHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import org.controlsfx.control.MasterDetailPane;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainController {
    private Window owner;

    private void initialize() {
        MasterDetailPane pane = new MasterDetailPane();
        owner = pane.getScene().getWindow();
    }

    @FXML
    protected void handleButtonR1(ActionEvent actionEvent) throws SQLException {
        try {
            System.out.println("Button 1 clicked");
            DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
            ArrayList<DemandeEnlevement> demandes = demandeEnlevementDAO.GetDemandesByDateDemande("2019-06-05");
            for (DemandeEnlevement demande : demandes) {
                System.out.println("Demande N° : " + demande.getNumero());
            }

        } catch (Exception ex) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your name");
        }
    }

    @FXML
    protected void handleButtonR2(ActionEvent actionEvent) {
        System.out.println("Button 2 clicked");
    }

    @FXML
    protected void handleButtonR3(ActionEvent actionEvent) {
        System.out.println("Button 3 clicked");
    }

    @FXML
    protected void handleButtonR4(ActionEvent actionEvent) {
        System.out.println("Button 4 clicked");
    }

    @FXML
    protected void handleButtonR5(ActionEvent actionEvent) {
        System.out.println("Button 5 clicked");
    }

    @FXML
    protected void handleButtonR6(ActionEvent actionEvent) {
        System.out.println("Button 6 clicked");
    }

    @FXML
    protected void handleButtonR7(ActionEvent actionEvent) {
        System.out.println("Button 7 clicked");
    }

    @FXML
    protected void handleButtonR8(ActionEvent actionEvent) {
        System.out.println("Button 8 clicked");
    }

    @FXML
    protected void handleButtonR9(ActionEvent actionEvent) {
        System.out.println("Button 9 clicked");
    }
}
