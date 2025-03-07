package ThreadCommunication.producerConsumerDemo;

public class ProducerConsumerDemo {

    public static void main(String[] args) {

        SharedBuffer buffer = new SharedBuffer(5);

        Runnable producer = () -> {
            try {
                for (int i = 0;i < 10;i++){
                    buffer.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted!");
            }
        };

        Runnable consumer = () -> {
            try {
                for (int i = 0; i < 10; i++){
                    buffer.consume();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer Interrupted!");
            }
        };

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
