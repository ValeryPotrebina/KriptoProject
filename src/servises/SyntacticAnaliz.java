package servises;

import servises.Encryption;

import java.io.IOException;

public class SyntacticAnaliz extends TextAnalyz {
    public static final int COMMON = -1;
    public static final int COLON = -4;
    public static final int SEMICOLON = -5;
    public static final int POINT = 1;
    public static final int EXCLAMATION_POINT = 2;
    public static final int QUESTION_POINT = 3;

    /*public static boolean analyzeText(String text, int key) throws IOException {
        boolean flag = true;
        if (!checkNotNullText(text))
            return false;
        String alphabet = servises.Encryption.alphabetEncrypt(key);
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
        models.Sentence[] sen = splitTextOnSentence(newText, sentenceSeparation);

        if (!checkFirstLetterStartWithUpperCase(sen))
            return false;

        if (!spaceAfterComma(sen))
            return false;
    }*/
    public static int indexing(char separationSpace, int index, int key) throws IOException {
        int newIndex = Encryption.alphabetEncrypt(key).indexOf(separationSpace) + index;
        if (newIndex < 0) {
            newIndex = Encryption.COUNT_LETTERS + newIndex - 1;
        }
        return newIndex;
    }
}
