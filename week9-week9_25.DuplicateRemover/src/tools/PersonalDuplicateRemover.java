package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {

    private Set<String> wordSet;
    private int duplicateCount;

    public PersonalDuplicateRemover() {
        this.wordSet = new HashSet<String>();
        this.duplicateCount = 0;
    }

    @Override
    public void add(String characterString) {
        if (this.wordSet.contains(characterString)) {
            this.duplicateCount++;
        }
        this.wordSet.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {

        return this.duplicateCount;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.wordSet;
    }

    @Override
    public void empty() {
        this.wordSet.clear();
        this.duplicateCount = 0;
    }
}
