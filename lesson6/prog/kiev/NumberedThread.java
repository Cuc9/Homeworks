package lesson6.prog.kiev;

/**
 * Created by arpi on 20.02.2016.
 */
public class NumberedThread  extends Thread implements Runnable {
    private static int number = 1;
    private int threadNumber;

    public NumberedThread() {
        threadNumber = number++;
    }

    public NumberedThread (ThreadGroup tg, String name){
        super(tg,name);
        threadNumber = number++;
    }

    @Override
    public void run() {
        System.out.println("Thread-" + threadNumber);
        while (!isInterrupted()){
            try {
                Thread.sleep(1000);
                //Thread.yield();
            }catch (Exception e){
                System.out.println("Thread-" + threadNumber + " was interrupted. Bye Bye!");
                return;
            }
        }
        //System.out.println(super.getName() + " was interrupted. Bye Bye!");
    }

}
