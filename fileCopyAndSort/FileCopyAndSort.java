package fileCopyAndSort;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arpi on 12.04.2016.
 */

public class FileCopyAndSort {

   /* private static class StrComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }*/

    private static String getDestPath (String srcPath){
        int i = srcPath.lastIndexOf(".");
        String ext = srcPath.substring(i);
        return srcPath.replace(ext,"_copy" + ext);
    }

    public void copyAndSort (String srcPath) throws IOException {
        File src = new File(srcPath);
        File dest = new File(getDestPath(srcPath));
        List<String> list = new ArrayList<>();
        String line;

        if (!src.exists() || !src.isFile()){
            throw new IOException("Source file does not exist.");
        }
        if (!dest.exists()) {
            dest.createNewFile();
        }


        try (Reader reader = new FileReader(src);
             Writer writer = new FileWriter(dest);
             BufferedReader br = new BufferedReader(reader);
             BufferedWriter bw = new BufferedWriter(writer)
        ) {
            //reading file
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            //Sorting
            list.sort((o1,o2) -> o1.compareTo(o2));
            //Or with comparator
            /*list.sort(new StrComparator());*/

            //Making file copy with sorted data
            for (String elem : list) {
                System.out.println(elem);
                bw.write(elem + "\r\n");
            }
            System.out.println("done!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        FileCopyAndSort copier = new FileCopyAndSort();
        try {
            copier.copyAndSort("D:\\test\\3.txt");
            //Next a little practice with Files and Paths
            //Files.copy(Paths.get("d:\\test\\1.jpg"), Paths.get("d:\\test\\1_copy.jpg"));
            //????????   Files.createLink(Paths.get("d:\\test\\linkOn1.jpg"),Paths.get("d:\\test\\1.jpg"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}