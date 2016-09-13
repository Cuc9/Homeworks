package lesson6.prog.kiev;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by arpi on 21.02.2016.
 */
public abstract class FileCopy {
    private static long position = 0;
    private static final int MAXTHREADS = 500;


    //private static File target = new File("d:\\test\\Better.Call.Saul.S01E01.1080p.rus.LostFilm.TV.mkv");
    private static File target = new File("d:\\test\\1.jpg");

    public synchronized  static long getPosition() {
        return position;
    }
    public synchronized static void setPosition(long position){
        FileCopy.position = position;
    }

    public static void copyData(RandomAccessFile target, RandomAccessFile dest, int bufLength) throws IOException {
        byte[] buf = new byte[bufLength];
        target.seek(FileCopy.getPosition());
        target.read(buf);
        dest.seek(FileCopy.getPosition());
        dest.write(buf);
        FileCopy.setPosition(FileCopy.getPosition() + bufLength);
    }

    /**
     * For copying with many threads
     */
    public static void main(String[] args) {
        String destName = target.getPath();
        String ext = destName.substring(destName.lastIndexOf('.'));
        destName = destName.replace(ext, "_copy" + ext);
        System.out.println("Creating copy: " + destName);
        File dest = new File(destName);
        int bufLength = 1;

        try (RandomAccessFile in = new RandomAccessFile(target, "r");
             RandomAccessFile out = new RandomAccessFile(dest, "rw")) {
            if (!dest.exists()){
                dest.createNewFile();
                System.out.println("File was created.");
            }
            int numberThreads=10;
           /* do {
                bufLength *=10;
                numberThreads = (int) Math.ceil((double)target.length()/bufLength);
            }while (numberThreads>MAXTHREADS);*/
            System.out.println(numberThreads + " threads will start.");
            for (int i = 0; i < numberThreads; i++) {
                CopierFixedBuf thread = new CopierFixedBuf(in,out,(int)target.length()/10);
                thread.start();
                //thread.copyData();
                //thread.wait();

                /*try {
                    thread.sleep(500);
                }catch (InterruptedException e){}*/

            }
            Thread.sleep(2000);
        } catch (InterruptedException e){
            System.out.println("My Interrupted");
        } catch (IOException e){
            System.out.println("My IOException");
        }


    }

    /**
     * For copying with progress one thread
     */
 /*   public static void main(String[] args) {
        Copy copier = new Copy(target);
        Thread copyThread = new Thread(copier);
        try {
            copyThread.start();
            copyThread.join();
        }catch (InterruptedException e){
            System.out.println("copyThread finished");
        }
    }*/
}
