package Model;

public class Wallet {
    private String id;
    private String idCustomer;
    private double balance;

    public Wallet(String idCustomer, String id, double balance) {
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

    @Override
    public String toString() {
        return idCustomer + "-" + id + "-" + balance;
    }
}
