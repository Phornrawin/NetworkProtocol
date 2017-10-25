package Model;

import java.util.Date;

public class Report {
    private String CustomerID;
    private String gameName;
    private Date transactionDate;
    private Double net;

    public Report(String customerID, String gameName, Date transactionDate, Double net) {
        CustomerID = customerID;
        this.gameName = gameName;
        this.transactionDate = transactionDate;
        this.net = net;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getGameName() {
        return gameName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public Double getNet() {
        return net;
    }
}
