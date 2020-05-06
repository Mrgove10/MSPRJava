package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Dechet;
import com.recycl.dashboard.back.Beans.DechetDepot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DechetDepotDAO {
    protected Connection connect = null;

    public DechetDepotDAO(Connection conn) {
        this.connect = conn;
    }

    public DechetDepot GetById(int id){
        DechetDepot dechetDepot = new DechetDepot();

        try {
            String query = "SELECT * " +
                    "FROM Dechet_Depot " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                dechetDepot.setId(rs.getInt("ID"));

                int dechet = rs.getInt("ID_DECHET");
                DechetDAO dechetDAO = new DechetDAO(connect);
                dechetDepot.setDechet(dechetDAO.GetById(dechet));

                int depot = rs.getInt("ID_DEPOT");
                DepotDAO depotDAO = new DepotDAO(connect);
                dechetDepot.setDepot(depotDAO.GetById(depot));
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return dechetDepot;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }

}
