
import java.util.concurrent.TimeUnit;


public class TestThread2 {

    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("University of Central Oklahoma");
        MyThread2 t2 = new MyThread2("Department of Computer Science");
        MyThread2 t3 = new MyThread2("Object Oriented Programming class");

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        Thread th3 = new Thread(t3);
        th1.start();
        th2.start();
        th3.start();
    }
}

class MyThread2 implements Runnable {

    public MyThread2(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (;;) {
            System.out.print(message);
            System.out.println();

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
            }
        }

    }

    private String message;

}
