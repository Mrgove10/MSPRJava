package com.recycl.dashboard.front.controllers;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.back.Beans.Dechet;
import com.recycl.dashboard.back.Beans.DemandeEnlevement;
import com.recycl.dashboard.back.Beans.Employe;
import com.recycl.dashboard.back.DAO.DechetDAO;
import com.recycl.dashboard.back.DAO.DemandeEnlevementDAO;
import com.recycl.dashboard.back.DAO.EmployeDAO;
import com.recycl.dashboard.front.helpers.AlertHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class MainController {

    @FXML
    public TextField input_int;

    @FXML
    public Button validateButton;


    private Window owner;
    private ScreenController screenController;

    @FXML
    private Pane secondtest;
    @FXML
    private Pane buttonPane;
    @FXML
    private Pane testPane;

    public void initialize() {
        System.out.println("coucouille");
        owner = buttonPane.getScene().getWindow();
        //    Scene scene = buttonPane.getScene();
        //   screenController = new ScreenController(scene);
        // screenController.addScreen("testPane", testPane);
        //screenController.addScreen("buttonPane", buttonPane);
        secondtest.setVisible(false);
        testPane.setVisible(false);
        buttonPane.setVisible(true);
    }

    @FXML
    protected void handleButtonR1(ActionEvent actionEvent) throws SQLException, NullPointerException {
        try {
            buttonPane.setVisible(false);
            testPane.setVisible(true);

            // Chercher et afficher les demandes qui ont été faites après une date donnée saisie par l'agent
            System.out.println("-------------------- REQUEST 1 --------------------");
            System.out.println("// Chercher et afficher les demandes qui ont été faites après une date donnée saisie par l'agent");
            System.out.println("-- Paramètres : String sous format (yyyy-MM-dd) => 2019-06-05");

            DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
            ArrayList<DemandeEnlevement> demandes = demandeEnlevementDAO.GetDemandesByDateDemande("2019-06-05");
            if (demandes.isEmpty()) {
                AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "list vide", "Il n'y a aucune demande d'enlevement pour cette date");
            } else {
                for (DemandeEnlevement demande : demandes) {
                    System.out.println("Demande N° : " + demande.getNumero());
                }
            }
        } catch (Exception ex) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, ex.getMessage(), ex.toString());
        }
    }

    @FXML
    protected void handleButtonR2(ActionEvent actionEvent) throws SQLException, NullPointerException {
        try {
            // Pour une demande donnée, afficher la raison sociale de l'entreprise, la tournée correspondante et la quantité à récupérer pour chaque type de déchet
            System.out.println("-------------------- REQUEST 2 --------------------");
            System.out.println("// Pour une demande donnée, afficher la raison sociale de l'entreprise, la tournée correspondante et la quantité à récupérer pour chaque type de déchet");
            System.out.println("-- Paramètres : Numéro de la demande (int)");

            DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
            DemandeEnlevement demande = demandeEnlevementDAO.GetByNumero(0);

            DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());
            Map<String, Integer> listDechets = dechetDAO.GetTypesDechetsByDemande(demande.getId());

            System.out.println("Raison sociale entreprise : " + demande.getEntreprise().getRaisonSociale());
            System.out.println("Tournée du " + demande.getTournee().getDate() + ", par " + demande.getTournee().getEmploye() + ", avec le camion " + demande.getTournee().getCamion().getNumMatricule());

            for (Map.Entry<String, Integer> entry : listDechets.entrySet()) {
                System.out.println("Type : " + entry.getKey() + ", Value : " + entry.getValue());
            }
        } catch (Exception ex) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, ex.getMessage(), ex.toString());
        }
    }

    @FXML
    protected void handleButtonR3(ActionEvent actionEvent) throws SQLException, NullPointerException {
        // Afficher la quantité totale récupérée par type de déchet pour un mois/année donné
        System.out.println("-------------------- REQUEST 3 --------------------");
        System.out.println("// Afficher la quantité totale récupérée par type de déchet pour un mois/année donné");
        System.out.println("-- Paramètres : Mois (int) & Année (int)");
    }

    @FXML
    protected void handleButtonR4(ActionEvent actionEvent) throws SQLException, NullPointerException {
        try {
            secondtest.setVisible(true);
            testPane.setVisible(false);
            buttonPane.setVisible(false);
            // Afficher les employés ayant réalisé moins de n tournées. Triez le résultat sur le nombre de tournées
            System.out.println("-------------------- REQUEST 4 --------------------");
            System.out.println("// Afficher les employés ayant réalisé moins de n tournées. Triez le résultat sur le nombre de tournées");
            System.out.println("-- Paramètres : Nombre de tournées (int)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void get_R4(ActionEvent actionEvent) throws SQLException, NullPointerException, IOException {
        EmployeDAO employeDAO = new EmployeDAO(DAOConnection.ConnectDb());

        Map<Employe, Integer> listEmployes = employeDAO.GetEmployesWhereNbTourneesSmallerThan(Integer.parseInt(input_int.getText()));
        for (Map.Entry<Employe, Integer> entry : listEmployes.entrySet()) {
            Employe employe = entry.getKey();
            int nbTournee = entry.getValue();
            System.out.println("Employe : " + employe.getNom() + " " + employe.getPrenom() + " = " + nbTournee + " tournée(s)");
        }
    }

    @FXML
    protected void handleButtonR5(ActionEvent actionEvent) throws SQLException, NullPointerException {
        // Afficher les informations de l'entreprise qui a réalisé plus de demandes que l'entreprise Formalys (ou une autre entreprise)
        System.out.println("-------------------- REQUEST 5 --------------------");
        System.out.println("// Afficher les informations de l'entreprise qui a réalisé plus de demandes que l'entreprise Formalys (ou une autre entreprise)");
        System.out.println("-- Paramètres : Entreprise (string)");
    }

    @FXML
    protected void handleButtonR6(ActionEvent actionEvent) throws SQLException, NullPointerException {
        // Afficher les informations des demandes qui ne sont pas encore inscrites dans une tournée
        System.out.println("-------------------- REQUEST 6 --------------------");
        System.out.println("// Afficher les informations des demandes qui ne sont pas encore inscrites dans une tournée");
    }

    @FXML
    protected void handleButtonR7(ActionEvent actionEvent) throws SQLException, NullPointerException {
        // Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau d'un site (numéro de site, nom du type de déchet, période doivent etre des arguments)
        System.out.println("-------------------- REQUEST 7 --------------------");
        System.out.println("// Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau d'un site (numéro de site, nom du type de déchet, période doivent etre des arguments)");
        System.out.println("-- Paramètres : Type de déchet (string), période avant (String), période après (String), Site (string)");

        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        ArrayList<DemandeEnlevement> listDemandes = demandeEnlevementDAO.GetByDateEnlevement("2019-06-05", "2020-06-03");

        DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());

        ArrayList<Dechet> listDechetsCat = new ArrayList<Dechet>();
        for (DemandeEnlevement entry : listDemandes) {
            if (entry.getTournee().getCamion().getSite().getNom().equals("Paris")) {
                for (Dechet dechet : dechetDAO.GetDechetsByDemande(entry.getId())) {
                    if (dechet.getType().equals("Plastique")) {
                        listDechetsCat.add(dechet);
                    }
                }
            }
        }

        System.out.println("Pour la période de \"2019-06-05\" à \"2020-06-03\", du site \"Paris\", il y a \"" + listDechetsCat.size() + "\" déchets de type \"Plastique\"");

    }

    @FXML
    protected void handleButtonR8(ActionEvent actionEvent) throws SQLException, NullPointerException {
        // Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau national
        System.out.println("-------------------- REQUEST 8 --------------------");
        System.out.println("// Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau national");

    }

    @FXML
    protected void handleButtonR9(ActionEvent actionEvent) throws SQLException, NullPointerException {
        // Parcours les demandes non inscrites dans une tournée pour chacun des sites et qui les inscrit dans une tournée
        System.out.println("-------------------- REQUEST 9 --------------------");
        System.out.println("// Parcours les demandes non inscrites dans une tournée pour chacun des sites et qui les inscrit dans une tournée");
        // -- Inscription dans une tournée déjà créée pour la date demandée
        // -- A condition qu'il reste une place dans la tournée (sinon inscrire dans une tournée le lendemain ou surlendemain)
        // -- Si aucune possibilité sur les 3 dates -7 inscrire la demande dans un journal de demandes à traiter
    }


}
