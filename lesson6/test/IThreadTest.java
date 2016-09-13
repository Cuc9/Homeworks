package lesson6.test;

/**
 * Created by arpi on 16.04.2016.
 */
public class IThreadTest implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
