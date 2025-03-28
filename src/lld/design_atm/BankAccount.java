package lld.design_atm;

public class BankAccount {
    int balance;

    public void withdraw(int amount) {
        // perform check on balance and then deduct the amount
        balance -= amount;
    }

}
