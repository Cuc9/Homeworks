package lesson6.test;

/**
 * Created by arpi on 16.04.2016.
 */
public class Test {




    public static void main(String[] args) {
        Test test = new Test();
        ThreadGroup tg = new ThreadGroup("my");

        for (int i = 0; i < 10 ; i++) {
           Thread t = new ThreadTest();
        }

        for (int i = 0; i < 10 ; i++) {
            Thread t1 = new Thread(tg, new IThreadTest(), "Thread-" + i);
        }
    }
}
