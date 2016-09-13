package lesson8.test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by arpi on 28.05.2016.
 */
public class Runner implements Callable {
    List list;
    int start, end;
    CountDownLatch latch;
    Long startTime, endTime;

    public Runner(List list, int start, int end, CountDownLatch latch) {
        this.list = list;
        this.start = start;
        this.end = end;
        this.latch = latch;
    }

    @Override
    public Long call() throws Exception {
        try {
            latch.await();
            startTime = System.nanoTime();
        } catch (Exception e) {
        }
        for (int i = start; i < end; i++) {
            list.get(i);
        }
        return System.nanoTime() - startTime;
    }
}
