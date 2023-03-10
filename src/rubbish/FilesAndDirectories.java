package rubbish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FilesAndDirectories {
    private static final String START_PATH = "c:\\resDir";

    public static String makeDirName() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("ddMMM_HH.mm.ss", Locale.ENGLISH);
        String date = formatForDateNow.format(dateNow);
        return START_PATH.concat(date);
    }

    public static String createDirectory() {
        String directoryName = makeDirName();
        Path path = Paths.get(directoryName);
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
                System.out.println("New Directory created " + directoryName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Directory already exists");
        }
        return directoryName;
    }

    public static String makeFileName(String str) {
        String date = createDateFileName();
        return str + "\\BF" + date + ".txt";
    }

    public static String makeFileNameEncrypt(String str) {
        String date = createDateFileName();
        return str + "\\Encrypt" + date + ".txt";
    }

    public static String makeFileNameDecoded(String str) {
        String date = createDateFileName();
        return str + "\\Decoded" + date + ".txt";
    }

    public static String createFileBF(String str) {
        String fileName = makeFileName(str);
        return createFile(fileName);
    }

    public static String createFileEncrypted(String str) {
        String fileName = makeFileNameEncrypt(str);
        return createFile(fileName);
    }

    public static String createFileDecoded(String str) {
        String fileName = makeFileNameDecoded(str);
        return createFile(fileName);
    }

    private static String createDateFileName() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("SSS", Locale.ENGLISH);
        return formatForDateNow.format(dateNow);
    }

    private static String createFile(String fileName) {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                System.out.println("New File created " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("file already exists.");
        }
        return fileName;
    }
}
