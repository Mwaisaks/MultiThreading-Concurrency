package Synchronisation;

public class BankDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Runnable depositTask = () -> {
            for (int i = 0; i < 5;i++){
                account.deposit(100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted!");
                }
            }
        };

        Runnable withDrawTask = () -> {
            for (int i = 0;i <5;i++){
                account.withdraw(150);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted!");
                }
            }
        };

        Thread depositThread = new Thread(depositTask);
        Thread withdrawThread = new Thread(withDrawTask);

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
