package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Dechet;
import com.recycl.dashboard.back.Beans.DetailDemandeDechet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

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

    public Map<String, Integer> GetTypesDechetsByDemande(int idDemande){
        Map<String, Integer> listTypeDechets = new HashMap<>();
        DetailDemandeDechetDAO detailDemandeDechetDAO = new DetailDemandeDechetDAO(connect);
        List<Integer> listId = detailDemandeDechetDAO.GetDechetsId(idDemande);

        try {
            for (int id:listId) {
                String query = "SELECT TYPE_DECHET, COUNT(*) AS COUNT_TYPE " +
                                "FROM MSPR_DECHET " +
                                "WHERE ID = ? " +
                                "GROUP BY TYPE_DECHET HAVING COUNT(*) > 0";
                PreparedStatement ps = this.connect.prepareStatement(query);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    listTypeDechets.put(rs.getString("TYPE_DECHET"), rs.getInt("COUNT_TYPE"));
                }

                rs.close();
            }


        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return listTypeDechets;
            }
        }

        return null;
    }

    public ArrayList<Dechet> GetDechetsByDemande(int idDemande){
        ArrayList<Dechet> listDechets = new ArrayList<>();
        DetailDemandeDechetDAO detailDemandeDechetDAO = new DetailDemandeDechetDAO(connect);
        List<Integer> listId = detailDemandeDechetDAO.GetDechetsId(idDemande);

        try {
            for (int id:listId) {
                String query = "SELECT * " +
                        "FROM MSPR_DECHET " +
                        "WHERE ID = ? ";
                PreparedStatement ps = this.connect.prepareStatement(query);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    Dechet dechet = new Dechet();

                    dechet.setId(rs.getInt("ID"));
                    dechet.setType(rs.getString("TYPE_DECHET"));
                    dechet.setDanger(rs.getInt("NIV_DANGER"));

                    listDechets.add(dechet);
                }

                rs.close();
            }


        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return listDechets;
            }
        }

        return null;
    }

    public ArrayList<Dechet> GetAll(){
        ArrayList<Dechet> listDechets = new ArrayList<>();

        try {
            String query = "SELECT * " +
                    "FROM MSPR_DECHET ";
            PreparedStatement ps = this.connect.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Dechet dechet = new Dechet();

                dechet.setId(rs.getInt("ID"));
                dechet.setType(rs.getString("TYPE_DECHET"));
                dechet.setDanger(rs.getInt("NIV_DANGER"));

                listDechets.add(dechet);
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
}
