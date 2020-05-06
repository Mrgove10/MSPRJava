package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Danger;
import com.recycl.dashboard.back.Beans.Dechet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DangerDAO {
    protected Connection connect = null;

    public DangerDAO(Connection conn) {
        this.connect = conn;
    }

    public Danger GetById(int id){
        Danger danger = new Danger();

        try {
            String query = "SELECT * " +
                    "FROM Danger " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                danger.setId(rs.getInt("ID"));
                danger.setNiveau(rs.getString("LEVEL"));
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return danger;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }

}
