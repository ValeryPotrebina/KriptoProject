import java.io.IOException;
import java.util.*;

//кучу пробелов в конце
//Начало предложения с заглавной буквы
//Перед союзами: что,как, когда и т.д мы ставим запятую, причем после запятой тире (пример: Я хочу сказать, что у меня есть игрушка.)
//По среди слова у нас нет заглавных букв
//Слова не больше, чем из 20 букв
//
//    если слово из одной буквы, то скорее всего это или пробел, или Я, или союз а, и
//    Максимальное число согласных букв подряд — 4, в слове «контрвстреча»
//    4 гласных подряд максимум
//c:\1\4.txt
public class TextAnalyz extends Encryption {

    public static final int COMMON = -1;
    public static final int COLON = -4;
    public static final int SEMICOLON = -5;
    public static final int POINT = 1;
    public static final int EXCLAMATION_POINT = 2;
    public static final int QUESTION_POINT = 3;

    public static void main(String[] args) throws IOException {
        //System.out.println(RUSSIAN_ALPHABET.indexOf('?'));
        bruteForse();
    }
    ///sjklfsef r kjlef cjrfbsdefbwlergjbs

    /**
     * Проверка, что текст не пустой
     */
    public static void bruteForse() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь текстового файла, который хотите расшифровать методом brute force: ");
        String path = scanner.nextLine();
        for (int i = 0; i < RUSSIAN_ALPHABET.length(); i++) {
            String text = messageEncrypt(i, path);
            if (analyzeText(text, i + 1)) {
                SendingFiles.sendBruteForceMessage(text);
            }
        }
    }

//
//
// сделать новый алфавит

    public static boolean analyzeText(String text, int key) throws IOException {
        boolean flag = true;
        if (!checkNotNullText(text))
            return false;
        String alphabet = alphabetEncrypt(key);
        char separationSpace = getFrequentCharacter(getCountEachLetter(text));
        //int spaceIndex = alphabet.indexOf(separationSpace);
        int commonIndex = indexing(separationSpace, COMMON, key);
        int colonIndex = indexing(separationSpace, COLON, key);
        int semicolonIndex = indexing(separationSpace, SEMICOLON, key);
        int pointIndex = indexing(separationSpace, POINT, key);
        int exclamationPointIndex = indexing(separationSpace, EXCLAMATION_POINT, key);
        int questionPointIndex = indexing(separationSpace, QUESTION_POINT, key);
        String separationSemicolon = String.valueOf(alphabet.charAt(semicolonIndex));
        String separationCommon = String.valueOf(alphabet.charAt(commonIndex));
        String separationColon = String.valueOf(alphabet.charAt(colonIndex));
        String separationCommonAndSpace = separationCommon + separationSpace;
        String separationPoint = String.valueOf(alphabet.charAt(pointIndex));
        String separationexclamationPoint = String.valueOf(alphabet.charAt(exclamationPointIndex));
        String separationquestionPoint = String.valueOf(alphabet.charAt(questionPointIndex));
        String sentenceSeparation = "["
                +
                separationPoint
                +
                separationexclamationPoint
                +
                separationquestionPoint
                +
                "]";
        String wordSeparation = "["
                +
                separationCommonAndSpace
                +
                separationSpace
                +
                separationCommon
                +
                separationColon
                +
                separationSemicolon
                +
                "]";
        String newText = deleteSpaces(text);
        Sentence[] sen = splitTextOnSentence(newText, sentenceSeparation);

        if (!checkFirstLetterStartWithUpperCase(sen))
            return false;

        if (!spaceAfterComma(sen))
            return false;

        ArrayList<Word> words = new ArrayList<>(splitSentenceOnWord(sen, wordSeparation));

        if (!checkFirstLetterNotForbiddenLetter(words))
            return false;

        if (!checkNotMoreTTLettersInWord(words))
            return false;

        if (!checkNotFirstLetterSmall(words))
            return false;

        return flag;
    }

    public static int indexing(char separationSpace, int index, int key) throws IOException {
        int newIndex = alphabetEncrypt(key).indexOf(separationSpace) + index;
        if (newIndex < 0) {
            newIndex = COUNT_LETTERS + newIndex - 1;
        }
        /*if (newIndex >= 75){
            newIndex = newIndex;
        }*/
        return newIndex;
    }

    /**
     * максимальное использование определенного символа
     */
    private static Boolean checkNotNullText(String text) { //проверка, что текст не пустой
        if (text.length() > 0) {
            //System.out.println("Текст не пуст!");
            return true;
        } else {
            //System.out.println("Введите текст, который хотите расшифровать");
            return false;
        }
    }

    /**
     * количество букв
     */
    //todo убрать нули в конце!!
    //прокерка, если буквы встречалалсь уже, то не надо считать
    private static Map<Character, Long> getCountEachLetter(String text) {
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
    private static Sentence[] splitTextOnSentence(String text, String sentenceSeparation) {
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
    private static char getFrequentCharacter(Map<Character, Long> letterAndCounts) {
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
    private static boolean checkFirstLetterStartWithUpperCase(Sentence[] sentences) {
        boolean flag = true;
        for (Sentence sentence : sentences) {
            char firstLetter = sentence.toString().charAt(0);
            if (!Character.isUpperCase(firstLetter)) flag = false;
        }
        return flag;
    }

    /**
     * пробел после запятой
     */
    private static boolean spaceAfterComma(Sentence[] sentences) {
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
     * удаление пустых слов
     */
    private static ArrayList<Word> removeEmptyWords(ArrayList<Word> words) {
        words.removeIf(word -> word.toString().length() == 0);
        return words;
    }

    /**
     * Разделяем предложения на слова
     */
    private static ArrayList<Word> splitSentenceOnWord(Sentence[] sentences, String wordSeparation) {
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

    /**
     * Проверка, что первая буква не является недопустимой
     */
    private static Boolean checkFirstLetterNotForbiddenLetter(ArrayList<Word> words) {
        boolean flag = true;
        for (Word word : words) {
            char firstLetter = word.toString().charAt(0);
            switch (firstLetter) {
                case 'ы', 'ь', 'ъ', '.', ' ', '!', ',', ':', ';', '?', 'Ы': {
                    return false;
                }
                default:
                    flag = true;
                    break;
            }
        }
        return flag;
    }

    /**
     * Проверка, что в слове не больше 22 букв
     */
    private static boolean checkNotMoreTTLettersInWord(ArrayList<Word> words) {
        for (Word word : words) {
            if (word.letterCounter() > 22) return false;
        }
        return true;
    }

    /**
     * Слова не могут чередоваться (большая - маленькая)
     */
    private static boolean checkNotFirstLetterSmall(ArrayList<Word> words) {
        boolean flag = true;
        for (Word word : words) {
            for (int i = 1; i < word.toString().length(); i++) {
                if (!Character.isLowerCase(word.toString().charAt(i)))
                    return false;
            }
        }
        return flag;
    }

    //todo для предложений
    private static void checkSentenceEndWithPoint(Sentence[] sentences) {

    }

    private static void checkCommaBeforeConjunctions() {

    }

    //todo для слов
    private static void checkNotMoreFourConsonants() {

    }

    //todo для слов
    private static void checkNotMoreFourVowels() {

    }

    private static long countOccurrences(String text, char ch) {
        return text.chars().filter(c -> c == ch).count();
    }

    private static String deleteSpaces(String text) {
        return text.trim();
    }
}
