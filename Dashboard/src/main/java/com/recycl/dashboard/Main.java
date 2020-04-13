package com.recycl.dashboard;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.DAO.UserDAO;

public class Main {


    public static void main(String[] args) {

        System.out.println("Hello");
        UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
        System.out.println("End");
    }


}



