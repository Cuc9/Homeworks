package lesson8.test;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by arpi on 28.05.2016.
 */
public class Consumer implements Runnable {
    SynchronousQueue<Integer> queue;

    public Consumer(SynchronousQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            int i=0;
            do {
                System.out.println("Waiting for info");
                i = queue.take();
                System.out.println("I took " + i);
                Thread.sleep(r.nextInt(1000));
            }while (i<5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}