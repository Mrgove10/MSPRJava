package com.recycl.dashboard.front.controllers;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.back.Beans.Dechet;
import com.recycl.dashboard.back.Beans.DemandeEnlevement;
import com.recycl.dashboard.back.Beans.Employe;
import com.recycl.dashboard.back.Beans.Entreprise;
import com.recycl.dashboard.back.DAO.*;
import com.recycl.dashboard.front.Models.DemandeEnlevementModel;
import com.recycl.dashboard.front.Models.RequestFiveModel;
import com.recycl.dashboard.front.Models.RequestFourModel;
import com.recycl.dashboard.front.Models.RequestTwoThreeModel;
import com.recycl.dashboard.front.helpers.AlertHelper;
import com.recycl.dashboard.front.helpers.UIPaneHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Window;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.recycl.dashboard.front.helpers.CustomUtils.removeDuplicates;

public class MainController {
    @FXML
    public TextField request2_input;
    @FXML
    public TextField request4_input;

    @FXML
    public Label Request2_EntrepriseInfo;
    @FXML
    public Label Request2_TourneeInfo;

    @FXML
    public ListView<RequestFiveModel> listView_five;

    @FXML
    public ListView<String> listView;
    @FXML
    public TableView<DemandeEnlevementModel> tableRequestOne;
    @FXML
    public TableView<RequestTwoThreeModel> tableRequestTwo;
    @FXML
    public TableView<RequestTwoThreeModel> tableRequestThree;
    @FXML
    public TableView<RequestFourModel> tableRequestFour;
    @FXML
    public TableView<DemandeEnlevementModel> tableRequestSix;
    private Window owner;
    private ScreenController screenController;
    @FXML
    private DatePicker datepicker_one;
    @FXML
    private DatePicker datepicker_three;
    @FXML
    private DatePicker datepicker_seven_start;
    @FXML
    private DatePicker datepicker_seven_end;
    @FXML
    private ChoiceBox<String> choicebox_seven;
    @FXML
    private ChoiceBox<String> choicebox_seven_site;
    @FXML
    private Pane panerequete_one;
    @FXML
    private Pane panerequete_two;
    @FXML
    private Pane panerequete_three;
    @FXML
    private Pane panerequete_four;
    @FXML
    private Pane panerequete_five;
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
        UIPaneHelper.AddPane("panerequete_five", panerequete_five);
        UIPaneHelper.AddPane("panerequete_six", panerequete_six);
        UIPaneHelper.AddPane("panerequete_seven", panerequete_seven);
        //nine

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

    @FXML
    protected void handleButtonR2() throws NullPointerException {
        UIPaneHelper.Show(panerequete_two);
    }

    @FXML
    private void get_R2() throws NullPointerException {
        try {
            // Pour une demande donnée, afficher la raison sociale de l'entreprise, la tournée correspondante et la quantité à récupérer pour chaque type de déchet
            System.out.println("-------------------- REQUEST 2 --------------------");
            System.out.println("// Pour une demande donnée, afficher la raison sociale de l'entreprise, la tournée correspondante et la quantité à récupérer pour chaque type de déchet");
            System.out.println("-- Paramètres : Numéro de la demande (int)");
            if (request2_input.getCharacters() == null) { //in case the user doesnt put a date
                AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Information", "Valeur invalide : La date ne peut pas etre vide");
            } else {
                DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
                DemandeEnlevement demande = demandeEnlevementDAO.GetById(Integer.parseInt(request2_input.getCharacters().toString()));

                ArrayList<DemandeEnlevement> demandes = new ArrayList<>();
                demandes.add(demande);

                DetailDemandeDechetDAO detailDemandeDechetDAO = new DetailDemandeDechetDAO(DAOConnection.ConnectDb());
                Map<Integer, Integer> listDechets = detailDemandeDechetDAO.GetDechetsAndQuantity(demandes);

                System.out.println("Raison sociale entreprise : " + demande.getEntreprise().getRaisonSociale());
                System.out.println("Tournée du " + demande.getTournee().getDate() + ", par " + demande.getTournee().getEmploye().getNom() + " " + demande.getTournee().getEmploye().getPrenom() + ", avec le camion " + demande.getTournee().getCamion().getNumMatricule());
                DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());

                Request2_EntrepriseInfo.setText("Raison sociale entreprise : " + demande.getEntreprise().getRaisonSociale());
                Request2_TourneeInfo.setText("Tournée du " + demande.getTournee().getDate() + ", par " + demande.getTournee().getEmploye().getNom() + " " + demande.getTournee().getEmploye().getPrenom() + ", avec le camion " + demande.getTournee().getCamion().getNumMatricule());
                tableRequestTwo.getItems().clear();
                for (Map.Entry<Integer, Integer> entry : listDechets.entrySet()) {
                    int idDechet = entry.getKey();
                    int quantite = entry.getValue();
                    Dechet dechet = dechetDAO.GetById(idDechet);

                    RequestTwoThreeModel requestTwoThreeModel = new RequestTwoThreeModel(dechet.getType(), quantite);
                    tableRequestTwo.getItems().add(requestTwoThreeModel);
                }

                UIPaneHelper.Show(panerequete_two);
            }


        } catch (Exception ex) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, ex.getMessage(), ex.toString());
        }
    }

    @FXML
    protected void handleButtonR3() throws NullPointerException {
        UIPaneHelper.Show(panerequete_three);
        datepicker_three.setValue(LocalDate.now());
    }

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

                if (list.isEmpty()) {
                    AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Information", "Il n'y a aucune demande d'enlevement pour cette date");
                } else {
                    tableRequestThree.getItems().clear();
                    for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
                        int idDechet = entry.getKey();
                        int quantite = entry.getValue();
                        Dechet dechet = dechetDAO.GetById(idDechet);
                        RequestTwoThreeModel requestTwoThreeModel = new RequestTwoThreeModel(dechet.getType(), quantite);
                        tableRequestThree.getItems().add(requestTwoThreeModel);
                    }

                    UIPaneHelper.Show(panerequete_three);
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
        Map<Employe, Integer> listEmployes = employeDAO.GetEmployesWhereNbTourneesSmallerThan(Integer.parseInt(request4_input.getCharacters().toString())).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        tableRequestFour.getItems().clear();
        for (Map.Entry<Employe, Integer> entry : listEmployes.entrySet()) {
            Employe employe = entry.getKey();
            int nbTournee = entry.getValue();

            RequestFourModel requestFourModel = new RequestFourModel(employe.getNom() + " " + employe.getPrenom(), nbTournee);
            tableRequestFour.getItems().add(requestFourModel);
        }
        UIPaneHelper.Show(panerequete_four);
    }

    @FXML
    protected void handleButtonR5() throws NullPointerException, SQLException {
        EntrepriseDAO entrepriseDAO = new EntrepriseDAO(DAOConnection.ConnectDb());
        ArrayList<Entreprise> arrayList = entrepriseDAO.GetAll();

        for (Entreprise entreprise : arrayList) {

            RequestFiveModel requestFiveModel = new RequestFiveModel(entreprise.getRaisonSociale(), entreprise.getId());

            listView_five.getItems().add(requestFiveModel);
        }

        UIPaneHelper.Show("panerequete_five");
    }

    @FXML
    protected void get_R5() throws NullPointerException, SQLException {
        FocusModel<RequestFiveModel> focused = listView_five.getFocusModel();

        EntrepriseDAO entrepriseDAO = new EntrepriseDAO(DAOConnection.ConnectDb());
        Entreprise entreprise = entrepriseDAO.GetById(focused.getFocusedItem().getId());

        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        Integer numberDemande = demandeEnlevementDAO.GetNumberEnlevement(entreprise);

        System.out.println("Vous avez choisi l'entreprise : "+entreprise.getRaisonSociale()+" qui a réalisé "+numberDemande+" demande(s)");
        System.out.println("Voici les entreprises qui ont réalisé plus de demandes :");

        Map<Integer, Integer> map = demandeEnlevementDAO.GetNumberEnlevementGreaterThan(numberDemande).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Entreprise tempEntreprise = entrepriseDAO.GetById(entry.getKey());
            System.out.println("L'entreprise : "+tempEntreprise.getRaisonSociale()+" a réalisé "+entry.getValue()+" demande(s)");
        }

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
    protected void handleButtonR7() throws NullPointerException, SQLException {
        UIPaneHelper.Show("panerequete_seven");


        DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());
        List<String> listDechet = dechetDAO.GetAllString();
        ObservableList<String> listDechetOSB = FXCollections.observableList(listDechet);
        choicebox_seven.setItems(listDechetOSB);

        SiteDAO siteDAO = new SiteDAO(DAOConnection.ConnectDb());
        List<String> listSite = siteDAO.GetAllString();
        listSite.add("Tous les sites");
        ObservableList<String> listSiteOSB = FXCollections.observableList(listSite);
        choicebox_seven_site.setItems(listSiteOSB);

        datepicker_seven_end.setValue(LocalDate.now());
        datepicker_seven_start.setValue(LocalDate.now());
    }

    @FXML
    private void get_R7() {
        try {
            System.out.println(choicebox_seven.getValue());
            System.out.println(choicebox_seven_site.getValue());
            System.out.println(datepicker_seven_end.getValue());
            System.out.println(datepicker_seven_start.getValue());

            // Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau d'un site (numéro de site, nom du type de déchet, période doivent etre des arguments)
            System.out.println("-------------------- REQUEST 7 --------------------");
            System.out.println("// Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau d'un site (numéro de site, nom du type de déchet, période doivent etre des arguments)");
            System.out.println("-- Paramètres : Type de déchet (string), période avant (String), période après (String), Site (string)");

            DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
            ArrayList<DemandeEnlevement> listDemandes = demandeEnlevementDAO.GetByDateEnlevement(datepicker_seven_start.getValue().toString(), datepicker_seven_end.getValue().toString());

            DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());
            DetailDemandeDechetDAO detailDemandeDechetDAO = new DetailDemandeDechetDAO(DAOConnection.ConnectDb());

            ArrayList<DemandeEnlevement> demandesSite = new ArrayList<>();
            for (DemandeEnlevement entry : listDemandes) {
                if (entry.getTournee().getId() != 0) {
                    if (choicebox_seven_site.getValue().equals("Tous les sites")) {
                        demandesSite.add(entry);
                    } else {
                        if (entry.getTournee().getCamion().getSite().getNom().equals(choicebox_seven_site.getValue())) {
                            demandesSite.add(entry);
                        }
                    }
                }
            }

            Map<Integer, Integer> map = detailDemandeDechetDAO.GetDechetsAndQuantity(demandesSite);

            if (map.isEmpty()) {
                AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Information", "Resultat vide");
            } else {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    Dechet dechet = dechetDAO.GetById(entry.getKey());
                    if (dechet.getType().equals(choicebox_seven.getValue())) {
                        System.out.println("Pour la période de \"2017-06-05\" à \"2019-06-03\", du site \"Paris\", il y a \"" + entry.getValue() + "\" déchet(s) de type \"Plastique\"");
                    }
                }
            }


        } catch (Exception ex) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, ex.getMessage(), ex.toString());
        }
    }

    @FXML
    protected void handleButtonR8() throws NullPointerException, SQLException {
        handleButtonR7();
    }

    @FXML
    protected void handleButtonR9() throws NullPointerException {
        UIPaneHelper.Show("panerequete_nine");
        // Parcours les demandes non inscrites dans une tournée pour chacun des sites et qui les inscrit dans une tournée
        System.out.println("-------------------- REQUEST 9 --------------------");
        System.out.println("// Parcours les demandes non inscrites dans une tournée pour chacun des sites et qui les inscrit dans une tournée");
        // -- Inscription dans une tournée déjà créée pour la date demandée
        // -- A condition qu'il reste une place dans la tournée (sinon inscrire dans une tournée le lendemain ou surlendemain)
        // -- Si aucune possibilité sur les 3 dates -7 inscrire la demande dans un journal de demandes à traiter
    }

}
