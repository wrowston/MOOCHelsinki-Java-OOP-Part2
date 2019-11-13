package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {

    private File file;
//    private List<String> words;

    public WordInspection(File file) {
        this.file = file;

//        try {
//            this.words = readFile();
//        } catch (Exception e) {
//            this.words = new ArrayList<String>();
//        }
    }

    public List<String> readFile() {
        try {
            List<String> words = new ArrayList<String>();
            Scanner reader = new Scanner(this.file, "UTF-8");

            while (reader.hasNext()) {
                String word = reader.next();
                words.add(word);
            }
            return words;
        } catch (FileNotFoundException ex){
            List<String> notFound = new ArrayList<String>();
            String not = "File Not Found";
            notFound.add(not);
            return notFound;
        }
    }

    public int wordCount() {
        return readFile().size();
    }

    public List<String> wordsContainingZ() {
        List<String> wordsContainingZ = new ArrayList<String>();

        for (String word : readFile()) {
            if (word.contains("z")) {
                wordsContainingZ.add(word);
            }
        }
        return wordsContainingZ;
    }

    public List<String> wordsEndingInL() {
        List<String> wordsEndingWithL = new ArrayList<String>();
        char someChar = 'l';

        for (String word : readFile()) {
            if (word.charAt(word.length() - 1) == someChar) {
                wordsEndingWithL.add(word);
            }
        }
        return wordsEndingWithL;
    }

    public List<String> palindromes() {
        List<String> palindromes = new ArrayList<String>();

        for (String checkWord : readFile()) {
            String reverse = "";
            int length = checkWord.length();

            for (int i = length - 1; i >= 0; i--) {
                reverse += checkWord.charAt(i);
            }
            if (reverse.equals(checkWord)) {
                palindromes.add(checkWord);
            }
        }
        return palindromes;
    }

    public List<String> wordsWhichContainAllVowels() {
        List<String> wordsWithAllVowels = new ArrayList<String>();


        for (String checkWord : readFile()) {
           if (this.isAllVowels(checkWord)) {
               wordsWithAllVowels.add(checkWord);
           }
        }
        return wordsWithAllVowels;
    }

    private boolean isAllVowels(String word) {
        String vowels = "aeiouyäö";

        for (char vowel : vowels.toCharArray()) {
            if (!word.contains("" + vowel)) {
                return false;
            }
        }
        return true;
    }
}
