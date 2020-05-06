package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.User;
//import com.recycl.dashboard.utils.PasswordUtils;
import org.mindrot.jbcrypt.BCrypt;

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
            securePassword = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12));
          //  securePassword = PasswordUtils.generateSecurePassword(user.getPassword());
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

            String query = "INSERT INTO UTILISATEUR(ID, USERNAME, PASSWORD) " +
                    "VALUES (?,?,?)";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, securePassword);

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
                           "FROM UTILISATEUR";
            PreparedStatement ps = this.connect.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));

                int role = rs.getInt("ID_ROLE");
                RoleDAO roleDAO = new RoleDAO(connect);
                user.setRole(roleDAO.GetById(role));

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
                           "FROM UTILISATEUR " +
                           "WHERE USERNAME = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user.setId(rs.getInt("ID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
            }
            passwordMatch  = BCrypt.checkpw(password, user.getPassword());
           // passwordMatch = PasswordUtils.verifyUserPassword(password, user.getPassword());

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
