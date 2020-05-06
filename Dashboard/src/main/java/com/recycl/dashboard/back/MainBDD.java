package com.recycl.dashboard.back;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.back.Beans.*;
import com.recycl.dashboard.back.DAO.*;
import oracle.net.jdbc.TNSAddress.Address;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainBDD {
    public void startBDD() throws SQLException {
        System.out.println("Starting BDD");

        AdresseMethods();
        CentreMethods();
        EntrepriseMethods();
        SiteMethods();
        EmployeMethods();
        TourneeMethods();
        //CamionMethods();
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
