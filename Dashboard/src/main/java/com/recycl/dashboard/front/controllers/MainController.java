package com.recycl.dashboard.front.controllers;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.back.Beans.Dechet;
import com.recycl.dashboard.back.Beans.DemandeEnlevement;
import com.recycl.dashboard.back.Beans.Employe;
import com.recycl.dashboard.back.DAO.*;
import com.recycl.dashboard.front.Models.DemandeEnlevementModel;
import com.recycl.dashboard.front.Models.RequestTwoModel;
import com.recycl.dashboard.front.helpers.AlertHelper;
import com.recycl.dashboard.front.helpers.UIPaneHelper;
import com.recycl.dashboard.front.helpers.CustomUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.recycl.dashboard.front.helpers.CustomUtils.removeDuplicates;

public class MainController {
    @FXML
    public TextField input_int;
    @FXML
    public TextField request2_input;

    @FXML
    public Label Request2_EntrepriseInfo;
    @FXML
    public Label Request2_TourneeInfo;


    @FXML
    public ListView<String> listView;

    private Window owner;
    private ScreenController screenController;

    @FXML
    public TableView<DemandeEnlevementModel> tableRequestOne;
    @FXML
    public TableView<RequestTwoModel> tableRequestTwo;
    @FXML
    public TableView<DemandeEnlevementModel> tableRequestSix;

    @FXML
    private DatePicker datepicker_one;
    @FXML
    private DatePicker datepicker_three;

    @FXML
    private Pane panerequete_one;
    @FXML
    private Pane panerequete_two;
    @FXML
    private Pane panerequete_three;
    @FXML
    private Pane panerequete_four;
    @FXML
    private Pane panerequete_six;
    @FXML
    private Pane panerequete_seven;
    @FXML
    private Pane MainRequestMenu;
    @FXML
    private Pane showList;

    public void initialize() {
        System.out.println("Initializing Main Controller JFX");

        UIPaneHelper.init();
        UIPaneHelper.AddPane("panerequete_one", panerequete_one);
        UIPaneHelper.AddPane("panerequete_two", panerequete_two);
        UIPaneHelper.AddPane("panerequete_three", panerequete_three);
        UIPaneHelper.AddPane("panerequete_four", panerequete_four);
        //five
        UIPaneHelper.AddPane("panerequete_six", panerequete_six);
        UIPaneHelper.AddPane("panerequete_seven", panerequete_seven);
        //eight
        //nine
//        UIPaneHelper.AddPane("showList", showList);
        UIPaneHelper.AddPane("MainRequestMenu", MainRequestMenu);
        UIPaneHelper.Show("MainRequestMenu");
    }

    @FXML
    protected void handleHome() {
        UIPaneHelper.Show("MainRequestMenu");
    }

    //Handle the click if the button for the first request.
    @FXML
    protected void handleButtonR1() throws NullPointerException {
        UIPaneHelper.Show(panerequete_one);
        datepicker_one.setValue(LocalDate.now()); //set the date to the current day
    }

    //Handle the validation click of the first request.
    @FXML
    private void get_R1() throws NullPointerException {
        try {
            if (datepicker_one.getValue() == null) { //in case the user doesnt put a date
                AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Information", "Valeur invalide : La date ne peut pas etre vide");
            } else {
                System.out.println("date choisi par le user : " + datepicker_one.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE)); //debug

                // Chercher et afficher les demandes qui ont été faites après une date donnée saisie par l'agent
                System.out.println("-------------------- REQUEST 1 --------------------");
                System.out.println("// Chercher et afficher les demandes qui ont été faites après une date donnée saisie par l'agent");
                System.out.println("-- Paramètres : String sous format (yyyy-MM-dd) => 2019-06-05");

                DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
                ArrayList<DemandeEnlevement> demandes = demandeEnlevementDAO.GetDemandesByDateDemande(datepicker_one.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE));

                if (demandes.isEmpty()) {
                    AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Information", "Il n'y a aucune demande d'enlevement pour cette date");
                } else {
                    tableRequestOne.getItems().clear();

                    for (DemandeEnlevement demande : demandes) {
                        DemandeEnlevementModel demandeEnlevementModel = new DemandeEnlevementModel(demande.getId(), demande.getEntreprise().getRaisonSociale(), (java.sql.Date) demande.getTournee().getDate(), demande.getDateDemande(), demande.getDateEnlevement());
                        tableRequestOne.getItems().add(demandeEnlevementModel);
                    }
                    UIPaneHelper.Show(panerequete_one);
                }
            }
        } catch (Exception ex) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, ex.getMessage(), ex.toString());
        }
    }

    //Handle the click if the button for the second request.
    @FXML
    protected void handleButtonR2() throws NullPointerException {
        UIPaneHelper.Show(panerequete_two);
    }

    //Handle the validation click of the second request.
    @FXML
    private void get_R2() throws NullPointerException {
        try {
            // Pour une demande donnée, afficher la raison sociale de l'entreprise, la tournée correspondante et la quantité à récupérer pour chaque type de déchet
            System.out.println("-------------------- REQUEST 2 --------------------");
            System.out.println("// Pour une demande donnée, afficher la raison sociale de l'entreprise, la tournée correspondante et la quantité à récupérer pour chaque type de déchet");
            System.out.println("-- Paramètres : Numéro de la demande (int)");
            if (request2_input.getCharacters() == null) { //in case the user doesnt put a date
                AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Information", "Valeur invalide : La date ne peut pas etre vide");
            } else{
                DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
                DemandeEnlevement demande = demandeEnlevementDAO.GetById(Integer.parseInt(request2_input.getCharacters().toString()));

                DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());
                Map<String, Integer> listDechets = dechetDAO.GetTypesDechetsByDemande(demande.getId());

                System.out.println("Raison sociale entreprise : " + demande.getEntreprise().getRaisonSociale());
                System.out.println("Tournée du " + demande.getTournee().getDate() + ", par " + demande.getTournee().getEmploye().getNom() + " " +demande.getTournee().getEmploye().getPrenom()+", avec le camion " + demande.getTournee().getCamion().getNumMatricule());

                Request2_EntrepriseInfo.setText("Raison sociale entreprise : " + demande.getEntreprise().getRaisonSociale());
                Request2_TourneeInfo.setText("Tournée du " + demande.getTournee().getDate() + ", par " + demande.getTournee().getEmploye().getNom() + " " +demande.getTournee().getEmploye().getPrenom()+", avec le camion " + demande.getTournee().getCamion().getNumMatricule());
                tableRequestTwo.getItems().clear();
                for (Map.Entry<String, Integer> entry : listDechets.entrySet()) {
                    System.out.println("Type : " + entry.getKey() + ", Value : " + entry.getValue());
                    RequestTwoModel requestTwoModel = new RequestTwoModel(entry.getKey(), entry.getValue());
                    tableRequestTwo.getItems().add(requestTwoModel);
                }

                UIPaneHelper.Show(panerequete_two);
            }


        } catch (Exception ex) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, ex.getMessage(), ex.toString());
        }
    }

    //Handle the click if the button for the third request.
    @FXML
    protected void handleButtonR3() throws NullPointerException {
        UIPaneHelper.Show(panerequete_three);
        datepicker_three.setValue(LocalDate.now());
    }

    //Handle the validation click of the third request.
    @FXML
    private void get_R3() {
        try {
            if (datepicker_three.getValue() == null) { //in case the user doesnt put a date
                AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Information", "Valeur invalide : La date ne peut pas etre vide");
            } else {
                System.out.println("date choisi par le user : " + datepicker_three.getValue().toString()); //debug

                // Afficher la quantité totale récupérée par type de déchet pour un mois/année donné

                System.out.println("-------------------- REQUEST 3 --------------------");
                System.out.println("// Afficher la quantité totale récupérée par type de déchet pour un mois/année donné");
                System.out.println("-- Paramètres : Mois (int) & Année (int)");

                DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
                ArrayList<DemandeEnlevement> demandes = demandeEnlevementDAO.GetDemandesByMonthYear(datepicker_three.getValue().getMonthValue(), datepicker_three.getValue().getYear());

                DetailDemandeDechetDAO detailDemandeDechetDAO = new DetailDemandeDechetDAO(DAOConnection.ConnectDb());
                Map<Integer, Integer> list = detailDemandeDechetDAO.GetDechetsAndQuantity(demandes);

                DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());
                System.out.println("Pour le mois et l'année 09/2018, voici les déchets récupérés :");

                if (list.isEmpty()) {
                    AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Information", "Il n'y a aucune demande d'enlevement pour cette date");
                } else {
                    for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
                        int idDechet = entry.getKey();
                        int quantite = entry.getValue();
                        Dechet dechet = dechetDAO.GetById(idDechet);
                        System.out.println("Pour le déchet : " + dechet.getType() + ", la quantité est de : " + quantite);
                    }
                }
            }
        } catch (Exception ex) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, ex.getMessage(), ex.toString());
        }
    }

    @FXML
    protected void handleButtonR4() throws NullPointerException {
        try {
            UIPaneHelper.Show("panerequete_four");

            // Afficher les employés ayant réalisé moins de n tournées. Triez le résultat sur le nombre de tournées
            System.out.println("-------------------- REQUEST 4 --------------------");
            System.out.println("// Afficher les employés ayant réalisé moins de n tournées. Triez le résultat sur le nombre de tournées");
            System.out.println("-- Paramètres : Nombre de tournées (int)");
        } catch (Exception ex) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, ex.getMessage(), ex.toString());
            ex.printStackTrace();
        }
    }

    @FXML
    private void get_R4() throws SQLException, NullPointerException {
        EmployeDAO employeDAO = new EmployeDAO(DAOConnection.ConnectDb());
        Map<Employe, Integer> listEmployes = employeDAO.GetEmployesWhereNbTourneesSmallerThan(Integer.parseInt(input_int.getText())).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        listView.getItems().clear();
        ObservableList<String> items = listView.getItems();

        for (Map.Entry<Employe, Integer> entry : listEmployes.entrySet()) {
            Employe employe = entry.getKey();
            int nbTournee = entry.getValue();
            items.add("Employe : " + employe.getNom() + " " + employe.getPrenom() + " -> " + nbTournee + " tournée(s)");
        }
        UIPaneHelper.Show("showList");
    }

    @FXML
    protected void handleButtonR5() throws NullPointerException {
        // Afficher les informations de l'entreprise qui a réalisé plus de demandes que l'entreprise Formalys (ou une autre entreprise)
        System.out.println("-------------------- REQUEST 5 --------------------");
        System.out.println("// Afficher les informations de l'entreprise qui a réalisé plus de demandes que l'entreprise Formalys (ou une autre entreprise)");
        System.out.println("-- Paramètres : Entreprise (string)");
    }

    @FXML
    protected void handleButtonR6() throws SQLException, NullPointerException {
        // Afficher les informations des demandes qui ne sont pas encore inscrites dans une tournée
        System.out.println("-------------------- REQUEST 6 --------------------");
        System.out.println("// Afficher les informations des demandes qui ne sont pas encore inscrites dans une tournée");
        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        DemandeATraiterDAO demandeATraiterDAO = new DemandeATraiterDAO(DAOConnection.ConnectDb());
        List<DemandeEnlevement> demandes = Stream.concat(demandeEnlevementDAO.GetDemandesNotInTournee().stream(), demandeATraiterDAO.GetDemandesInJournal().stream()).collect(Collectors.toList());
        ArrayList<DemandeEnlevement> newList = removeDuplicates(demandes);

        tableRequestSix.getItems().clear();
        for (DemandeEnlevement demande : newList) {
            System.out.println("Demande N° : " + demande.getId());
            DemandeEnlevementModel demandeEnlevementModel = new DemandeEnlevementModel(demande.getId(), demande.getEntreprise().getRaisonSociale(), (java.sql.Date) demande.getTournee().getDate(), demande.getDateDemande(), demande.getDateEnlevement());

            tableRequestSix.getItems().add(demandeEnlevementModel);
        }

        UIPaneHelper.Show(panerequete_six);
    }

    @FXML
    protected void handleButtonR7() throws SQLException, NullPointerException {

    }

    private void get_R7() throws SQLException {
        // Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau d'un site (numéro de site, nom du type de déchet, période doivent etre des arguments)
        System.out.println("-------------------- REQUEST 7 --------------------");
        System.out.println("// Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau d'un site (numéro de site, nom du type de déchet, période doivent etre des arguments)");
        System.out.println("-- Paramètres : Type de déchet (string), période avant (String), période après (String), Site (string)");

        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        ArrayList<DemandeEnlevement> listDemandes = demandeEnlevementDAO.GetByDateEnlevement("2019-06-05", "2020-06-03");

        DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());

        ArrayList<Dechet> listDechetsCat = new ArrayList<>();
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
    protected void handleButtonR8() throws  NullPointerException {
        // Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau national
        System.out.println("-------------------- REQUEST 8 --------------------");
        System.out.println("// Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau national");

    }

    @FXML
    protected void handleButtonR9() throws  NullPointerException {
        // Parcours les demandes non inscrites dans une tournée pour chacun des sites et qui les inscrit dans une tournée
        System.out.println("-------------------- REQUEST 9 --------------------");
        System.out.println("// Parcours les demandes non inscrites dans une tournée pour chacun des sites et qui les inscrit dans une tournée");
        // -- Inscription dans une tournée déjà créée pour la date demandée
        // -- A condition qu'il reste une place dans la tournée (sinon inscrire dans une tournée le lendemain ou surlendemain)
        // -- Si aucune possibilité sur les 3 dates -7 inscrire la demande dans un journal de demandes à traiter
    }

}
