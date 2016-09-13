package lesson4.monitor;

import java.nio.file.Path;

public class FileEvent implements IFileEvent {
    @Override
    public void onFileAdded(String s) {
        System.out.println("File added: " + s);
    }

    @Override
    public void onFilesAdded() {
        System.out.println("All files were added!");
    }

    @Override
    public void onAnyTxtAdded(String fPath) {
        System.out.println("TXT file was added! - " + fPath);
    }
}
