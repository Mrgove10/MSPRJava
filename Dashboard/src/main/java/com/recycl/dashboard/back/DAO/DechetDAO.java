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
                    "FROM MSPR_DECHET " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                dechet.setId(rs.getInt("ID"));
                dechet.setType(rs.getString("TYPE_DECHET"));
                dechet.setUnite(rs.getString("UNITE_DECHET"));
                dechet.setLimiteForfait(rs.getFloat("LIMITE_FORFAIT"));
                dechet.setTarifForfait(rs.getFloat("TARIF_FORFAIT"));
                dechet.setTarifLot(rs.getFloat("TARIF_LOT"));
                dechet.setNbLot(rs.getInt("NB_LOT"));
                dechet.setDanger(rs.getInt("NIV_DANGER"));
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return dechet;
            }
        }

        return null;
    }

}
