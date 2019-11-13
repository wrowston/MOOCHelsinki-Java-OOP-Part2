import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    private HashMap<String, String> words;

    public Dictionary() {
        this.words = new HashMap<String, String>();
    }

    public String translate(String word) {
        if (this.words.containsKey(word)) {
            return this.words.get(word);
        }
        return null;
    }

    public void add(String word, String translation) {
        this.words.put(word, translation);
    }

    public int amountOfWords(){
        return this.words.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> translations = new ArrayList<String>();

        for (String key : this.words.keySet()) {
            String translation = key + " = " + this.words.get(key);
            translations.add(translation);
        }
        return translations;
    }
}
