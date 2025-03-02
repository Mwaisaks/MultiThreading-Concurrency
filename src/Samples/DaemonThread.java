package Samples;

public class DaemonThread implements Runnable{
    @Override
    public void run() {
        System.out.println("This is a thread.");
    }

    public static void main(String[] args) {
        Thread daemonthread = new Thread(new DaemonThread());

        while (true){
            System.out.println("Daemon thread is running...");
        }
    }
}
