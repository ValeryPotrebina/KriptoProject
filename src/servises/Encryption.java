package servises;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Encryption {
    public static final String ALP = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final String EXTRA_SUMB = ";:\"', .!?";
    public static final String RUSSIAN_ALPHABET = ALP + ALP.toUpperCase() + EXTRA_SUMB;
    public static final int COUNT_LETTERS = RUSSIAN_ALPHABET.length();

    public static char[] read(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
        char[] textArray = new char[fileInputStream.available()];
        int letter, i = 0;
        while ((letter = reader.read()) != -1) {
            textArray[i] = (char) letter;
            i++;
        }
        textArray = Arrays.copyOfRange(textArray, 0, i);
        return textArray;
    }


    public static String messageEncrypt(int key, char[] textArray) {
        int oldIndex;
        int newIndex;
        StringBuilder result = new StringBuilder();
        int countOfLetters = RUSSIAN_ALPHABET.length();
        for (char l : textArray) {
            if (RUSSIAN_ALPHABET.indexOf(l) == -1) {
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
