package lesson7.manyThreadsToOne;

import java.io.*;

/**
 * Created by arpi on 26.04.2016.
 */
public class ReadWriteThread implements Runnable {

    private File src;
    private File dest;
    
    public ReadWriteThread (File src, File dest){
        this.src = src;
        this.dest = dest;
    }

    @Override
    public void run() {
        byte [] buf = new byte[256];
        try (InputStream in = new FileInputStream(src);
             RandomAccessFile out = new RandomAccessFile(dest,"rw"))
        {
            synchronized (dest){
                while (in.read(buf)>0){
                    out.seek(out.length());
                    out.write(buf);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished job.");
    }
}
