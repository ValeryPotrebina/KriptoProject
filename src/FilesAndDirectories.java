import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilesAndDirectories {
    public static final String START_PATH = "c:\\resultDirectory";
    public static String createDirectory(){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yy.MM.dd_HH.mm.ss");
        String date = formatForDateNow.format(dateNow);
        String directoryName = START_PATH.concat(date);
        Path path = Paths.get(directoryName);
        if (!Files.exists(path)){
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //сделать в свинге
            System.out.println("New Directory created " + directoryName);
        } else {
            //сделать в свинге
            System.out.println("Directory already exists");
        }
        return directoryName;
    }

    public static String createFile(String str){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yy.MM.dd_HH.mm.ss.SSS");
        String date = formatForDateNow.format(dateNow);
        String fileName = str + "\\resultFile" + date + ".txt";
        Path path = Paths.get(fileName);
        if (!Files.exists(path)){
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
