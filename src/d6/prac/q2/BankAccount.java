package d6.prac.q2;

public class BankAccount {
    private int balance;
    private String password;

    public BankAccount(String password) {
        this.balance = 0;
        this.password = password;
    }

    protected boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public int getBalance() {
        return balance;
    }

    public boolean deposit(int amount) {
        this.balance += amount;
        return true;
    }

    public boolean withdraw(int amount, String password) {
        if (!this.checkPassword(password) || this.balance < amount) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

}
