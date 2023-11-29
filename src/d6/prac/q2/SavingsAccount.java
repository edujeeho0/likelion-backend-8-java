package d6.prac.q2;

public class SavingsAccount extends BankAccount {
    private int round;
    private int targetRound;
    private int depositAmount;

    public SavingsAccount(String password) {
        super(password);
    }

    @Override
    public boolean deposit(int amount) {
        if (amount != depositAmount)
            return false;
        this.round++;
        return super.deposit(amount);
    }

    @Override
    public boolean withdraw(int amount, String password) {
        if (this.round < this.targetRound)
            return false;
        return super.withdraw(amount, password);
    }
}
