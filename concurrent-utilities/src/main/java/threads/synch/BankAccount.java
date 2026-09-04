package threads.synch;
class BankAccount {

    private double balance = 1000;

    public synchronized void withdraw(double amount) {

        if (balance >= amount) {
            balance -= amount;
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}