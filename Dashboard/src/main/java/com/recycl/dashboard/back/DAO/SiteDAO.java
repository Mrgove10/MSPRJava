package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SiteDAO {
    protected Connection connect = null;

    public SiteDAO(Connection conn) {
        this.connect = conn;
    }

    public Site GetById(int id){
        Site site = new Site();
        int idAddress = -1;

        try {
            String query = "SELECT * " +
                    "FROM MSPR_SITE " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                site.setId(rs.getInt("ID"));
                site.setNom(rs.getString("NOM"));
                idAddress = rs.getInt("ID_ADRESSE");
            }

            AdresseDAO adresseDAO = new AdresseDAO(connect);
            site.setAdresse(adresseDAO.GetById(idAddress));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return site;
            }
        }

        return null;
    }

    public ArrayList<Site> GetAll(){
        ArrayList<Site> sites = new ArrayList<Site>();

        try {
            String query = "SELECT * " +
                    "FROM MSPR_SITE ";
            PreparedStatement ps = this.connect.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Site site = new Site();
                site.setId(rs.getInt("ID"));
                site.setNom(rs.getString("NOM"));

                int idAddress = rs.getInt("ID_ADRESSE");
                AdresseDAO adresseDAO = new AdresseDAO(connect);
                site.setAdresse(adresseDAO.GetById(idAddress));

                sites.add(site);
            }


            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return sites;
            }
        }

        return null;
    }
}
