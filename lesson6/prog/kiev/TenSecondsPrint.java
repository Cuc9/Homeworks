package lesson6.prog.kiev;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by arpi on 20.02.2016.
 */
public class TenSecondsPrint {

    /**
     * RUN for time printing thread
     */
   /* private static class SecondsPrinter implements Runnable {
        @Override
        public void run() {
            SimpleDateFormat time = new SimpleDateFormat("HH.mm.ss");
            do {
                System.out.println("Time is: " + time.format(new Date()));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    return;
                }
            } while (true);
        }
    }*/

    /**
     * Parent thread, creates 10 threads and kill them.
     * After each kill shows how many threads left
     */
    private static class Parent implements Runnable {
        @Override
        public void run() {
            ThreadGroup tg = new ThreadGroup("Fifty");
            int threadCount = 10;
            Thread[] threads = new Thread[threadCount];
            int tNumber;
            try {
                for (int i = 1; i <= threadCount; i++) {
                    threads[i - 1] = new NumberedThread(tg, "Thread - " + i);
                    threads[i - 1].start();
                    Thread.sleep(50);
                }
                tg.setDaemon(true);

                Scanner in = new Scanner(System.in);
                do {
                    Thread.sleep(100);
                    System.out.println("Now " + tg.activeCount() + " threads are active.");
                    tg.list();
                    System.out.print("Enter number of stream you want to interrupt: ");
                    if (in.hasNextInt()) {
                        tNumber = in.nextInt();
                        if (tNumber < 1 || tNumber > threads.length) continue;
                        boolean flag = threads[tNumber - 1].isAlive();
                        if (!flag) {
                            System.out.println(threads[tNumber - 1].getName() + " is already " + threads[tNumber - 1].getState());
                            continue;
                        }
                        threads[tNumber - 1].interrupt();
                        threads[tNumber - 1].join();
                        tg.list();
                        //System.out.println(tgArr[tNumber - 1].getState());
                        if (tg.activeCount() < 1){
                            tg.interrupt();
                            return;
                        }
                    } else if (in.nextLine().equals("all")) {
                        tg.interrupt();
                        return;
                    }
                } while (true);

            } catch (InterruptedException e) {
                tg.interrupt();
            }
        }



    /*    @Override
        public void run() {
            Thread[] threads = new Thread[50];
            try {
                for (int i = 0; i < threads.length; i++) {
                    threads[i] = new Thread(new NumberedThread());
                    threads[i].start();
                    Thread.sleep(200);
                }
                Thread.sleep(2000);
                for (Thread elem : threads) {
                    elem.interrupt();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                for (Thread elem : threads) {
                    elem.interrupt();
                }
            }
        }*/
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * Thread prints time and wait for pressing Enter (to console)
         */
        /*Scanner in = new Scanner(System.in);
        Thread spThread = new Thread(new SecondsPrinter());
        System.out.println("Press Enter to stop thread.");
        spThread.start();
        if (in.hasNextLine()){
            spThread.interrupt();
        }*/

        /**
         * Create 100 threads. They print their number and wait to be interrupted
         */
        /*Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new NumberedThread());
            threads[i].start();
        }
        Thread.sleep(500);
        System.out.println("Now I will kill them all !!!");
        for (Thread elem:threads) {
            elem.interrupt();
        }
        Thread.sleep(500);
        System.out.println("Work is done!");*/

        /**
         * Create thread wich will create 50 threads. They print their number and wait to be interrupted.
         * Parent thread interrupts its children
         */
        Thread parent = new Thread(new Parent());
        parent.start();
        parent.join();
        Thread.sleep(500);
        System.out.println("Work is done!");
    }
}
