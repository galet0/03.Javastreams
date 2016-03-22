import java.io.*;

/**
 * Created by galeto on 22.03.16.
 */
public class _01_SumLines {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(new File("files/lines.txt")));
        String lines = reader.readLine();
        while(lines != null){
            int currentSum = 0;
            for (int i = 0; i < lines.length(); i++) {
                currentSum += lines.charAt(i);
            }
            lines = reader.readLine();
            System.out.println(currentSum);
        }

    }
}
