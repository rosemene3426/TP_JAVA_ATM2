import java.util.Random;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the
public class Main {
    public static void main(String[] args) {
        double v = 1000.0;



       BankAccount MyAccount = new BankAccount(12345, 1000.0);

        Random rand = new Random();


        for (int i = 1; i <= 10; i++) {
            final int idClient = i;

            Thread t = new Thread(() -> {
                for (int j = 1; j <= 5; j++) {
                    try {

                        int action = rand.nextInt(3);
                        double montant = 20 + (rand.nextDouble() * 80);

                        if (action == 0) {
                            MyAccount.deposit(montant);
                            System.out.println("Client " + idClient + " DEPOSER: " + String.format("%.2f", montant) + " €");
                        } else if (action == 1) {
                            MyAccount.withdraw(montant);

                        } else {
                            System.out.println("Client " + idClient + " VERIFIER SOLDE: " + String.format("%.2f", MyAccount.getBalance()) + " €");
                        }

                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"Thread--Client" + i);

            t.start();
        }
    }
    }
