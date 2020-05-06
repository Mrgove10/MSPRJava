package com.recycl.dashboard.back;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.back.Beans.*;
import com.recycl.dashboard.back.DAO.*;
import oracle.net.jdbc.TNSAddress.Address;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

public class MainBDD {
    public void startBDD() throws SQLException, ParseException {
        System.out.println("Starting BDD");

//        AdresseMethods();
//        CentreMethods();
//        EntrepriseMethods();
//        SiteMethods();
//        EmployeMethods();
//        TourneeMethods();
//        CamionMethods();

        // Chercher et afficher les demandes qui ont été faites après une date donnée saisie par l'agent
        System.out.println("---------- REQUEST 1 ----------");
        System.out.println("// Chercher et afficher les demandes qui ont été faites après une date donnée saisie par l'agent");
        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        ArrayList<DemandeEnlevement> demandes = demandeEnlevementDAO.GetDemandesByDateDemande("2019-06-05");
        for (DemandeEnlevement demande:demandes) {
            System.out.println("Demande N° : "+demande.getNumero());
        }

        // Pour une demande donnée, afficher la raison sociale de l'entreprise, la tournée correspondante et la quantité à récupérer pour chaque type de déchet
        System.out.println("---------- REQUEST 2 ----------");

        // Afficher la quantité totale récupérée par type de déchet pour un mois/année donné
        System.out.println("---------- REQUEST 3 ----------");

        // Afficher les employés ayant réalisé moins de n tournées. Triez le résultat sur le nombre de tournées
        System.out.println("---------- REQUEST 4 ----------");
        System.out.println("// Afficher les employés ayant réalisé moins de n tournées. Triez le résultat sur le nombre de tournées");
        EmployeDAO employeDAO = new EmployeDAO(DAOConnection.ConnectDb());
        Dictionary listEmployes = employeDAO.GetEmployesWhereNbTourneesSmallerThan(4);
        for (Enumeration k = listEmployes.keys(); k.hasMoreElements();)
        {
            var employe = (Employe)k.nextElement();
            var nbTournee = listEmployes.get(employe);
            System.out.println("Employe : "+employe.getNom()+" "+employe.getPrenom()+" = "+nbTournee+" tournée(s)");
        }

        // Afficher les informations de l'entreprise qui a réalisé plus de demandes que l'entreprise Formalys (ou une autre entreprise)
        System.out.println("---------- REQUEST 5 ----------");

        // Afficher les informations des demandes qui ne sont pas encore inscrites dans une tournée
        System.out.println("---------- REQUEST 6 ----------");

        // Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau d'un site (numéro de site, nom du type de déchet, période doivent etre des arguments)
        System.out.println("---------- REQUEST 7 ----------");

        // Retourver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau nationale
        System.out.println("---------- REQUEST 8 ----------");

        // Parcours les demandes non inscrites dans une tournée pour chacun des sites et qui les inscrit dans une tournée
        System.out.println("---------- REQUEST 9 ----------");
            // -- Inscription dans une tournée déjà créée pour la date demandée
            // -- A condition qu'il reste une place dans la tournée (sinon inscrire dans une tournée le lendemain ou surlendemain)
            // -- Si aucune possibilité sur les 3 dates -7 inscrire la demande dans un journal de demandes à traiter

        // Lors de l'enregistrement d'un dépot de déchets dans un centre de traitement, une vérification devra être faite pour garantir que la quantité totale déposée pour un type de déchet ne soit pas supérieure à la quantité totale collectée dans la tournée.

    }

    private void UserMethods(){

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
