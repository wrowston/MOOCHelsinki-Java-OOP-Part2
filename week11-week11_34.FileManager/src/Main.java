import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager t = new FileManager();
        t.save("src/testinput1.txt", "third");

        List<String> fileLines = new ArrayList<String>();
        fileLines.add("another line");
        t.save("src/testinput2.txt", fileLines);

        for (String line : t.read("src/testinput2.txt")) {
            System.out.println(line);
        }

    }
}
