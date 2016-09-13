package lesson11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    int port;
    Thread thread;

    public Server(int port) {
        this.port = port;
    }

    public void stop() {
        thread.interrupt();
    }

    public void start() throws IOException {
        thread = new Thread() {
            public void run() {
                try {
                    ServerSocket s = new ServerSocket(port);
                    while (!isInterrupted()) {
                        Socket c = s.accept();
                        try {
                            String msg = "Hello!!! MTHFCKR\r\n";
                            c.getOutputStream().write(msg.getBytes());
                        } finally {
                            c.close();
                        }
                    }
                    s.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}