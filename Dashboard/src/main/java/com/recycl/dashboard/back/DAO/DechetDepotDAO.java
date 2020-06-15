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
        int idDechet = -1;
        int idDepot = -1;

        try {
            String query = "SELECT * " +
                    "FROM MSPR_DECHET_DEPOT " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                dechetDepot.setId(rs.getInt("ID"));
                idDechet = rs.getInt("ID_DECHET");
                idDepot = rs.getInt("ID_DEPOT");
            }

            DechetDAO dechetDAO = new DechetDAO(connect);
            dechetDepot.setDechet(dechetDAO.GetById(idDechet));

            DepotDAO depotDAO = new DepotDAO(connect);
            dechetDepot.setDepot(depotDAO.GetById(idDepot));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return dechetDepot;
            }
        }

        return null;
    }

}
