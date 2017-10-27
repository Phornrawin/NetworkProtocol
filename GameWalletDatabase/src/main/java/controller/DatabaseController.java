package controller;

import Model.Customer;
import Model.Report;
import Model.Wallet;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class DatabaseController {
    private static DatabaseController dbController;
    private SimpleDateFormat dateFormat;

    private DatabaseController(){
        dateFormat = new SimpleDateFormat("E dd MMM yyyy HH:mm", Locale.ENGLISH);
    }

    public static DatabaseController getInstance(){
        if(dbController == null){
            dbController = new DatabaseController();
        }
        return dbController;
    }

    public Customer checkIDFromLogin(String id, String pw){
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
                        return new Customer(resultSet.getString(3), resultSet.getString(4), resultSet.getString(1), resultSet.getString(2));

                }
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public ArrayList<String> loadWalletFromLogin(String id){
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

                ArrayList<String> wallets = new ArrayList<>();
                while(resultSet.next()){
                    wallets.add(new Wallet(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3)).toString());
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

    public ArrayList<String> loadReportFromCustomerID(String id){
        Connection conn = setConnettion("jdbc:sqlite:GameWallet.db");

        try {
            if(conn != null){
                System.out.println("Connected to the database...");
                String query = "select GameName, Date, Net\n" +
                        "from reports\n" +
                        "where reports.CustomerID=\"" + id + "\"";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                ArrayList<String> reports = new ArrayList<String>();
                while(resultSet.next()){
                    String CustomerId = id;
                    String gameName = resultSet.getString(1);
                    Date date = dateFormat.parse(resultSet.getString(2));
                    double net = resultSet.getDouble(3);

                    reports.add(new Report(CustomerId, gameName, date, net).toString());
                }
                conn.close();
                return reports;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addReportToDatabase(Report report){
        Connection conn = setConnettion("jdbc:sqlite:GameWallet.db");
        try {
            if(conn != null) {
                System.out.println("Connected to the database...");
                String query = String.format("insert into reports values (\'%s\', \'%s\', \'%s\', \'%s\')", report.getCustomerID(), report.getGameName(), report.getTransactionDate(), report.getNet());

                Statement statement = conn.createStatement();
                statement.executeUpdate(query);

                conn.close();
                return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return false;
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
