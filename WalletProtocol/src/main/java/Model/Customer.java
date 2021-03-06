package Model;

public class Customer {
    private String firstname, lastname;
    private String id;
    private String password;

    public Customer(String firstname, String lastname, String id, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
