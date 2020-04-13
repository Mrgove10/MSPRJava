package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SiteDAO {
    protected Connection connect = null;

    public SiteDAO(Connection conn) {
        this.connect = conn;
    }

    public Site GetById(int id){
        Site site = new Site();

        try {
            String query = "SELECT * " +
                    "FROM Camion " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                site.setId(rs.getInt("ID"));
                site.setNom(rs.getString("NOM"));

                int adresse = rs.getInt("ID_ADRESSE");
                AdresseDAO adresseDAO = new AdresseDAO(connect);
                site.setAdresse(adresseDAO.GetById(adresse));
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return site;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }
}
