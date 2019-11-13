package file;

import java.io.*;
import java.util.Scanner;

public class Analysis {

    private File file;


    public Analysis(File file) {
        this.file = file;
    }

    public int lines() throws Exception{
        Scanner reader = new Scanner(this.file);
        int count = 0;

        while (reader.hasNextLine()) {
            count++;
            reader.nextLine();
        }
        return count;
    }

    public int characters() throws Exception {
        Scanner reader = new Scanner(this.file);
        int charCount = 0;

        while (reader.hasNext()) {
            String word = reader.next();
            charCount = charCount + word.length() + 1;
        }
        return charCount;
    }

//    public int lines() {
//        String content = readFile();
//        return content.split("\n").length;
//    }
//
//    public int characters() {
//        String content = readFile();
//        return content.length();
//    }
//
//    private String readFile() {
//        try {
//            String str = "";
//
//            Scanner reader = new Scanner(file);
//
//            while (reader.hasNextLine()) {
//                str += reader.nextLine();
//                str += "\n";
//            }
//
//            return str;
//        } catch (FileNotFoundException ex) {
//            return "";
//        }
//    }
}
