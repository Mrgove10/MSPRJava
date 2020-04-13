package com.recycl.dashboard.DAO;

import com.recycl.dashboard.Beans.User;
import com.recycl.dashboard.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    protected Connection connect = null;

    public UserDAO(Connection conn) {
        this.connect = conn;
    }

    public boolean Create(User user){
        String securePassword;

        try {
            securePassword = PasswordUtils.generateSecurePassword(user.getPassword());
        }catch (Exception e){
            return false;
        }

        try {
//            String query = "INSERT INTO User(Username, Password, RoleId) " +
//                           "VALUES (?,?,?)";
//            PreparedStatement ps = this.connect.prepareStatement(query);
//            ps.setString(1, user.getUsername());
//            ps.setString(2, securePassword);
//            ps.setInt(3, user.getRole().getId());

            String query = "INSERT INTO User(Username, Password) " +
                    "VALUES (?,?)";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, securePassword);

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

    public ArrayList<User> GetAllUsers(){
        ArrayList<User> listUsers = new ArrayList<>();

        try {
            String query = "SELECT * " +
                           "FROM User";
            PreparedStatement ps = this.connect.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("Id"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));

                listUsers.add(user);
            }


            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return listUsers;
                }
            } catch (SQLException ignore) {
                return null;
            }
        }

        return null;
    }

    public boolean IsUserExistsByUsernameAndPassword(String username, String password){
        boolean passwordMatch = false;
        User user = new User();
        try {
            String query = "SELECT * " +
                           "FROM User " +
                           "WHERE Username = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user.setId(rs.getInt("Id"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
            }

            passwordMatch = PasswordUtils.verifyUserPassword(password, user.getPassword());

            rs.close();

        } catch (SQLException e) {
            return false;
        } finally {
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return passwordMatch;
                }
            } catch (SQLException ignore) {
                return false;
            }
        }

        return false;
    }
}
