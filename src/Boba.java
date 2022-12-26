import java.io.IOException;
import java.util.Scanner;

public class Boba {

    public static void getInfo() throws IOException {
        //todo сделать вывод ошибки, если путь введен неверное или файл не найден
          Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите путь текстового файла, который хотите зашифровать: ");
//        String path = scanner.nextLine();
//        System.out.println("Введите ключ: ");
//        int key = scanner.nextInt();
//        String filePathEncryption = SendingFiles.sendEncryptMessage(Encryption.messageEncrypt(key, Encryption.read(path)));
//        SendingFiles.sendDecipherMessage(Decoding.messageDecipher(key, filePathEncryption)); //ошибка

        System.out.println("Введите путь файла, который хотите расшифровать методом brute forde");
        String pathBrute = scanner.nextLine();
        BruteForce.bruteForce(pathBrute);

        //Decoding.sendDecipherMessage(Decoding.messageDecipher(Encryption.COUNT_LETTERS - (key % Encryption.COUNT_LETTERS), Decoding.PATH));
    }
}
