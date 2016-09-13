package lesson11;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by arpi on 14.07.2016.
 */
public class DNS {
    public static void main(String[] args) {
        final String hostName = "javarush.ru";
        try {
            InetAddress ipAdress = InetAddress.getByName(hostName);
            System.out.println("IP is: " + ipAdress.getHostAddress());
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
