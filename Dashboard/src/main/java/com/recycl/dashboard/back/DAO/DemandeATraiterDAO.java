package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.DemandeEnlevement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DemandeATraiterDAO {
    protected Connection connect = null;

    public DemandeATraiterDAO(Connection conn) {
        this.connect = conn;
    }

    public ArrayList<DemandeEnlevement> GetDemandesInJournal(){
        ArrayList<DemandeEnlevement> listDemandes = new ArrayList<>();

        try {
            String query = "SELECT * " +
                            "FROM MSPR_JOURNAL_DEMANDES_A_TRAITER ";
            PreparedStatement ps = this.connect.prepareStatement(query);

            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(connect);
                DemandeEnlevement demandeEnlevement = demandeEnlevementDAO.GetById(rs.getInt("ID_DEMANDE"));

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

    public void Insert(int idDemande){
        try {
            String query = "INSERT INTO MSPR_JOURNAL_DEMANDES_A_TRAITER (ID_DEMANDE) VALUES(?)";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, idDemande);

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();

                }
            } catch (SQLException ignore) {

            }
        }


    }

    public void Delete(int idDemande){
        try {
            String query = "DELETE FROM MSPR_JOURNAL_DEMANDES_A_TRAITER WHERE ID_DEMANDE = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, idDemande);

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();

                }
            } catch (SQLException ignore) {

            }
        }
    }
}
