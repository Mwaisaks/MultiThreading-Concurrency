package ThreadCommunication;

public class DeadLockDemo {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Runnable task1 = () -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 interrupted!");
                }
                System.out.println("Thread 1: Waiting fo lock 2...");
                synchronized (lock2){
                    System.out.println("Thread 1: Acquired lock 2!");
                }
            }
        };

        Runnable task2 = () -> {
            synchronized (lock2){
                System.out.println("Thread 2: holding lock 2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Thread 2 interrupted!");
                }
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (lock1){
                    System.out.println("Thread 2: Acquired lock 1!");
                }
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e){
            System.out.println("Main thread interrupted!");
        }

        System.out.println("Main thread finished.");
    }
}
