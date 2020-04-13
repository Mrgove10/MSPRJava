package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.DemandeEnlevement;
import com.recycl.dashboard.back.Beans.User;

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

    public ArrayList<DemandeEnlevement> GetDemandesByDateDemande(Date date){
        ArrayList<DemandeEnlevement> listDemandes = new ArrayList<>();

        try {
            String query = "SELECT * " +
                           "FROM Demande_Enlevement " +
                           "WHERE DATE_DEMANDE = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setDate(1, date);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                DemandeEnlevement demandeEnlevement = new DemandeEnlevement();
                demandeEnlevement.setId(rs.getInt("ID"));
                demandeEnlevement.setNumero(rs.getInt("NO"));
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
}
