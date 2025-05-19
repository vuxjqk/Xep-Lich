/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PC
 */
public class DatabaseHelper {

    private Connection connection;

    public void open() {
        String strServer = "";
        String strDatabase = "";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://" + strServer
                    + ":1433;databaseName=" + strDatabase
                    //+ ":50191;databaseName=" + strDatabase
                    + ";user=sa;password=123"
                    //+ ";integratedSecurity=true"
                    + ";encrypt=true;trustServerCertificate=true";

            connection = DriverManager.getConnection(connectionURL);
        } catch (ClassNotFoundException | SQLException e) {

        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {

        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
    }

    public int executeUpdate(String sql) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            return -1;
        }
    }
}
