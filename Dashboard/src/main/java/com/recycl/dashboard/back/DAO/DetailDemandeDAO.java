package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.DetailDemande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailDemandeDAO {
    protected Connection connect = null;

    public DetailDemandeDAO(Connection conn) {
        this.connect = conn;
    }

    public DetailDemande GetById(int id){
        DetailDemande detailDemande = new DetailDemande();

        try {
            String query = "SELECT * " +
                    "FROM Detail_Demande " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                detailDemande.setId(rs.getInt("ID"));
                detailDemande.setQuantite(rs.getInt("QUANTITE"));

                int demandeEnlevement = rs.getInt("ID_DEMANDE_ENLEVEMENT");
                DemandeEnlevementDAO demandeEnlevementDAO = new DemandeEnlevementDAO(connect);
                detailDemande.setDemandeEnlevement(demandeEnlevementDAO.GetById(demandeEnlevement));
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return detailDemande;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }
}
