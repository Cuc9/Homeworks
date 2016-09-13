package lesson12.chat;

public class Main {
    public static void main(String[] args) throws Exception {
        Server s = new Server(5000);
        s.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            s.stop();
        }));
    }
}
