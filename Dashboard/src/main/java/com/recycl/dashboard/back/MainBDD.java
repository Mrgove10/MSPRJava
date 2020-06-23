package com.recycl.dashboard.back;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.back.Beans.*;
import com.recycl.dashboard.back.DAO.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            System.out.println("Demande N° : " + demande.getId());
        }
    }

    private void Request2() throws SQLException, NullPointerException {
        try {
            // Pour une demande donnée, afficher la raison sociale de l'entreprise, la tournée correspondante et la quantité à récupérer pour chaque type de déchet
            System.out.println("-------------------- REQUEST 2 --------------------");
            System.out.println("// Pour une demande donnée, afficher la raison sociale de l'entreprise, la tournée correspondante et la quantité à récupérer pour chaque type de déchet");
            System.out.println("-- Paramètres : Numéro de la demande (int)");

            DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
            DemandeEnlevement demande = demandeEnlevementDAO.GetById(1);

            ArrayList<DemandeEnlevement> demandes = new ArrayList<>();
            demandes.add(demande);

            DetailDemandeDechetDAO detailDemandeDechetDAO = new DetailDemandeDechetDAO(DAOConnection.ConnectDb());
            Map<Integer, Integer> listDechets = detailDemandeDechetDAO.GetDechetsAndQuantity(demandes);

            System.out.println("Raison sociale entreprise : " + demande.getEntreprise().getRaisonSociale());
            System.out.println("Tournée du " + demande.getTournee().getDate() + ", par " + demande.getTournee().getEmploye().getNom() + " " + demande.getTournee().getEmploye().getPrenom() +", avec le camion " + demande.getTournee().getCamion().getNumMatricule());
            DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());

            System.out.println("Pour cette demande, voici les déchets récupérés :");
            for (Map.Entry<Integer, Integer> entry : listDechets.entrySet()) {
                int idDechet = entry.getKey();
                int quantite = entry.getValue();
                Dechet dechet = dechetDAO.GetById(idDechet);
                System.out.println("Pour le déchet : "+dechet.getType()+", la quantité est de : "+quantite);
            }
        }catch (NullPointerException exception){

        }

    }

    private void Request3() throws SQLException {
        // Afficher la quantité totale récupérée par type de déchet pour un mois/année donné
        System.out.println("-------------------- REQUEST 3 --------------------");
        System.out.println("// Afficher la quantité totale récupérée par type de déchet pour un mois/année donné");
        System.out.println("-- Paramètres : Mois (int) && Année (int)");

        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        ArrayList<DemandeEnlevement> demandes = demandeEnlevementDAO.GetDemandesByMonthYear(9,2018);

        DetailDemandeDechetDAO detailDemandeDechetDAO = new DetailDemandeDechetDAO(DAOConnection.ConnectDb());
        Map<Integer, Integer> list = detailDemandeDechetDAO.GetDechetsAndQuantity(demandes);

        DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());
        System.out.println("Pour le mois et l'année 09/2018, voici les déchets récupérés :");

        for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
            int idDechet = entry.getKey();
            int quantite = entry.getValue();
            Dechet dechet = dechetDAO.GetById(idDechet);
            System.out.println("Pour le déchet : "+dechet.getType()+", la quantité est de : "+quantite);
        }
    }

    private void Request4() throws SQLException, NullPointerException {
        // Afficher les employés ayant réalisé moins de n tournées. Triez le résultat sur le nombre de tournées
        System.out.println("-------------------- REQUEST 4 --------------------");
        System.out.println("// Afficher les employés ayant réalisé moins de n tournées. Triez le résultat sur le nombre de tournées");
        System.out.println("-- Paramètres : Nombre de tournées (int)");

        EmployeDAO employeDAO = new EmployeDAO(DAOConnection.ConnectDb());
        Map<Employe, Integer> listEmployes = employeDAO.GetEmployesWhereNbTourneesSmallerThan(3).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

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

        EntrepriseDAO entrepriseDAO = new EntrepriseDAO(DAOConnection.ConnectDb());
        Entreprise entreprise = entrepriseDAO.GetById(1);

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

    private void Request6() throws SQLException {
        // Afficher les informations des demandes qui ne sont pas encore inscrites dans une tournée
        System.out.println("-------------------- REQUEST 6 --------------------");
        System.out.println("// Afficher les informations des demandes qui ne sont pas encore inscrites dans une tournée");

        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        DemandeATraiterDAO demandeATraiterDAO = new DemandeATraiterDAO(DAOConnection.ConnectDb());
        List<DemandeEnlevement> demandes = Stream.concat(demandeEnlevementDAO.GetDemandesNotInTournee().stream(), demandeATraiterDAO.GetDemandesInJournal().stream()).collect(Collectors.toList());
        ArrayList<DemandeEnlevement> newList = removeDuplicates(demandes);
        for (DemandeEnlevement demande : demandes) {
            System.out.println("Demande N° : " + demande.getId());
        }
    }

    private void Request7() throws SQLException, NullPointerException {
        // Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau d'un site (numéro de site, nom du type de déchet, période doivent etre des arguments)
        System.out.println("-------------------- REQUEST 7 --------------------");
        System.out.println("// Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau d'un site (numéro de site, nom du type de déchet, période doivent etre des arguments)");
        System.out.println("-- Paramètres : Type de déchet (string), période avant (String), période après (String), Site (string)");

        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        ArrayList<DemandeEnlevement> listDemandes = demandeEnlevementDAO.GetByDateEnlevement("2017-06-05", "2019-06-03");

        DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());
        DetailDemandeDechetDAO detailDemandeDechetDAO = new DetailDemandeDechetDAO(DAOConnection.ConnectDb());

        ArrayList<DemandeEnlevement> demandesSite = new ArrayList<>();
        for (DemandeEnlevement entry : listDemandes) {
            if (entry.getTournee().getId() != 0){
                if (entry.getTournee().getCamion().getSite().getNom().equals("Site Paris")){
                    demandesSite.add(entry);
                }
            }

        }

        Map<Integer, Integer> map = detailDemandeDechetDAO.GetDechetsAndQuantity(demandesSite);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Dechet dechet = dechetDAO.GetById(entry.getKey());
            if (dechet.getType().equals("Papier")){
                System.out.println("Pour la période de \"2017-06-05\" à \"2019-06-03\", du site \"Paris\", il y a \"" + entry.getValue() + "\" déchet(s) de type \"Plastique\"");
            }
        }

    }

    private void Request8() throws SQLException {
        // Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau national
        System.out.println("-------------------- REQUEST 8 --------------------");
        System.out.println("// Retrouver et afficher la quantité totale collectée pour un type de déchet sur une période donnée au niveau national");

        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        ArrayList<DemandeEnlevement> listDemandes = demandeEnlevementDAO.GetByDateEnlevement("2017-06-05", "2019-06-03");

        DechetDAO dechetDAO = new DechetDAO(DAOConnection.ConnectDb());
        DetailDemandeDechetDAO detailDemandeDechetDAO = new DetailDemandeDechetDAO(DAOConnection.ConnectDb());

        ArrayList<DemandeEnlevement> demandesSites = new ArrayList<>();
        for (DemandeEnlevement entry : listDemandes) {
            if (entry.getTournee().getId() != 0){
                demandesSites.add(entry);
            }

        }

        Map<Integer, Integer> map = detailDemandeDechetDAO.GetDechetsAndQuantity(demandesSites);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Dechet dechet = dechetDAO.GetById(entry.getKey());
            if (dechet.getType().equals("Papier")){
                System.out.println("Pour la période de \"2017-06-05\" à \"2019-06-03\", il y a \"" + entry.getValue() + "\" déchet(s) de type \"Plastique\"");
            }
        }
    }

    private void Request9() throws SQLException {
        // Parcours les demandes non inscrites dans une tournée pour chacun des sites et qui les inscrit dans une tournée
        System.out.println("-------------------- REQUEST 9 --------------------");
        System.out.println("// Parcours les demandes non inscrites dans une tournée pour chacun des sites et qui les inscrit dans une tournée");
        // -- Inscription dans une tournée déjà créée pour la date demandée (date du jour)
        // -- A condition qu'il reste une place dans la tournée (sinon inscrire dans une tournée le lendemain ou surlendemain)
        // -- Si aucune possibilité sur les 3 dates, inscrire la demande dans un journal de demandes à traiter

        DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
        DemandeATraiterDAO demandeATraiterDAO = new DemandeATraiterDAO(DAOConnection.ConnectDb());
        TourneeDAO tourneeDAO = new TourneeDAO(DAOConnection.ConnectDb());

        List<DemandeEnlevement> demandes = Stream.concat(demandeEnlevementDAO.GetDemandesNotInTournee().stream(), demandeATraiterDAO.GetDemandesInJournal().stream()).collect(Collectors.toList());
        ArrayList<DemandeEnlevement> newList = removeDuplicates(demandes);
        System.out.println("Listes des demandes non inscrites dans une tournée :");
        for (DemandeEnlevement demande : newList) {
            System.out.println("Demande N° : " + demande.getId());
            boolean canBeInsertInTournee = false;

            // get entreprise -> get ville de l'address
            String ville = demande.getEntreprise().getAdresse().getVille();

            // get all tournee aujourdhui
            ArrayList<Tournee> tourneesAvailable = new ArrayList<>();
            for (Tournee tournee:tourneeDAO.GetTodayTournees()) {
                // get camion => get site => get ville adresse
                String tempVille = tournee.getCamion().getSite().getAdresse().getVille();
                // if les 2 sont sur le meme site alors add
                if (ville.equals(tempVille)){
                    tourneesAvailable.add(tournee);
                }
            }

            // pour chaque tournee disponible
            for (Tournee tournee:tourneesAvailable) {
                // get le nombre de place max
                int maxPlaces = tournee.getCamion().getMaxPlaces();

                // get le nombre de demandes pour la tournee
                demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
                int numberEnlevement = demandeEnlevementDAO.GetNumberDemandeForTournee(tournee.getId());

                // si il y a encore de la place dans la tournee
                if(numberEnlevement < maxPlaces){
                    // insert demande for this tournee
                    demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
                    demandeEnlevementDAO.UpdateTournee(tournee.getId(), demande.getId());
                    canBeInsertInTournee = true;
                    break;
                }
            }

            // si la demande n'a pas été inscrite dans une tournée pour aujourd'hui
            if (canBeInsertInTournee == false){
                // récupération des tournees pour demain
                tourneesAvailable = new ArrayList<>();
                tourneeDAO = new TourneeDAO(DAOConnection.ConnectDb());
                for (Tournee tournee:tourneeDAO.GetTomorrowTournees()) {
                    // get camion => get site => get ville adresse
                    String tempVille = tournee.getCamion().getSite().getAdresse().getVille();

                    // if les 2 sont sur le meme site alors add
                    if (ville.equals(tempVille)){
                        tourneesAvailable.add(tournee);
                    }
                }

                // pour chaque tournee disponible
                for (Tournee tournee:tourneesAvailable) {
                    // get le nombre de place max
                    int maxPlaces = tournee.getCamion().getMaxPlaces();

                    // get le nombre de demandes pour la tournee
                    demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
                    int numberEnlevement = demandeEnlevementDAO.GetNumberDemandeForTournee(tournee.getId());

                    // si il y a encore de la place dans la tournee
                    if(numberEnlevement < maxPlaces){
                        // insert demande for this tournee
                        demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
                        demandeEnlevementDAO.UpdateTournee(tournee.getId(), demande.getId());
                        canBeInsertInTournee = true;
                        break;
                    }
                }

                // si la demande n'a pas été inscrite dans une tournée pour demain
                if (canBeInsertInTournee == false){
                    // récupération des tournees pour apres demain
                    tourneesAvailable = new ArrayList<>();
                    tourneeDAO = new TourneeDAO(DAOConnection.ConnectDb());
                    for (Tournee tournee:tourneeDAO.GetDayAfterTomorrowTournees()) {
                        // get camion => get site => get ville adresse
                        String tempVille = tournee.getCamion().getSite().getAdresse().getVille();

                        // if les 2 sont sur le meme site alors add
                        if (ville.equals(tempVille)){
                            tourneesAvailable.add(tournee);
                        }
                    }

                    // pour chaque tournee disponible
                    for (Tournee tournee:tourneesAvailable) {
                        // get le nombre de place max
                        int maxPlaces = tournee.getCamion().getMaxPlaces();

                        // get le nombre de demandes pour la tournee
                        demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
                        int numberEnlevement = demandeEnlevementDAO.GetNumberDemandeForTournee(tournee.getId());

                        // si il y a encore de la place dans la tournee
                        if(numberEnlevement < maxPlaces){
                            // insert demande for this tournee
                            demandeEnlevementDAO = new DemandeEnlevementDAO(DAOConnection.ConnectDb());
                            demandeEnlevementDAO.UpdateTournee(tournee.getId(), demande.getId());
                            canBeInsertInTournee = true;
                            break;
                        }
                    }

                    // si il n'y a pas de places pour les 3 prochains jours
                    if (canBeInsertInTournee == false){
                        // insert dans journal de demandes à traiter
                        demandeATraiterDAO = new DemandeATraiterDAO(DAOConnection.ConnectDb());
                        demandeATraiterDAO.Insert(demande.getId());
                    }
                }

            }

            // si la demande a été attribué à une tournée
            if (canBeInsertInTournee == true){
                // delete du journal
                demandeATraiterDAO = new DemandeATraiterDAO(DAOConnection.ConnectDb());
                demandeATraiterDAO.Delete(demande.getId());
            }

        }
    }

    // Function to remove duplicates from an ArrayList
    public static ArrayList<DemandeEnlevement> removeDuplicates(List<DemandeEnlevement> list)
    {
        ArrayList<DemandeEnlevement> newList = new ArrayList<DemandeEnlevement>();

        for (DemandeEnlevement element : list) {
            boolean isFind = false;
            for (DemandeEnlevement itemToCompare :newList) {
                if (element.getId() == itemToCompare.getId()) {
                    isFind = true;
                    break;
                }
            }

            if (!isFind) {

                newList.add(element);
            }
        }

        return newList;
    }
}
