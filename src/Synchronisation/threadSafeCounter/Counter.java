package Synchronisation.threadSafeCounter;

public class Counter {

    private int count = 0;
    private volatile boolean flag = false;

    public synchronized void increment(){
        count ++;
    }

    public synchronized int getCount(){
        return count; //why are we using synchronised keyword her, too much synchronisation makes the system lag no?
    }

    public void toggleFlag(){
        flag = !flag
    }
}
