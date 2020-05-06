package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Dechet;
import com.recycl.dashboard.back.Beans.Depot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepotDAO {
    protected Connection connect = null;

    public DepotDAO(Connection conn) {
        this.connect = conn;
    }

    public Depot GetById(int id){
        Depot depot = new Depot();
        int idTournee = -1;
        int idCentre = -1;

        try {
            String query = "SELECT * " +
                    "FROM Depot " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                depot.setId(rs.getInt("ID"));
                depot.setQuantite(rs.getInt("QUANTITE"));
                idTournee = rs.getInt("ID_TOURNEE");
                idCentre = rs.getInt("ID_CENTRE");
            }

            TourneeDAO tourneeDAO = new TourneeDAO(connect);
            depot.setTournee(tourneeDAO.GetById(idTournee));

            CentreDAO centreDAO = new CentreDAO(connect);
            depot.setCentre(centreDAO.GetById(idCentre));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return depot;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }

}
