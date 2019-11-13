
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(file));
        List<String> fileLines = new ArrayList<String>();

        while (reader.hasNextLine()) {
            fileLines.add(reader.nextLine());
        }
        return fileLines;
    }

    public void save(String file, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (String line : texts) {
            fileWriter.write(line + "\n");
        }
        fileWriter.close();
    }
}
