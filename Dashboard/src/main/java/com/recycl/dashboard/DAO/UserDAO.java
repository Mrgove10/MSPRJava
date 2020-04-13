package com.recycl.dashboard.DAO;

import com.recycl.dashboard.Beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    protected Connection connect = null;

    public UserDAO(Connection conn) {
        this.connect = conn;
    }

    public boolean Create(User user){
        try {
            PreparedStatement ps = this.connect.prepareStatement("INSERT INTO User(Username, Password, RoleId) VALUES (?,?,?);");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRole().getId());

            ps.executeUpdate();

        } catch (SQLException e) {

            return false;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return true;
                }
            } catch (SQLException ignore) {

                return false;
            }
        }

        return false;
    }
}
