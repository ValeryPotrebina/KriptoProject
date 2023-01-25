package servises;

import models.Word;
import java.util.ArrayList;

public class TextAnalyz {
    private static final String CONSONANTS = "бвгджзйклмнпрстфхцчшщ";
    private static final String VOWELS = "аеёиоуыэюя";

    /**
     * Проверка, что текст не пустой
     */
    protected static Boolean checkNotNullText(String text) { //проверка, что текст не пустой
        return text.length() > 0;
    }

    /**
     * удаление пустых слов
     */
    protected static ArrayList<Word> removeEmptyWords(ArrayList<Word> words) {
        words.removeIf(word -> word.toString().length() == 0);
        return words;
    }

    /**
     * Проверка, что первая буква не является недопустимой
     */
    protected static Boolean checkFirstLetterNotForbiddenLetter(ArrayList<Word> words) {
        boolean flag = true;
        for (Word word : words) {
            char firstLetter = word.toString().charAt(0);
            switch (firstLetter) {
                case 'ы', 'ь', 'ъ', '.', ' ', '!', ',', ':', ';', '?', 'Ы' -> {
                    return false;
                }
            }
        }
        return flag;
    }

    /**
     * Проверка, что в слове не больше 22 букв
     */
    protected static boolean checkNotMoreTTLettersInWord(ArrayList<Word> words) {
        for (Word word : words) {
            if (word.letterCounter() > 22) return false;
        }
        return true;
    }

    /**
     * Слова не могут чередоваться (большая - маленькая)
     */
    protected static boolean checkNotFirstLetterSmall(ArrayList<Word> words) {
        boolean flag = true;
        for (Word word : words) {
            for (int i = 1; i < word.toString().length(); i++) { //todo
                if (!Character.isLowerCase(word.toString().charAt(i)))
                    return false;
            }
        }
        return flag;
    }

    /**
     * Проверка, что в слове не больше 4 согласных
     */
    protected static boolean checkNotMoreFourConsonants(ArrayList<Word> words) {
        boolean flag = true;
        for (Word word : words) {
            for (int i = 0; i < word.letterCounter() - 3; i++) {
                if (isConsonants(word.toString().charAt(i)) &&
                        isConsonants(word.toString().charAt(i + 1)) &&
                        isConsonants(word.toString().charAt(i + 2)) &&
                        isConsonants(word.toString().charAt(i + 3))) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static boolean isConsonants(char ch) {
        boolean flag = false;
        char[] cons = CONSONANTS.toCharArray();
        for (char con : cons) {
            if (ch == con) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * Проверка, что в слове не больше 4 гласных
     */
    protected static boolean checkNotMoreFourVowels(ArrayList<Word> words) {
        boolean flag = true;
        for (Word word : words) {
            for (int i = 0; i < word.letterCounter() - 3; i++) {
                if (isVoweels(word.toString().charAt(i)) &&
                        isVoweels(word.toString().charAt(i + 1)) &&
                        isVoweels(word.toString().charAt(i + 2)) &&
                        isVoweels(word.toString().charAt(i + 3))) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static boolean isVoweels(char ch) {
        boolean flag = false;
        char[] cons = VOWELS.toCharArray();
        for (char con : cons) {
            if (ch == con) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
