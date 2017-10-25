package controller;

import Model.Wallet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    public ArrayList<Wallet> loadWalletFromLogin(String id, String pw){
        Connection conn = setConnettion("jdbc:sqlite:GameWallet.db");
        if(conn != null){
            System.out.println("Connected to the database...");
            String query = "select WalletId, balance\n" +
                    "from wallets\n" +
                    "join customers\n" +
                    "on wallets.CustomerId = customers.CustomesId\n" +
                    "where wallets.CustomerId=\"" + id + "\"";
        }
        return null;

    }

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
