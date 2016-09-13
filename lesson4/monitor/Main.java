package lesson4.monitor;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //Monitor m = new Monitor("c:\\1.txt", (s) -> System.out.println("File added: " + s));
        //String[] ss = {"c:\\1.txt", "c:\\2.txt", "c:\\3.txt", "c:\\4.txt"};


            try {
                File f = new File("d:\\");
                //String[] list1 = f.list();
                File[] list2 = f.listFiles();
               // for (String s : list1)
                 //   System.out.println(s);
                for (File t : list2)
                    System.out.println(t.getCanonicalPath());
                //list2[0].delete(); // удалить файл
                //long sz = list2[1].length(); // размер файла
                //long date = f.lastModified();
                //boolean b = f.isDirectory();
                //new File("d:\\test").mkdir(); // создать пустой каталог
                //new File("d:\\test\\1\\2\\3\\4").mkdirs(); // создать каталоги
            } catch (Exception ex) {}
        Monitor m = new Monitor("d:\\", new FileEvent());
        m.start("d:\\");
    }
}