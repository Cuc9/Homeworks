package olxParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by arpi on 07.08.2016.
 */
public class OlxParser {
    private final String ADDRESS = "http://olx.ua/nedvizhimost/arenda-kvartir/dolgosrochnaya-arenda-kvartir/kiev/?search%5Bfilter_float_price%3Ato%5D=6000&search%5Bfilter_float_price%3Afrom%5D=4000&search%5Bfilter_float_number_of_rooms%3Afrom%5D=2&search%5Bfilter_float_number_of_rooms%3Ato%5D=2&search%5Bprivate_business%5D=private";
    StringBuilder oldPage, newPage;

    private StringBuilder getPage() {
        StringBuilder sb = new StringBuilder("123");
        try {
            URL url = new URL(ADDRESS);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()))) {
                char[] buf = new char[1001];
                int r;
                do {
                    if ((r = br.read(buf)) > 0)
                        sb.append(new String(buf, 0, r));
                } while (r > 0);
                return sb;
            }
        } catch (IOException e) {
            System.out.println("getInquiry crashed");
            return sb;
        }
    }

    boolean isEquals(StringBuilder oldPage, StringBuilder newPage) {
        boolean flag = oldPage.toString().equals(newPage.toString());
        this.oldPage = newPage;
        return flag;
    }

    public static void main(String[] args) {
        OlxParser olxParser = new OlxParser();
        olxParser.oldPage = olxParser.getPage();

        for (int i = 0; i < 4; i++) {
            File searchPage = new File("d:\\" + i + ".html");
            try (PrintWriter pw = new PrintWriter(searchPage)) {
                pw.write(olxParser.oldPage.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                olxParser.newPage = olxParser.getPage();
                System.out.println(olxParser.isEquals(olxParser.oldPage, olxParser.newPage));
        }
        /*File searchPage = new File("d:\\searchPage.html");
        try (PrintWriter pw = new PrintWriter(searchPage)) {
            pw.write(olxParser.oldPage.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            olxParser.newPage = olxParser.getPage();
            System.out.println(olxParser.isEquals(olxParser.oldPage, olxParser.newPage));
        }*/
    }
}
