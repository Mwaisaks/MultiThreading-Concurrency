package Samples;

public class SleepingThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Entering self-destruction mode in 5 seconds!");

        for (int i = 5;i > 0;i--){
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted!");
            }
        }

        System.out.println("Self-destruction complete!");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new SleepingThread());

        thread.start();

    }
}

//Good Practice: Use Thread.sleep() instead of thread.sleep() to make it clear that the current thread is sleeping.
