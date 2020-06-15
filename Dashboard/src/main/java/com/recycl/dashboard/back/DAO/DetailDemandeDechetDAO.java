package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.DemandeEnlevement;
import com.recycl.dashboard.back.Beans.DetailDemandeDechet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class DetailDemandeDechetDAO {
    protected Connection connect = null;

    public DetailDemandeDechetDAO(Connection conn) {
        this.connect = conn;
    }

    public DetailDemandeDechet GetById(int id){
        DetailDemandeDechet detailDemandeDechet = new DetailDemandeDechet();
        int idDechet = -1;

        try {
            String query = "SELECT * " +
                    "FROM MSPR_DETAIL_DEMANDE_DECHET " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                detailDemandeDechet.setId(rs.getInt("ID"));
                idDechet = rs.getInt("ID_DECHET");
            }

            DechetDAO dechetDAO = new DechetDAO(connect);
            detailDemandeDechet.setDechet(dechetDAO.GetById(idDechet));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return detailDemandeDechet;
            }
        }

        return null;
    }

    public List<Integer> GetDechetsId(int idDemande){
        List<Integer> listDechets = new ArrayList<>();

        try {
            String query = "SELECT * " +
                    "FROM MSPR_DETAIL_DEMANDE_DECHET " +
                    "WHERE ID_DEMANDE_ENLEVEMENT = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, idDemande);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                listDechets.add(rs.getInt("ID_DECHET"));
            }


            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return listDechets;
            }
        }

        return null;
    }

    public Map<Integer, Integer> GetDechetsAndQuantity(ArrayList<DemandeEnlevement> demandes){
        Map<Integer, Integer> map = new Hashtable<>();

        try {
            for (DemandeEnlevement demandeEnlevement:demandes) {
                String query = "SELECT ID_DECHET, SUM(QUANTITE) AS QUANTITE " +
                        "FROM MSPR_DETAIL_DEMANDE_DECHET " +
                        "WHERE ID_DEMANDE_ENLEVEMENT = ? " +
                        "GROUP BY ID_DECHET";
                PreparedStatement ps = this.connect.prepareStatement(query);
                ps.setInt(1, demandeEnlevement.getId());

                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    int idDechet = rs.getInt("ID_DECHET");
                    int quantite = rs.getInt("QUANTITE");
                    if (map.containsKey(idDechet)){
                        quantite += map.get(idDechet);
                    }
                    map.put(idDechet, quantite);
                }

                rs.close();
            }


        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return map;
            }
        }

        return null;
    }
}
