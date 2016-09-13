package lesson6.prog.kiev;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by arpi on 24.04.2016.
 */
public class CopierFixedBuf extends Thread {
    //private static Object monitor = new Object();
    private RandomAccessFile target;
    private RandomAccessFile dest;
    private int bufLength;


        public CopierFixedBuf(RandomAccessFile target, RandomAccessFile dest, int bufLength) {
            this.target = target;
            this.dest = dest;
            this.bufLength = bufLength;
        }

/*    public void copyData() throws IOException {
        byte[] buf = new byte[bufLength];
        target.seek(FileCopy.getPosition());
        target.read(buf);
        dest.seek(FileCopy.getPosition());
        dest.write(buf);
        FileCopy.setPosition(FileCopy.getPosition() + bufLength);
    }*/

        @Override
        public void run() {
            try {

                    System.out.println("I started");
                    FileCopy.copyData(target, dest, bufLength);
                    System.out.println("done");

/*            }catch (InterruptedException e){
                System.out.println("MY Interrupted happened");*/
            }catch (IOException e){
                System.out.println("MY IO happened in thread");
                e.printStackTrace();
            }

        }
}
