import java.io.IOException;
import java.util.Scanner;

public class Boba {

    public static void getInfo() throws IOException {
        //todo сделать вывод ошибки, если путь введен неверное или файл не найден
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь текстового файла, который хотите зашифровать: ");
        String path = scanner.nextLine();
        System.out.println("Введите ключ: ");
        int key = scanner.nextInt();
        String filePathEncryption = NEEBY.sendEncryptMessage(Encryption.messageEncrypt(key, path));
        String filePathDecoding = NEEBY.sendDecipherMessage(Decoding.messageDecipher(key, filePathEncryption)); //ошибка
       // Decoding.sendDecipherMessage(Decoding.messageDecipher(Encryption.COUNT_LETTERS - (key % Encryption.COUNT_LETTERS), Decoding.PATH));
    }
}