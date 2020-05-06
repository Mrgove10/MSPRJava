package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Dechet;
import com.recycl.dashboard.back.Beans.DetailDemandeDechet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DechetDAO {
    protected Connection connect = null;

    public DechetDAO(Connection conn) {
        this.connect = conn;
    }

    public Dechet GetById(int id){
        Dechet dechet = new Dechet();
        int idDanger = -1;

        try {
            String query = "SELECT * " +
                    "FROM Dechet " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                dechet.setId(rs.getInt("ID"));
                dechet.setType(rs.getString("TYPE"));
                dechet.setUnite(rs.getString("UNITE"));
                dechet.setLimiteForfait(rs.getFloat("LIMITE_FORFAIT"));
                dechet.setTarifForfait(rs.getFloat("TARIF_FORFAIT"));
                dechet.setTarifLot(rs.getFloat("TARIF_LOT"));
                dechet.setNbLot(rs.getInt("NB_LOT"));
                idDanger = rs.getInt("ID_DANGER");
            }

            DangerDAO dangerDAO = new DangerDAO(connect);
            dechet.setDanger(dangerDAO.GetById(idDanger));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return dechet;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }

}
