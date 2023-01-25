package servises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SendingFiles {
    static final String directoryPath = FilesAndDirectories.createDirectory();

    public static String sendEncryptMessage(String encodedMessage) throws IOException {
        String filePathEncryption = FilesAndDirectories.createFileEncrypted(directoryPath);
        Path resultFile = Paths.get(filePathEncryption);
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile.toFile()));
        char[] resultArray = encodedMessage.toCharArray();
        writer.write(resultArray, 0, resultArray.length);
        writer.flush();
        System.out.println("Ваш текст успешно зашифрован и передан в файл: " + resultFile);
        return filePathEncryption; //Можно не возвращать (переделать)
    }

    public static String sendDecipherMessage(String decodingMessage) throws IOException {
        String filePathDecoding = FilesAndDirectories.createFileDecoded(directoryPath);
        Path resultFile = Paths.get(filePathDecoding);
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile.toFile()));
        char[] resultArray = decodingMessage.toCharArray();
        writer.write(resultArray, 0, resultArray.length);
        writer.flush();
        System.out.println("Ваш текст успешно расшифрован и передан в файл: " + resultFile);
        return filePathDecoding;
    }

    public static String sendBruteForceMessage(String bruteForce) throws IOException {
        String filePathBriteForce = FilesAndDirectories.createFileBF(directoryPath);
        Path resultFile = Paths.get(filePathBriteForce);
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile.toFile()));
        char[] resultArray = bruteForce.toCharArray();
        writer.write(resultArray, 0, resultArray.length);
        writer.flush();
        System.out.println("Ваш текст успешно зашифрован методом brute force и передан в файл: " + resultFile);
        return filePathBriteForce; //Можно не возвращать (переделать)
    }

}
