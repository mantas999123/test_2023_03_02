package data;

public class UserAccount {
    private String bankName;
    private String accountNumber;
    private double balance;

    public UserAccount() {
    }

    public UserAccount(String bankName, String accountNumber, double balance) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;

    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "bankName='" + bankName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
