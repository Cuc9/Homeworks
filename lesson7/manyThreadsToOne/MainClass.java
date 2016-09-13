package lesson7.manyThreadsToOne;

import java.io.File;
import java.io.IOException;

/**
 * Created by arpi on 26.04.2016.
 */
public class MainClass {
    public static void main(String[] args) {
        File dest = new File("d:\\test\\dest.txt");
        File src1 = new File("d:\\test\\1.txt");
        File src2 = new File("d:\\test\\2.txt");
        File src3 = new File("d:\\test\\3.txt");
        try {
            if (!dest.exists()){dest.createNewFile();}
        }catch (IOException e){
            e.printStackTrace();
        }

        Thread t1 = new Thread(new ReadWriteThread(src1,dest));
        t1.start();
        Thread t2 = new Thread(new ReadWriteThread(src2,dest));
        t2.start();
        Thread t3 = new Thread(new ReadWriteThread(src3,dest));
        t3.start();

    }
}
