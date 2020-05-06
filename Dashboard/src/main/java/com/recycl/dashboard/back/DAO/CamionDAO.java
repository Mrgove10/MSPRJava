package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Camion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CamionDAO {
    protected Connection connect = null;

    public CamionDAO(Connection conn) {
        this.connect = conn;
    }

    public Camion GetById(int id){
        Camion camion = new Camion();
        int idSite = -1;

        try {
            String query = "SELECT * " +
                    "FROM MSPR_CAMION " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                camion.setId(rs.getInt("ID"));
                camion.setNumMatricule(rs.getString("NO_MATRICULE"));
                camion.setDateAchat(rs.getDate("DATE_ACHAT"));
                camion.setModele(rs.getString("MODELE"));
                camion.setMarque(rs.getString("MARQUE"));
                idSite = rs.getInt("ID_SITE");
            }

            SiteDAO siteDAO = new SiteDAO(connect);
            camion.setSite(siteDAO.GetById(idSite));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return camion;
            }
        }

        return null;
    }
}
