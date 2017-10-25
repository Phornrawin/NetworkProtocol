package controller;

import Model.Report;
import Model.Wallet;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.*;
import java.util.ArrayList;


public class DatabaseController {
    private static DatabaseController dbController;

    private DatabaseController(){

    }

    public static DatabaseController getInstance(){
        if(dbController == null){
            dbController = new DatabaseController();
        }
        return dbController;
    }

    public Boolean checkIDFromLogin(String id, String pw){
        Connection conn = setConnettion("jdbc:sqlite:GameWallet.db");

        try {
            if(conn != null){
                System.out.println("Connected to the database...");
                String query = "select * from customers";
                Statement statement = null;
                statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while(resultSet.next()){
                    if(id.equals(resultSet.getString(1)) && pw.equals(resultSet.getString(2)))
                        return true;
                }
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    public ArrayList<Wallet> loadWalletFromLogin(String id){
        Connection conn = setConnettion("jdbc:sqlite:GameWallet.db");
        try {
            if(conn != null) {
                System.out.println("Connected to the database...");
                String query = "select WalletId, balance\n" +
                            "from wallets\n" +
                            "join customers\n" +
                            "on wallets.CustomerId = customers.CustomesId\n" +
                            "where wallets.CustomerId=\"" + id + "\"";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                ArrayList<Wallet> wallets = new ArrayList<Wallet>();
                while(resultSet.next()){
                    wallets.add(new Wallet(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3)));
                    System.out.println("wallets = " + wallets);
                }
                conn.close();
                return wallets;
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }


        return null;

    }

    public Boolean checkAndPayFromGameDredit(double net, String idWallet){
        Connection conn = setConnettion("jdbc:sqlite:GameWallet.db");

        try {
            if(conn != null){
                System.out.println("Connected to the database...");
                String query = "select balance\n" +
                        "from wallets\n" +
                        "where wallets.WalletId=\"" + idWallet + "\"";
                Statement statement = null;
                statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while(resultSet.next()){
                    if(net <= resultSet.getDouble(1))
                        return true;
                }
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

//    public ArrayList<Report> loadReportFrom

    public Connection setConnettion(String url){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
    


}
