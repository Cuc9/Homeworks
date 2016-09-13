package lesson7.test;

/**
 * Created by arpi on 29.04.2016.
 */
public class TRun implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Runnable start");
            Thread.sleep(5000);
            System.out.println("Runnable end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
