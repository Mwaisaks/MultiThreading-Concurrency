package Synchronisation.threadSafeCounter;

public class CounterDemo {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0;i < 1000;i++){
                counter.increment();;
                counter.toggleFlag();
            }
        }; //what does this block do, explain the logic here

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        System.out.println("Final count: " + counter.getCount());
        System.out.println("Final flag: " + counter.getFlag());
    }
}
