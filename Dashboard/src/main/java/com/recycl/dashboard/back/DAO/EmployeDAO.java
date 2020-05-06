package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Employe;
import com.recycl.dashboard.back.Beans.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeDAO {
    protected Connection connect = null;

    public EmployeDAO(Connection conn) {
        this.connect = conn;
    }

    public Employe GetById(int id){
        Employe employe = new Employe();

        try {
            String query = "SELECT * " +
                    "FROM Employe " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                employe.setId(rs.getInt("ID"));
                employe.setNom(rs.getString("NOM"));
                employe.setPrenom(rs.getString("PRENOM"));
                employe.setDateNaissance(rs.getDate("DATE_NAISSANCE"));
                employe.setDateEmbauche(rs.getDate("DATE_EMBAUCHE"));
                employe.setSalaire(rs.getFloat("SALAIRE"));
                employe.setFonction(rs.getString("FONCTION"));

                int site = rs.getInt("ID_SITE");
                SiteDAO siteDAO = new SiteDAO(connect);
                employe.setSite(siteDAO.GetById(site));
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return employe;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }
}
