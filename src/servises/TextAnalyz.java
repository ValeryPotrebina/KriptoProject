package servises;

import models.Sentence;
import models.Word;

import java.util.*;

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
                case 'ы', 'ь', 'ъ', '.', ' ', '!', ',', ':', ';', '?', 'Ы', 'Ъ', 'Ь': {
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
            for (int i = 0; i < word.letterCounter() - 4; i++) {
                if (isConsonants(word.toString().charAt(i)) &&
                        isConsonants(word.toString().charAt(i + 1)) &&
                        isConsonants(word.toString().charAt(i + 2)) &&
                        isConsonants(word.toString().charAt(i + 3)) &&
                        isConsonants(word.toString().charAt(i + 4))) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean isConsonants(char ch) {
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
            for (int i = 0; i < word.letterCounter() - 4; i++) {
                if (isVoweels(word.toString().charAt(i)) &&
                        isVoweels(word.toString().charAt(i + 1)) &&
                        isVoweels(word.toString().charAt(i + 2)) &&
                        isVoweels(word.toString().charAt(i + 3)) &&
                        isVoweels(word.toString().charAt(i + 4))) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean isVoweels(char ch) {
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

    /**
     * количество букв
     */
    protected static Map<Character, Long> getCountEachLetter(String text) {
        Map<Character, Long> letterAndCounts = new HashMap<>();
        char[] letters = text.toCharArray();
        for (char letter : letters) {
            if (!letterAndCounts.containsKey(letter)) {
                letterAndCounts.put(letter, countOccurrences(text, letter));
            }
        }
        return letterAndCounts;
    }

    /**
     * разделяем текст на предложения
     */
    protected static Sentence[] splitTextOnSentence(String text, String sentenceSeparation) {
        Sentence[] sentences;
        String[] rawSentense = text.split(sentenceSeparation);
        sentences = new Sentence[rawSentense.length];
        for (int i = 0; i < rawSentense.length; i++) {
            Sentence sentence = new Sentence(rawSentense[i].trim());
            sentences[i] = sentence;
        }
        return sentences;
    }

    /**
     * получение частого символа
     */
    protected static char getFrequentCharacter(Map<Character, Long> letterAndCounts) {
        Map.Entry<Character, Long> maxValue = null;
        for (var value : letterAndCounts.entrySet()) {
            if (maxValue == null || value.getValue() > maxValue.getValue()) {
                if (value.getKey() != 0) {
                    maxValue = value;
                }
            }
        }
        assert maxValue != null;
        return maxValue.getKey();
    }

    /**
     * Предложение начинается с заглавной буквы
     */
    //todo перед использование удалить все пробелы перед предложениями
    protected static boolean checkFirstLetterStartWithUpperCase(Sentence[] sentences) {
        boolean flag = true;
        for (Sentence sentence : sentences) {
            char firstLetter = sentence.toString().charAt(0);
            if (!Character.isUpperCase(firstLetter)) flag = false;
        }
        return flag;
    }

    private static void checkSentenceEndWithPoint(Sentence[] sentences) {

    }

    private static void checkCommaBeforeConjunctions() {

    }

    /**
     * пробел после запятой
     */
    protected static boolean spaceAfterComma(Sentence[] sentences) {
        boolean flag = true;
        for (Sentence sentence : sentences) {
            for (int i = 0; i < sentence.toString().length(); i++) {
                char commonSymbol = sentence.toString().charAt(i);
                if (commonSymbol == ',') {
                    if ((i + 1) >= sentence.toString().length()) {
                        return false;
                    }
                    char spaceSymbol = sentence.toString().charAt(i + 1);
                    if (!(spaceSymbol == ' '))
                        return false;
                }
            }
        }
        return flag;
    }


    /**
     * Разделяем предложения на слова
     */
    protected static ArrayList<Word> splitSentenceOnWord(Sentence[] sentences, String wordSeparation) {
        ArrayList<Word> words = new ArrayList<>();
        for (Sentence sentence : sentences) {
            String[] rawWords = sentence.toString().split(wordSeparation);
            for (String rawWord : rawWords) {
                Word word = new Word(rawWord);
                words.add(word);
            }
        }
        return removeEmptyWords(words);
    }

    private static long countOccurrences(String text, char ch) {
        return text.chars().filter(c -> c == ch).count();
    }

    private static String deleteSpaces(String text) {
        return text.trim();
    }
}
