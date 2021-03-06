package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Centre;
import com.recycl.dashboard.back.Beans.Depot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CentreDAO {
    // CRUD
    protected Connection connect = null;

    public CentreDAO(Connection conn) {
        this.connect = conn;
    }

    public Centre GetById(int id){
        Centre centre = new Centre();
        int idAddress = -1;

        try {
            String query = "SELECT * " +
                    "FROM MSPR_CENTRE_TRAITEMENT " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                centre.setId(rs.getInt("ID"));
                centre.setNom(rs.getString("NOM"));
                idAddress = rs.getInt("ID_ADRESSE");
            }

            AdresseDAO adresseDAO = new AdresseDAO(connect);
            centre.setAdresse(adresseDAO.GetById(idAddress));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return centre;
            }
        }

        return null;
    }

}
