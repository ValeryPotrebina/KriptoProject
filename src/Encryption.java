import java.io.*;
import java.nio.charset.StandardCharsets;


public class Encryption {
    public static final String ALP = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final String EXTRA_SUMB = "!?,.;:\"' ";
    public static final String RUSSIAN_ALPHABET = ALP + ALP.toUpperCase() + EXTRA_SUMB;
    public static final String PATH = "c:\\1\\2.txt";
    public static final int COUNT_LETTERS = RUSSIAN_ALPHABET.length();


    //todo отдельный метод где будут спрашивать путь
    //todo сделать вывод ошибки, если путь введен неверное или файл не найден


    public static String messageEncrypt(int key, String path) throws IOException {
        //todo сделать все в файловой системе
        // зачем сохраняешь все в строку а потом выводишь в другой файл? Можно сразу шифроватьт и отправлять в файл. Исправить!
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
        char[] textArray = new char[fileInputStream.available()]; //<-todo исправить
        int letter, i = 0;
        while ((letter = reader.read()) != -1){
            textArray[i] = (char) letter;
            i++;
        }
        int oldIndex;
        int newIndex;
        StringBuilder result = new StringBuilder();
        int countOfLetters = RUSSIAN_ALPHABET.length();
        for (char l : textArray) {
            if (RUSSIAN_ALPHABET.indexOf(l) == -1){
                result.append(l);
            } else {
                oldIndex = RUSSIAN_ALPHABET.indexOf(l);
                newIndex = (oldIndex + key) % countOfLetters;
                result.append(RUSSIAN_ALPHABET.charAt(newIndex));
            }
        }
        return result.toString();
    }

}
