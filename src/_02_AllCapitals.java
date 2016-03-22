import java.io.*;

/**
 * Created by galeto on 22.03.16.
 */
public class _02_AllCapitals {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("files/lines.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder uppercaseText = new StringBuilder();
        try {
            java.lang.String lines = reader.readLine();
            while (lines != null){
                uppercaseText.append(lines.toUpperCase() + "\n");
                lines = reader.readLine();
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter(new File("files/lines.txt")))) {
                writer.write(uppercaseText.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
