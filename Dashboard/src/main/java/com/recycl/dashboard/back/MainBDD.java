package com.recycl.dashboard.back;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.back.Beans.User;
import com.recycl.dashboard.back.DAO.UserDAO;

import java.util.ArrayList;

public class MainBDD {
    public void startBDD() {
        System.out.println("Starting BDD");
        UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
//        User user = new User();
//        user.setId(2);
//        user.setUsername("User");
//        user.setPassword("54321");
//        userDAO.Create(user);

//        var check = userDAO.IsUserExistsByUsernameAndPassword("Test", "12345");
//        System.out.println("Is exists : "+check);

//        ArrayList<User> listUsers = userDAO.GetAllUsers();
//        for (User user:listUsers) {
//            System.out.println(user.getUsername());
//        }
    }
}
