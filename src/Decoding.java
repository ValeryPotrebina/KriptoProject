import java.io.IOException;


public class Decoding {

    public static String messageDecipher(int key, String path) throws IOException {   //3 (25) key = (countAlp - (key & countAlp)
        key = Encryption.COUNT_LETTERS - (key % Encryption.COUNT_LETTERS);
        return Encryption.messageEncrypt(key, path);
    }

}
