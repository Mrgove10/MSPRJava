package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Employe;
import com.recycl.dashboard.back.Beans.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

// embauche,licenciement, indisponibilité
public class EmployeDAO {
    protected Connection connect = null;

    public EmployeDAO(Connection conn) {
        this.connect = conn;
    }

    public Employe GetById(int id) throws SQLException {
        Employe employe = new Employe();
        int idSite = -1;

        try {
            String query = "SELECT * " +
                    "FROM MSPR_EMPLOYE " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                employe.setId(rs.getInt("ID"));
                employe.setNom(rs.getString("NOM"));
                employe.setPrenom(rs.getString("PRENOM"));
                employe.setDateNaissance(rs.getDate("DATE_NAISSANCE"));
                employe.setDateEmbauche(rs.getDate("DATE_EMBAUCHE"));
                employe.setSalaire(rs.getFloat("SALAIRE"));
                employe.setFonction(rs.getString("FONCTION"));
                idSite = rs.getInt("ID_SITE");
            }

            SiteDAO siteDAO = new SiteDAO(connect);
            employe.setSite(siteDAO.GetById(idSite));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return employe;
            }
        }

        return null;
    }

    public Map<Employe, Integer> GetEmployesWhereNbTourneesSmallerThan(int number){
        Map<Employe, Integer> listEmployes = new Hashtable();
        try {
            String query = "SELECT MSPR_TOURNEE.ID_EMPLOYE, COUNT(*) AS NB_TOURNEES " +
                            "FROM MSPR_TOURNEE " +
                            "left join MSPR_EMPLOYE on MSPR_EMPLOYE.ID = MSPR_TOURNEE.ID_EMPLOYE " +
                            "GROUP BY MSPR_TOURNEE.ID_EMPLOYE " +
                            "ORDER BY NB_TOURNEES DESC";
            PreparedStatement ps = this.connect.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int idEmploye = rs.getInt("ID_EMPLOYE");
                int nbTournees = rs.getInt("NB_TOURNEES");
                if (nbTournees < number){
                    Employe employe = GetById(idEmploye);

                    listEmployes.put(employe, nbTournees);
                }
            }

            Map<Employe, Integer> sorted = listEmployes.entrySet()
                                                        .stream()
                                                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return listEmployes;
            }
        }

        return null;
    }
}
