package lesson6.prog.kiev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by arpi on 21.02.2016.
 */
public class Copier extends Thread {
    private RandomAccessFile target;
    private RandomAccessFile dest;

    public Copier(RandomAccessFile target, RandomAccessFile dest) {
        this.target = target;
        this.dest = dest;
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            int r;
            do {
                target.seek(FileCopy.getPosition());
                r = target.read(buf);
                dest.seek(FileCopy.getPosition());

                //r = target.read(buf,FileCopy.getPosition(),buf.length);
            }while (r > 0);
        }catch (IOException e){
            System.out.println("OI happened in Copier thread");
        }
    }
}
