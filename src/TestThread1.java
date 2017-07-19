
import java.util.concurrent.TimeUnit;


public class TestThread1 {

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1("University of Central Oklahoma");
        MyThread1 t2 = new MyThread1("The Department of Computer Science");
        MyThread1 t3 = new MyThread1("Object Oriented Programming class");
        t1.start();
        t2.start();
        t3.start();
    }

}

class MyThread1 extends Thread {

    MyThread1(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for ( ; ; ) {
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
