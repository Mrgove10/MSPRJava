package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Employe;
import com.recycl.dashboard.back.Beans.Tournee;
import com.recycl.dashboard.back.Beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// creation et affectation
public class TourneeDAO {
    protected Connection connect = null;

    public TourneeDAO(Connection conn) {
        this.connect = conn;
    }

    public Tournee GetById(int id){
        Tournee tournee = new Tournee();
        int idEmploye = -1;
        int idCamion = -1;

        try {
            String query = "SELECT * " +
                    "FROM MSPR_TOURNEE " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                tournee.setId(rs.getInt("ID"));
                tournee.setDate(rs.getDate("DATE_TOURNEE"));
                idEmploye = rs.getInt("ID_EMPLOYE");
                idCamion = rs.getInt("ID_CAMION");
            }

            EmployeDAO employeDAO = new EmployeDAO(connect);
            tournee.setEmploye(employeDAO.GetById(idEmploye));

            CamionDAO camionDAO = new CamionDAO(connect);
            tournee.setCamion(camionDAO.GetById(idCamion));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return tournee;
            }
        }

        return null;
    }

    public ArrayList<Tournee> GetTodayTournees(){
        ArrayList<Tournee> tournees = new ArrayList<Tournee>();

        try {
            String query = "SELECT * " +
                    "FROM MSPR_TOURNEE " +
                    "WHERE DATE_TOURNEE = (SELECT TO_CHAR(CURRENT_DATE, 'DD/MON/YY') FROM dual)";
            PreparedStatement ps = this.connect.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Tournee tournee = new Tournee();
                tournee.setId(rs.getInt("ID"));
                tournee.setDate(rs.getDate("DATE_TOURNEE"));

                EmployeDAO employeDAO = new EmployeDAO(connect);
                tournee.setEmploye(employeDAO.GetById(rs.getInt("ID_EMPLOYE")));

                CamionDAO camionDAO = new CamionDAO(connect);
                tournee.setCamion(camionDAO.GetById(rs.getInt("ID_CAMION")));

                tournees.add(tournee);
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return tournees;
            }
        }

        return null;
    }

    public ArrayList<Tournee> GetTomorrowTournees(){
        ArrayList<Tournee> tournees = new ArrayList<Tournee>();

        try {
            String query = "SELECT * " +
                    "FROM MSPR_TOURNEE " +
                    "WHERE DATE_TOURNEE = (SELECT TO_CHAR(CURRENT_DATE+1, 'DD/MON/YY') FROM dual)";
            PreparedStatement ps = this.connect.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Tournee tournee = new Tournee();
                tournee.setId(rs.getInt("ID"));
                tournee.setDate(rs.getDate("DATE_TOURNEE"));

                EmployeDAO employeDAO = new EmployeDAO(connect);
                tournee.setEmploye(employeDAO.GetById(rs.getInt("ID_EMPLOYE")));

                CamionDAO camionDAO = new CamionDAO(connect);
                tournee.setCamion(camionDAO.GetById(rs.getInt("ID_CAMION")));

                tournees.add(tournee);
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return tournees;
            }
        }

        return null;
    }

    public ArrayList<Tournee> GetDayAfterTomorrowTournees(){
        ArrayList<Tournee> tournees = new ArrayList<Tournee>();

        try {
            String query = "SELECT * " +
                    "FROM MSPR_TOURNEE " +
                    "WHERE DATE_TOURNEE = (SELECT TO_CHAR(CURRENT_DATE+2, 'DD/MON/YY') FROM dual)";
            PreparedStatement ps = this.connect.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Tournee tournee = new Tournee();
                tournee.setId(rs.getInt("ID"));
                tournee.setDate(rs.getDate("DATE_TOURNEE"));

                EmployeDAO employeDAO = new EmployeDAO(connect);
                tournee.setEmploye(employeDAO.GetById(rs.getInt("ID_EMPLOYE")));

                CamionDAO camionDAO = new CamionDAO(connect);
                tournee.setCamion(camionDAO.GetById(rs.getInt("ID_CAMION")));

                tournees.add(tournee);
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return tournees;
            }
        }

        return null;
    }


}
