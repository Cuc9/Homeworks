package smallTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by arpi on 07.09.2016.
 */
public class Prop {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("D:\\test\\prop.txt"));
        System.out.println(p);
        System.out.println("Password = " + p.get("password"));
        p.storeToXML(new FileOutputStream("D:\\test\\prop1.html"),"XXXX");
    }
}
