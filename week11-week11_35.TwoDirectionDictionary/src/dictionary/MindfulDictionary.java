package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MindfulDictionary {

    private File dictionary;
    private Map<String, String> words;
    private Scanner reader;

    public MindfulDictionary() {
        this.words = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this.words = new HashMap<String, String>();
        this.dictionary = new File(file);

        try {
            this.reader = new Scanner(this.dictionary);
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public boolean load() {
        //load(or add) words from file given called "words.txt" to the HashMap

        if (!this.reader.hasNextLine()) {
            return false;
        }
        while (this.reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] parts = line.split(":");
            add(parts[0], parts[1]);
        }
        return true;
    }

    public boolean save() {
        try {
            FileWriter writer = new FileWriter(this.dictionary);

            for (String key : this.words.keySet()) {
                writer.write(key + ":" + this.words.get(key) + "\n");
            }
            writer.close();
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public void add(String word, String translation) {
        if (!this.words.containsKey(word)) {
            this.words.put(word, translation);
        }
    }

    public String translate(String word) {
        if (this.words.containsKey(word)) {
            return this.words.get(word);

        } else if (this.words.containsValue(word)) {
            return getKeyByValue(this.words, word);
        }
        return null;
    }

    public void remove(String word) {
        this.words.remove(word);
        String key = getKeyByValue(this.words, word);
        this.words.remove(key);
    }

    public <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
