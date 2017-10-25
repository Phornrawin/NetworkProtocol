package Model;

public class Wallet {
    private String id;
    private String idCustomer;
    private double balance;

    public Wallet(String id, String idCustomer, double balance) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public double getBalance() {
        return balance;
    }
}
