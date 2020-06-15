package com.recycl.dashboard.back;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.back.Beans.*;
import com.recycl.dashboard.back.DAO.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MainBDD {
    public void startBDD() throws SQLException, ParseException {
        System.out.println("Starting BDD");

        Request1();
        Request2();
        Request3();
        Request4();
        Request5();
        Request6();
        Request7();
        Request8();
        Request9();


        // Lors de l'enregistrement d'un dépot de déchets dans un centre de traitement,
        // une vérification devra être faite pour garantir que la quantité totale déposée pour un type de déchet
        // ne soit pas supérieure à la quantité totale collectée dans la tournée.

    }

    private void Request1() throws SQLException, NullPointerException {
        // Chercher et afficher les demandes qui ont été faites après une date donnée saisie par l'agent
        System.out.println("-------------------- REQUEST 1 --------------------");
        System.out.println("// Chercher et afficher les demandes qui ont été faites après une date donnée saisie par l'agent");
        System.out.println("-- Paramètres : String sous format (yyyy-MM-dd) => 2017-06-05");

        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        ArrayList<DemandeEnlevement> demandes = demandeEnlevementDAO.GetDemandesByDateDemande("2017-06-05");
        for (DemandeEnlevement demande : demandes) {
            System.out.println("Demande N° : " + demande.getNumero());
        }
    }

    private void Request2() throws SQLException, NullPointerException {
        try {
            // Pour une demande donnée, afficher la raison sociale de l'entreprise, la tournée correspondante et la quantité à récupérer pour chaque type de déchet
            System.out.println("-------------------- REQUEST 2 --------------------");
            System.out.println("// Pour une demande donnée, afficher la raison sociale de l'entreprise, la tournée correspondante et la quantité à récupérer pour chaque type de déchet");
            System.out.println("-- Paramètres : Numéro de la demande (int)");

            DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
            DemandeEnlevement demande = demandeEnlevementDAO.GetByNumero(new Long("12345678900001"));

            DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());
            Map<String, Integer> listDechets = dechetDAO.GetTypesDechetsByDemande(demande.getId());

            System.out.println("Raison sociale entreprise : " + demande.getEntreprise().getRaisonSociale());
            System.out.println("Tournée du " + demande.getTournee().getDate() + ", par " + demande.getTournee().getEmploye() + ", avec le camion " + demande.getTournee().getCamion().getNumMatricule());

            for (Map.Entry<String, Integer> entry : listDechets.entrySet()) {
                System.out.println("Type : " + entry.getKey() + ", Value : " + entry.getValue());
            }
        }catch (NullPointerException exception){

        }

    }

    private void Request3() {
        // Afficher la quantité totale récupérée par type de déchet pour un mois/année donné
        System.out.println("-------------------- REQUEST 3 --------------------");
        System.out.println("// Afficher la quantité totale récupérée par type de déchet pour un mois/année donné");
        System.out.println("-- Paramètres : Mois (int) & Année (int)");
    }

    private void Request4() throws SQLException, NullPointerException {
        // Afficher les employés ayant réalisé moins de n tournées. Triez le résultat sur le nombre de tournées
        System.out.println("-------------------- REQUEST 4 --------------------");
        System.out.println("// Afficher les employés ayant réalisé moins de n tournées. Triez le résultat sur le nombre de tournées");
        System.out.println("-- Paramètres : Nombre de tournées (int)");

        EmployeDAO employeDAO = new EmployeDAO(DAOConnection.ConnectDb());
        Map<Employe, Integer> listEmployes = employeDAO.GetEmployesWhereNbTourneesSmallerThan(10).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));;
        for (Map.Entry<Employe, Integer> entry : listEmployes.entrySet()) {
            Employe employe = entry.getKey();
            int nbTournee = entry.getValue();
            System.out.println("Employe : " + employe.getNom() + " " + employe.getPrenom() + " = " + nbTournee + " tournée(s)");
        }
    }

    private void Request5() throws SQLException, NullPointerException {
        // Afficher les informations de l'entreprise qui a réalisé plus de demandes que l'entreprise Formalys (ou une autre entreprise)
        System.out.println("-------------------- REQUEST 5 --------------------");
        System.out.println("// Afficher les informations de l'entreprise qui a réalisé plus de demandes que l'entreprise Formalys (ou une autre entreprise)");
        System.out.println("-- Paramètres : Entreprise (string)");
        // get entreprise
        EntrepriseDAO entrepriseDAO = new EntrepriseDAO(DAOConnection.ConnectDb());
        Entreprise entreprise = entrepriseDAO.GetById(1);
        // get nombre de demande de cette entreprise
        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        Integer numberDemande = demandeEnlevementDAO.GetNumberEnlevement(entreprise);

        System.out.println("Vous avez choisi l'entreprise : "+entreprise.getRaisonSociale()+" qui a réalisé "+numberDemande+" demande(s)");

        System.out.println("Voici les entreprises qui ont réalisé plus de demandes :");
        // get entreprises where nombre demande > Formalys
        Map<Integer, Integer> map = demandeEnlevementDAO.GetNumberEnlevementGreaterThan(numberDemande).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Entreprise tempEntreprise = entrepriseDAO.GetById(entry.getKey());
            System.out.println("L'entreprise : "+tempEntreprise.getRaisonSociale()+" a réalisé "+entry.getValue()+" demande(s)");
        }

    }

    private void Request6() {
        // Afficher les informations des demandes qui ne sont pas encore inscrites dans une tournée
        System.out.println("-------------------- REQUEST 6 --------------------");
        System.out.println("// Afficher les informations des demandes qui ne sont pas encore inscrites dans une tournée");

    }

    private void Request7() throws SQLException, NullPointerException {
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

    private void Request8() {
        // Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau national
        System.out.println("-------------------- REQUEST 8 --------------------");
        System.out.println("// Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau national");

    }

    private void Request9() {
        // Parcours les demandes non inscrites dans une tournée pour chacun des sites et qui les inscrit dans une tournée
        System.out.println("-------------------- REQUEST 9 --------------------");
        System.out.println("// Parcours les demandes non inscrites dans une tournée pour chacun des sites et qui les inscrit dans une tournée");
        // -- Inscription dans une tournée déjà créée pour la date demandée
        // -- A condition qu'il reste une place dans la tournée (sinon inscrire dans une tournée le lendemain ou surlendemain)
        // -- Si aucune possibilité sur les 3 dates -7 inscrire la demande dans un journal de demandes à traiter

    }


    private void UserMethods() {

//        UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
//        User user = new User();
//        user.setId(2);
//        user.setUsername("User");
//        user.setPassword("54321");
//        userDAO.Create(user);

//        var check = userDAO.IsUserExistsByUsernameAndPassword("Test", "12345");
//        System.out.println("Is exists : "+check);

//        ArrayList<User> listUsers = userDAO.GetAllUsers();
//        for (User user:listUsers) {
//            System.out.println(user.getUsername());
//        }
    }

    private void AdresseMethods() throws SQLException {
        AdresseDAO adresseDAO = new AdresseDAO(DAOConnection.ConnectDb());
        Adresse address = adresseDAO.GetById(1);
        System.out.println("---------- ADRESSE ----------");
        System.out.println(address.getId());
        System.out.println(address.getNumRue());
        System.out.println(address.getRue());
        System.out.println(address.getCodePostal());
        System.out.println(address.getVille());
    }

    private void CentreMethods() throws SQLException {
        CentreDAO centreDAO = new CentreDAO(DAOConnection.ConnectDb());
        Centre centre = centreDAO.GetById(1);
        System.out.println("---------- CENTRE ----------");
        System.out.println(centre.getId());
        System.out.println(centre.getAdresse());
        System.out.println(centre.getNom());
    }

    private void EntrepriseMethods() throws SQLException {
        EntrepriseDAO entrepriseDAO = new EntrepriseDAO(DAOConnection.ConnectDb());
        Entreprise entreprise = entrepriseDAO.GetById(1);
        System.out.println("---------- ENTREPRISE ----------");
        System.out.println(entreprise.getId());
        System.out.println(entreprise.getAdresse());
        System.out.println(entreprise.getRaisonSociale());
        System.out.println(entreprise.getSiret());
        System.out.println(entreprise.getTel());
        System.out.println(entreprise.getNomContact());
    }

    private void SiteMethods() throws SQLException {
        SiteDAO siteDAO = new SiteDAO(DAOConnection.ConnectDb());
        Site site = siteDAO.GetById(1);
        System.out.println("---------- SITE ----------");
        System.out.println(site.getId());
        System.out.println(site.getAdresse());
        System.out.println(site.getNom());
    }

    private void EmployeMethods() throws SQLException {
        EmployeDAO employeDAO = new EmployeDAO(DAOConnection.ConnectDb());
        Employe employe = employeDAO.GetById(1);
        System.out.println("---------- EMPLOYE ----------");
        System.out.println(employe.getId());
        System.out.println(employe.getSite());
        System.out.println(employe.getNom());
        System.out.println(employe.getPrenom());
        System.out.println(employe.getDateNaissance());
        System.out.println(employe.getDateEmbauche());
        System.out.println(employe.getSalaire());
        System.out.println(employe.getFonction());
    }

    private void TourneeMethods() throws SQLException {
        TourneeDAO tourneeDAO = new TourneeDAO(DAOConnection.ConnectDb());
        Tournee tournee = tourneeDAO.GetById(1);
        System.out.println("---------- TOURNEE ----------");
        System.out.println(tournee.getId());
        System.out.println(tournee.getCamion());
        System.out.println(tournee.getEmploye());
        System.out.println(tournee.getDate());
    }

    private void CamionMethods() throws SQLException {
        CamionDAO camionDAO = new CamionDAO(DAOConnection.ConnectDb());
        Camion camion = camionDAO.GetById(1);
        System.out.println("---------- CAMION ----------");
        System.out.println(camion.getId());
        System.out.println(camion.getSite());
        System.out.println(camion.getNumMatricule());
        System.out.println(camion.getDateAchat());
        System.out.println(camion.getModele());
        System.out.println(camion.getMarque());
    }
}
