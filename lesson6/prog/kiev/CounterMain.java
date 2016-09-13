package lesson6.prog.kiev;

/**
 * Created by arpi on 20.02.2016.
 */
public class CounterMain {

        public static class Counter extends Thread {
            public void run() {
                int min = 1, max = 10;
                int x = min;
                while ( ! isInterrupted()) { // условие завершения потока №1
                    if (x > max){x = min;}
                    System.out.println(getId() + ": " + x++);
                    try {
                        Thread.sleep(1000); // закомментировать
                        //Thread.yield(); // или так
                    } catch (InterruptedException e) {
                        return; // условие завершения потока №2
                    }
                }
            }
        }
        public static void main(String[] args) {
            try {
                Counter c = new Counter();
                c.start(); // запускаем поток
                Thread.sleep(30000); // ждем 5 сек
                c.interrupt(); // прерываем поток
            } catch (Exception e) {
                ;
            }
        }

}
