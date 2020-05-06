package com.recycl.dashboard.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnection {
    public static Connection ConnectDb() throws SQLException {
        Connection connection = null;

        if (connection == null || connection.isClosed()){
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(Config.path, Config.user, Config.password);
            }catch (ClassNotFoundException e){
                System.out.println("Driver introuvable : ");
                e.printStackTrace();
            }catch (SQLException e){
                System.out.println("SQL Error : ");
                e.printStackTrace();
            }catch (Exception e){
                System.out.println("Autre erreur : ");
                e.printStackTrace();
            }
        }



        return connection;
    }
}
