package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Report {
    private String CustomerID;
    private String gameName;
    private Date transactionDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("E dd MMM yyyy HH:mm", Locale.ENGLISH);
    private Double net;

    public Report(String customerID, String gameName, Date transactionDate, Double net) {
        CustomerID = customerID;
        this.gameName = gameName;
        this.transactionDate = transactionDate;
        this.net = net;
    }

    @Override
    public String toString() {
        return getGameName() + "-" + dateFormat.format(getTransactionDate()) + "-" + getNet();
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
