package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.Role;
import com.recycl.dashboard.back.Beans.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO {
    protected Connection connect = null;

    public RoleDAO(Connection conn) {
        this.connect = conn;
    }

    public Role GetById(int id){
        Role role = new Role();

        try {
            String query = "SELECT * " +
                    "FROM MSPR_ROLE " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                role.setId(rs.getInt("ID"));
                role.setType(rs.getString("TYPE"));
            }

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return role;
            }
        }

        return null;
    }

}
