package lesson11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by arpi on 15.07.2016.
 */
public class TestHttp {


    public static void main(String[] args) throws Exception {
        URL url = new URL("http://prog.kiev.ua");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()))) {
            char[] buf = new char[1000];
            StringBuilder sb = new StringBuilder();
            int r;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
            System.out.println(sb.toString());
        }
        System.out.println("END");
    }
}
