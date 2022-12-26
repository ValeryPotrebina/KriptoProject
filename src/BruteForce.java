import java.io.*;
import java.util.ArrayList;


public class BruteForce extends TextAnalyz{
    public static final String PUNC_SUNB = ",:;.!?\"'";
    private static final String SPACE_SEPARATION = " ";
    static ArrayList<Word> words;

    public static void main(String[] args) throws IOException {

    }

    public static void bruteForce(String path) throws IOException {
        for (int i = 0; i < Encryption.RUSSIAN_ALPHABET.length(); i++) {
            String text = Encryption.messageEncrypt(i, Encryption.read(path));
            if (checkIsWordsCorrect(text)){
                SendingFiles.sendBruteForceMessage(text);
                return;
            }
        }
    }

    private static boolean checkIsWordsCorrect(String text){
        boolean flag = true;
        if (!checkNotNullText(text))
            return false;
        ArrayList<Word> words = splitTextOnWord(text);
        if (!checkFirstLetterNotForbiddenLetter(words))
            return false;
        if (!checkNotMoreTTLettersInWord(words))
            return false;
        if (!checkNotMoreFourConsonants(words))
            return false;
        if (!checkNotMoreFourVowels(words))
            return false;
        if (!checkNotFirstLetterSmall(words))
            return false;
        return flag;
    }

    private static ArrayList<Word> splitTextOnWord(String text){
        text = revoveAllPuncSymb(text);
        String[] rawWords = text.split(SPACE_SEPARATION);
        words = new ArrayList<>(rawWords.length);
        for (String rawWord : rawWords) {
            Word word = new Word(rawWord);
            words.add(word);
        }
        return removeEmptyWords(words);
    }
    private static String revoveAllPuncSymb(String text){
        boolean flag = true;
        char[] textArray = text.toCharArray();
        char[] pyncSymb = PUNC_SUNB.toCharArray();
        StringBuilder textWithoutPuncSumb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            for (char c : pyncSymb) {
                if (textArray[i] == c) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                textWithoutPuncSumb.append(textArray[i]);
            }
            flag = true;
        }
        return textWithoutPuncSumb.toString();
    }

}
