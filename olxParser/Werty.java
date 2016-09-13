package olxParser;

/**
 * Created by arpi on 22.08.2016.
 */
public class Werty {
    public static void main(String[] args) {
        String old = "aaa";
        String snew = "bbb";

        old = snew;
        snew = "xxx";
        System.out.println(old);
        System.out.println(snew);
    }
}
