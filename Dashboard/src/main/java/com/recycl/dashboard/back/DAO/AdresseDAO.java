package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Adresse;
import com.recycl.dashboard.back.Beans.Tournee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresseDAO {
    protected Connection connect = null;

    public AdresseDAO(Connection conn) {
        this.connect = conn;
    }

    public Adresse GetById(int id){
        Adresse adresse = new Adresse();
        try {
            String query = "SELECT * " +
                    "FROM MSPR_ADRESSE " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                adresse.setId(rs.getInt("ID"));
                adresse.setNumRue(rs.getInt("NO_RUE"));
                adresse.setRue(rs.getString("RUE"));
                adresse.setCodePostal(rs.getInt("CP"));
                adresse.setVille(rs.getString("VILLE"));
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return adresse;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }
}
