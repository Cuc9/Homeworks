package fileNamesRandomizator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by arpi on 13.04.2016.
 */
public class FileNamesRandomizator {
    private File catalog;
    private File catalogCopy;
    private List<Integer> namesGenerated;

    public FileNamesRandomizator(String path, String pathForCopy) throws IOException {
        this.catalog = new File(path);
        if (!catalog.exists() || !catalog.isDirectory()) {
            throw new IOException("Wrong catalog name.");
        }
        this.catalogCopy = new File(pathForCopy);
        if (!catalogCopy.mkdir()) {
            throw new IOException("Can not create copy catalog.");
        }
        namesGenerated = new ArrayList<>();
    }

    private String getRandom(int quantity) {
        Random rand = new Random();
        boolean unique = false;
        Integer name;
        do {
            name = rand.nextInt(quantity) + 1;
            if (!namesGenerated.contains(name)) {
                unique = true;
                namesGenerated.add(name);
            }
        } while (!unique);
        return name.toString();
    }

    private String pathConstructor(File src, int quantity) throws IOException {
        String name = src.getCanonicalPath();
        int toExtension = name.lastIndexOf(".");
        name = catalogCopy.getCanonicalPath() + "\\" + getRandom(quantity) + name.substring(toExtension);
        return name;
    }

    private void copyAndRandomizeDirectory() throws IOException {
        File[] fileList = catalog.listFiles();
        if (fileList != null) {
            for (File f : fileList) {
                Files.copy(Paths.get(f.getCanonicalPath()), Paths.get(pathConstructor(f, fileList.length)));
            }
        }
    }

    public static void main(String[] args) {
        try {
            FileNamesRandomizator randomizer = new FileNamesRandomizator("d:\\Cuc9\\123", "d:\\Cuc9\\123_copy");
            randomizer.copyAndRandomizeDirectory();
            System.out.println("Job is done.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}