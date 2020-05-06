package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.DetailDemande;
import com.recycl.dashboard.back.Beans.DetailDemandeDechet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailDemandeDechetDAO {
    protected Connection connect = null;

    public DetailDemandeDechetDAO(Connection conn) {
        this.connect = conn;
    }

    public DetailDemandeDechet GetById(int id){
        DetailDemandeDechet detailDemandeDechet = new DetailDemandeDechet();
        int idDetailDemande = -1;
        int idDechet = -1;

        try {
            String query = "SELECT * " +
                    "FROM Detail_Demande_Dechet " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                detailDemandeDechet.setId(rs.getInt("ID"));
                idDetailDemande = rs.getInt("ID_DETAIL_DEMANDE");
                idDechet = rs.getInt("ID_DECHET");
            }

            DetailDemandeDAO detailDemandeDAO = new DetailDemandeDAO(connect);
            detailDemandeDechet.setDetailDemande(detailDemandeDAO.GetById(idDetailDemande));

            DechetDAO dechetDAO = new DechetDAO(connect);
            detailDemandeDechet.setDechet(dechetDAO.GetById(idDechet));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return detailDemandeDechet;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }

}
