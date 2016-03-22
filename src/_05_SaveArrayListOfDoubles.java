import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by galeto on 22.03.16.
 */
public class _05_SaveArrayListOfDoubles {
    public static void main(String[] args) {

        List<Double> doubles = new ArrayList<Double>() {{
            addAll(Arrays.asList(4.5,8.77,9.34,1.2,8.9,10.65,90.24));
        }};
        saveDouble(doubles);
        loadDouble(doubles.size());
    }

    public static void loadDouble(int numOfIntems) {
        try(ObjectInputStream source = new ObjectInputStream(new FileInputStream("files/doubles.list"))) {
            for (int i = 0; i < numOfIntems; i++) {
                System.out.println(source.readDouble());
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveDouble(List<Double> doubles) {
        try (ObjectOutputStream destination = new ObjectOutputStream(new FileOutputStream("files/doubles.list"))){
            for (Double aDouble : doubles) {
                destination.writeDouble(aDouble);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}
