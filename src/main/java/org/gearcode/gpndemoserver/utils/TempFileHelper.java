package org.gearcode.gpndemoserver.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class TempFileHelper {

    private static final String root = System.getProperty("user.home") + "/gpn-server-test/";

    public static File getFile(String name) {
        if (name == null) return null;
        if (!new File(root).exists()) {
            try {
                Files.createDirectory(Paths.get(root));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return new File(root + name);
    }

    public static void deleteFile(File file) throws IOException {
        if (file.isDirectory()) for (File c : Objects.requireNonNull(file.listFiles())) deleteFile(c);
        if (!file.delete()) throw new FileNotFoundException("Failed to delete file: " + file);
    }

}
