import java.io.*;
import java.util.Arrays;

public class _03_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        try (FileReader reader = new FileReader(new File("files/words.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter("files/count-chars.txt"))) {
            int input = reader.read();
            while (input != -1) {
                char ch = (char) input;
                if (Character.isLetter(ch)) {
                    if (Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u'}).contains(ch)) {
                        vowels++;
                    } else {
                        consonants++;
                    }
                } else if (Arrays.asList(new Character[]{'!', ',', '.', '?'}).contains(ch)) {
                    punctuation++;
                }

                input = reader.read();
            }

            writer.write(String.format("Vowels: %d\nConsonants: %d\nPunctuation: %d", vowels, consonants, punctuation));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
