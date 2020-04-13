package com.recycl.dashboard.back;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.back.DAO.UserDAO;

public class MainBDD {
    public void startBDD() {
        System.out.println("Starting BDD");
        UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
    }
}
