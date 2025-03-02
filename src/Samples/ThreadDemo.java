package Samples;

public class ThreadDemo {

    static class Task implements Runnable{ //why is the class static
        private String name;

        public Task(String name) {
            this.name = name;
        } //why are we creating a constructor

        @Override
        public void run() {
            System.out.println(name + " is running with priority: " +
                    Thread.currentThread().getPriority());
            try {
                Thread.sleep((long) (Math.random() * 1000)); //can we specify the range of the random time
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted!");
            }
            System.out.println(name + " has finished.");
        }
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Task("Thread 1"));
        thread1.start();

        Thread daemonThread = new Thread(new Task("Daemon Thread"));
        daemonThread.setDaemon(true);
        daemonThread.start();

        //Thread States
        Thread thread2 = new Thread(new Task ("Thread 2"));
        System.out.println("Thread 2 state: " + thread2.getState());
        thread2.start();
        System.out.println("Thread 2 state: " + thread2.getState());
        try {
            thread2.sleep(1000);
            System.out.println("Thread 2 state: " + thread2.getState());
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
        }

        System.out.println("Is thread 2 alive? " + thread2.isAlive());

        Thread thread3 = new Thread(new Task("Thread 3"));
        Thread thread4 = new Thread(new Task("Thread 4"));
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread4.setPriority(Thread.MIN_PRIORITY);

        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Something happened!");
        }

        System.out.println("All threads have finished.");
    }
}
