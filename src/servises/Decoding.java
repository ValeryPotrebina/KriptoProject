package servises;

import servises.Encryption;
import java.io.IOException;

public class Decoding {
    public static String messageDecipher(int key, String path) throws IOException {
        key = Encryption.COUNT_LETTERS - (key % Encryption.COUNT_LETTERS);
        return Encryption.messageEncrypt(key, Encryption.read(path));
    }
}
