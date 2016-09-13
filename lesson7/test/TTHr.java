package lesson7.test;

/**
 * Created by arpi on 29.04.2016.
 */
class TTHr extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread child start");
            Thread.sleep(5000);
            System.out.println("Thread child end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
