package com.recycl.dashboard.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnection {
    public static Connection ConnectDb(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(Config.path, Config.user, Config.password);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }
}
