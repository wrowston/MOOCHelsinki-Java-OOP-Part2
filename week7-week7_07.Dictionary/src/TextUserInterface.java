import java.util.Scanner;

public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void add(){
        System.out.println("Word in Finnish: ");
        String finnish = this.reader.nextLine();

        System.out.println("English translation: ");
        String english = this.reader.nextLine();

        this.dictionary.add(finnish, english);
    }

    public void translate() {
        System.out.println("Give a word: ");
        String word = this.reader.nextLine();

        System.out.println("Translation: " + this.dictionary.translate(word));
    }

    public void start() {

        System.out.print("Statement: \n add - adds a word pair to the dictionary" +
                "\n translate - asks a word and prints its translation" +
                "\n quit - quit the text user interface");

        while (true) {
            System.out.println();
            System.out.println("Statement: ");
            String input = this.reader.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Cheers!");
                break;
            } else if (input.equalsIgnoreCase("add")){
                add();
            } else if (input.equalsIgnoreCase("translate")) {
                translate();
            } else {
                System.out.println("Unknown statement");
            }
        }
    }
}
