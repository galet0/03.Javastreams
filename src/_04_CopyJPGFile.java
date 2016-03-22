import java.io.*;

/**
 * Created by galeto on 22.03.16.
 */
public class _04_CopyJPGFile {
    public static void main(String[] args) {
        try (FileInputStream source = new FileInputStream(new File("files/picture.jpg"));
             FileOutputStream destination = new FileOutputStream(new File("files/my-copied-picture.jpg"))){

            byte[] buffer = new byte[4096];
            while (true){
                int readBytes = source.read(buffer,0,buffer.length);
                if(readBytes <= 0){
                    break;
                } else {
                    destination.write(buffer,0,readBytes);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
