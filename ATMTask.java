public class ATMTask implements Runnable{


    public enum Action { DEPOSIT, WITHDRAW, BALANCE }

    private BankAccount account;
    private Action action;
    private double amount;

    public ATMTask(BankAccount account, Action action, double amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }
    @Override
    public void run() {

        switch (action) {
            case DEPOSIT:
                account.deposit(amount); //
                break;
            case WITHDRAW:
                account.withdraw(amount); //
                break;
            case BALANCE:
                System.out.println("Solde actuel : " + account.getBalance() + " €"); //
                break;
        }
    }
}
