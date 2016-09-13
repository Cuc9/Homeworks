package lesson8.test;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by arpi on 28.05.2016.
 */
public class Producer implements Runnable {
    SynchronousQueue<Integer> queue;

    public Producer(SynchronousQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            try {
                System.out.println("Preparing info - " + i);
                Thread.sleep(r.nextInt(1000));
                System.out.println("Putting info - " + i);
                queue.put(i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
