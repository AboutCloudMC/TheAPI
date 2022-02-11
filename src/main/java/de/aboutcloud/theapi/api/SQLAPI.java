package de.aboutcloud.theapi.api;

import org.bukkit.Bukkit;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLAPI {

    private String host;
    private String database;
    private String username;
    private String password;
    private String port;

    private Connection con;

    public SQLAPI(String host, String database, String username, String password, String port) {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        this.port = port;

        connect();
    }

    private void connect() {
        if(!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database,username,password);
                Bukkit.getConsoleSender().sendMessage("§aMySQL Verbindung erfolgreich!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void close() {
        if(isConnected()) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Bukkit.getConsoleSender().sendMessage("§cMySQL Verbindung abgebrochen!");
        }
    }

    public boolean isConnected() {
        return con != null;
    }

    public void createTableCoins() {
        /*

        Systax: Spielername, UUID, Ende, Grund

         */

        if(isConnected()) {
            try {
                PreparedStatement ps = getCon().prepareStatement("CREATE TABLE IF NOT EXISTS Coins (UUID VARCHAR(100), Coins VARCHAR(100))");
                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void createTable(String name, String... values) {
        if(isConnected()) {
            String val = "";

            for(String value : values) {
                if(val.equals("")) {
                    val += value + " VARCHAR(100)";
                } else
                    val += ", " +  value + " VARCHAR(100)";
            }
            try {
                PreparedStatement ps = getCon().prepareStatement("CREATE TABLE IF NOT EXISTS Coins (" + val + ")");
                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void update(String qry) {
        if(isConnected()) {
            try {
                con.createStatement().executeUpdate(qry);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public ResultSet getResult(String qry) {
        if(isConnected()) {
            try {
                return con.createStatement().executeQuery(qry);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    public Connection getCon() {
        return con;
    }
}

