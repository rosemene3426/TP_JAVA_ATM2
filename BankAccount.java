public class BankAccount {

    private int accountNumber;
    private double balance;

    // Initialisation du compte
    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }


    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " retrait " + amount + " €. Solde reste: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " : Solde insuffisant (" + balance + " €)");
        }
    }


    public synchronized double getBalance() {
        return balance;
    }

}
