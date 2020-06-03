package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.DemandeEnlevement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class DemandeEnlevementDAO {
    protected Connection connect = null;

    public DemandeEnlevementDAO(Connection conn) {
        this.connect = conn;
    }

    public ArrayList<DemandeEnlevement> GetDemandesByDateDemande(String date){
        ArrayList<DemandeEnlevement> listDemandes = new ArrayList<>();

        try {
            String query = "SELECT * " +
                           "FROM MSPR_DEMANDE_ENLEVEMENT " +
                           "WHERE DATE_DEMANDE > DATE '"+date+"'";
            PreparedStatement ps = this.connect.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                DemandeEnlevement demandeEnlevement = new DemandeEnlevement();
                demandeEnlevement.setId(rs.getInt("ID"));
                demandeEnlevement.setNumero(rs.getInt("NO_DEMANDE"));
                demandeEnlevement.setDateDemande(rs.getDate("DATE_DEMANDE"));
                demandeEnlevement.setDateEnlevement(rs.getDate("DATE_ENLEVEMENT"));

                int entreprise = rs.getInt("ID_ENTREPRISE");
                EntrepriseDAO entrepriseDAO = new EntrepriseDAO(connect);
                demandeEnlevement.setEntreprise(entrepriseDAO.GetById(entreprise));

                int tournee = rs.getInt("ID_TOURNEE");
                TourneeDAO tourneeDAO = new TourneeDAO(connect);
                demandeEnlevement.setTournee(tourneeDAO.GetById(tournee));

                listDemandes.add(demandeEnlevement);
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return listDemandes;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }

    public DemandeEnlevement GetById(int id){
        DemandeEnlevement demandeEnlevement = new DemandeEnlevement();
        int idEntreprise = -1;
        int idTournee = -1;

        try {
            String query = "SELECT * " +
                    "FROM Demande_Enlevement " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                demandeEnlevement.setId(rs.getInt("ID"));
                demandeEnlevement.setNumero(rs.getInt("NO"));
                demandeEnlevement.setDateDemande(rs.getDate("DATE_DEMANDE"));
                demandeEnlevement.setDateEnlevement(rs.getDate("DATE_ENLEVEMENT"));
                idEntreprise = rs.getInt("ID_ENTREPRISE");
                idTournee = rs.getInt("ID_TOURNEE");
            }

            EntrepriseDAO entrepriseDAO = new EntrepriseDAO(connect);
            demandeEnlevement.setEntreprise(entrepriseDAO.GetById(idEntreprise));

            TourneeDAO tourneeDAO = new TourneeDAO(connect);
            demandeEnlevement.setTournee(tourneeDAO.GetById(idTournee));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return demandeEnlevement;
            }
        }

        return null;
    }

    public DemandeEnlevement GetByNumero(int numero){
        DemandeEnlevement demandeEnlevement = new DemandeEnlevement();
        int idEntreprise = -1;
        int idTournee = -1;

        try {
            String query = "SELECT * " +
                    "FROM Demande_Enlevement " +
                    "WHERE NO_DEMANDE = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, numero);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                demandeEnlevement.setId(rs.getInt("ID"));
                demandeEnlevement.setNumero(rs.getInt("NO"));
                demandeEnlevement.setDateDemande(rs.getDate("DATE_DEMANDE"));
                demandeEnlevement.setDateEnlevement(rs.getDate("DATE_ENLEVEMENT"));
                idEntreprise = rs.getInt("ID_ENTREPRISE");
                idTournee = rs.getInt("ID_TOURNEE");
            }

            EntrepriseDAO entrepriseDAO = new EntrepriseDAO(connect);
            demandeEnlevement.setEntreprise(entrepriseDAO.GetById(idEntreprise));

            TourneeDAO tourneeDAO = new TourneeDAO(connect);
            demandeEnlevement.setTournee(tourneeDAO.GetById(idTournee));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return demandeEnlevement;
            }
        }

        return null;
    }
}
