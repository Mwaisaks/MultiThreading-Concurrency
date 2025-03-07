package ThreadCommunication.Sample1;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5);

        Runnable producer = () -> {
            try {
                for (int i = 0; i < 10;i++){
                    buffer.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("Producer Interrupted!");
            }
        };

        Runnable consumer = () -> {
            try {
                for (int i = 0;i < 10;i++){
                    buffer.consume();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted!");
            }
        };

        Thread producerThread1 = new Thread(producer);
        Thread producerThread2 = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer);
        Thread consumerThread2 = new Thread(consumer);

        producerThread1.start();
        producerThread2.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}
