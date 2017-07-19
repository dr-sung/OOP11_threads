
import java.util.concurrent.TimeUnit;


public class TestJoin {

    public static void main(String[] args) {

        MyThread3 t = new MyThread3();
        t.start();

        try { // join() waits until the thread is done.
            t.join();
        } catch (InterruptedException ex) {
        }

        System.out.println("main thread ends.");

    }
}

class MyThread3 extends Thread {

    @Override
    public void run() {
        System.out.println("A new thread begins ...");

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println("The new thread ends.");
    }
}
