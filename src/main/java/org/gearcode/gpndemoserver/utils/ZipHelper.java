package org.gearcode.gpndemoserver.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipHelper {

    public static File getZipFile(String data) throws IOException {
        String textUUID = UUID.randomUUID().toString();
        File textFile = TempFileHelper.getFile(textUUID);
        try (PrintWriter writer = new PrintWriter(textFile, StandardCharsets.UTF_8)) {
            writer.println(data);
            writer.flush();

            String zipUUID = UUID.randomUUID().toString();
            File zipFile = TempFileHelper.getFile(zipUUID);
            ZipHelper.zip(textFile, zipFile);
            return zipFile;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            TempFileHelper.deleteFile(textFile);
        }
        return null;
    }

    private static void zip(File temp, File zip) throws IOException {
        try (FileInputStream in = new FileInputStream(temp);
             ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip))) {
            out.putNextEntry(new ZipEntry("data.txt"));
            byte[] b = new byte[1024];
            int count;
            while ((count = in.read(b)) > 0) out.write(b, 0, count);
        }
    }

}
