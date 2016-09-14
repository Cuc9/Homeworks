package lesson4.monitor;

import java.io.File;
import java.io.IOException;

public class Monitor {
    String folderPath;
    IFileEvent event;

    public Monitor(String folderPath, IFileEvent event) {
        this.folderPath = folderPath;
        this.event = event;
    }

    public void start(String folderPath) /*throws IOException, InterruptedException*/ {
        File f = new File(folderPath);
        File[] filesList;
        while (true) {
            if (f.exists() && f.isDirectory()) {
                if (event != null) {
                    //String[] fileNamesList = f.list();
                    filesList = f.listFiles();
                    try {
                        for (File elem : filesList) {
                            if (elem.getCanonicalPath().endsWith(".txt")) {
                                event.onAnyTxtAdded(elem.getCanonicalPath());
                                return;
                            }
                        }
                    } catch (IOException e) {e.printStackTrace();}
                }
            }

            try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {}

            System.out.println("Waiting...");
        }




       /* File f = new File(folderPath);
        Path folder;
        if (f.exists() && f.isDirectory()) {
            folder = Paths.get(folderPath);
            f = null;
        } else {
            System.out.println("Wrong Path: " + folderPath);
            return;
        }

        System.out.println("Watching path: " + folder);
        WatchService watchService = null;
        try {
            watchService = FileSystems.getDefault().newWatchService();
            folder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
            WatchKey key = null;

            while (true) {
                key = watchService.take();   //
                // Выбор событий из очереди
                WatchEvent.Kind<?> kind = null;
                for (WatchEvent watchEvent : key.pollEvents()) {
                    // Получение типа события
                    kind = watchEvent.kind();
                    if (StandardWatchEventKinds.OVERFLOW == kind) {
                        continue; //Продолжаем цикл
                    } else if (StandardWatchEventKinds.ENTRY_CREATE == kind) {
                        // Создался новый путь
                        Path newPath = ((WatchEvent<Path>) watchEvent).context();
                        // Выводим что создалось
                        System.out.println("New folder or file was created: " + newPath);
                    }
                }
                watchService.close();
                if (!key.reset()) {
                    break; //
                }
                System.out.println("Waiting...");
            }
        } catch (IOException|InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            try {
                watchService.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
}
