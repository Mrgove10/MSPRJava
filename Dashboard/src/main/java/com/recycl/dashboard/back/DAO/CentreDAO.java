package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Centre;
import com.recycl.dashboard.back.Beans.Depot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CentreDAO {
    protected Connection connect = null;

    public CentreDAO(Connection conn) {
        this.connect = conn;
    }

    public Centre GetById(int id){
        Centre centre = new Centre();

        try {
            String query = "SELECT * " +
                    "FROM Centre " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                centre.setId(rs.getInt("ID"));
                centre.setNom(rs.getString("NOM"));

                int address = rs.getInt("ID_ADDRESS");
                AdresseDAO adresseDAO = new AdresseDAO(connect);
                centre.setAdresse(adresseDAO.GetById(address));
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return centre;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }

}
