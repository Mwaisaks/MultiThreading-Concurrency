package Samples;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread is running!");
    }

    public static void main(String[] args) {
        Thread runnable = new Thread(new MyRunnable());

        runnable.start();
    }
}
