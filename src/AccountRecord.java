public class AccountRecord {
    private int accountClient;
    private String clientFirstName;
    private String clientLastName;
    private double balance;

    public AccountRecord() {
        this(0, "", "", 0.0);
    }

    public AccountRecord(int account, String firstName, String lastName, double bal) {
        setAccount(account);
        setfirstName(firstName);
        setlastName(lastName);
        setbalance(bal);
    }

    public void setAccount(int account) {
        accountClient = account;
    }

    public int getAccount() {
        return accountClient;
    }

    public void setfirstName(String first) {
        clientFirstName = first;
    }

    public String getfirstName() {
        return clientFirstName;
    }

    public void setlastName(String last) {
        clientLastName = last;
    }

    public String getlastName() {
        return clientLastName;
    }

    public void setbalance(double bal) {
        balance = bal;
    }

    public double getbalance() {
        return balance;
    }
}
