
import java.util.concurrent.TimeUnit;


public class TestWaitNotify {

    public static void main(String[] args) throws Exception {
        BlockingQueue q = new BlockingQueue();

        Consumer c = new Consumer(q);
        new Thread(c).start();

        TimeUnit.MILLISECONDS.sleep(2000);

        Producer p = new Producer(q);
        new Thread(p).start();
    }
}

class BlockingQueue {

    public synchronized void write(String s) {
        n++;
        data = s;
        notifyAll(); // wake up any threads on waiting
    }

    public synchronized Object remove() {
        // wait until data is available: n > 0
        try {
            while (n == 0) {
                wait(); // yield to other threads while waiting for 'notify'
            }
        } catch (InterruptedException e) {
            System.out.println("Why do you wake me up too soon?");
        }

        Object o = this.data;
        data = null; // remove old data
        n--;
        return o; // return the removed data
    }
    
    private Object data = null;
    private int n = 0;
}

class Consumer implements Runnable {

    public Consumer(BlockingQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        System.out.println("At the consumer: " + q.remove());
    }
    BlockingQueue q;
}

class Producer implements Runnable {

    public Producer(BlockingQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        q.write("Hello from the producer!");
    }
    BlockingQueue q;
}
