package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Tournee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TourneeDAO {
    protected Connection connect = null;

    public TourneeDAO(Connection conn) {
        this.connect = conn;
    }

    public Tournee GetById(int id){
        Tournee tournee = new Tournee();
        try {
            String query = "SELECT * " +
                    "FROM Tournee " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                tournee.setId(rs.getInt("ID"));
                tournee.setDate(rs.getDate("DATE"));

                int camion = rs.getInt("ID_CAMION");
                CamionDAO camionDAO = new CamionDAO(connect);
                tournee.setCamion(camionDAO.GetById(camion));

                int employe = rs.getInt("ID_EMPLOYE");
                EmployeDAO employeDAO = new EmployeDAO(connect);
                tournee.setEmploye(employeDAO.GetById(employe));
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return tournee;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }
}
