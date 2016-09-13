package lesson6.prog.kiev;

import java.io.*;

/**
 * Created by arpi on 21.02.2016.
 */
public class Copy implements Runnable {
    private File target;
    private long progress = 0;

    public Copy(File target) {
        this.target = target;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        String destName = target.getPath();
        String ext = destName.substring(destName.lastIndexOf('.'));
        destName = destName.replace(ext, "_copy" + ext);
        System.out.println(destName);
        File dest = new File(destName);
        Thread proc = new Thread(new CopyProgress());
        proc.setDaemon(true);
        proc.start();
        /*System.out.printf("%.2f",target.length()/Math.pow(1024,2));
        System.out.print(" M bytes");*/
        //Thread
        try (
                InputStream in = new FileInputStream(target);
                BufferedInputStream inBuf = new BufferedInputStream(in);
                OutputStream out = new FileOutputStream(dest);
                BufferedOutputStream outBuf = new BufferedOutputStream(out);) {
            byte[] buf = new byte[1024];
            int r;
            long ready = 0;
            do {
                r = inBuf.read(buf, 0, buf.length);
                if (r > 0) {
                    outBuf.write(buf, 0, buf.length);
                }
                ready += r;
                progress = ready * 100 / target.length();
            } while (r > 0);
            progress = 100;
        } catch (IOException e) {
            System.out.println("IOException");
        }
        System.out.println("Thread finished in: " + (System.currentTimeMillis() - startTime) / 1000 + " seconds.");
    }

    private class CopyProgress implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted() || progress < 100) {
                    Thread.sleep(100);
                    System.out.printf("Copied %d%%\r", progress);
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }



}
