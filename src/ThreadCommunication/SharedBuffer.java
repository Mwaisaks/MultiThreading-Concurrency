package ThreadCommunication;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity; //what does the finalkeyword do?

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == capacity){
            wait();
        }
        buffer.add(item);
        System.out.println("Produced: " + item);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()){
            wait();
        } //why do you choose to use while and not if else or any other relevant option?
        int item = buffer.poll();
        System.out.println("Consumed: " + item);
        notifyAll();
        return item;
    }
}
