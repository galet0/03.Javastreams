import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by galeto on 22.03.16.
 */
public class _07_CreateZipArchive {
    public static void main(String[] args) {
        HashMap<String,File> files = new HashMap<String, File>() {{
            put("count-chars.txt",new File("files/count-chars.txt"));
            put("words.txt",new File("files/words.txt"));
            put("lines.txt",new File("files/lines.txt"));
        }};
        zipFiles(files,"files/text-files.zip");
    }

    public static void zipFiles(Map<String,File> files,String archiveName) {
        try(ZipOutputStream destination = new ZipOutputStream(new FileOutputStream(archiveName))){
            for(Map.Entry<String,File> file : files.entrySet()){
                try(FileInputStream source = new FileInputStream(file.getValue())){
                    destination.putNextEntry(new ZipEntry(file.getKey()));

                    byte[] buffer = new byte[4096];
                    while(true){
                        int readed = source.read(buffer,0,buffer.length);
                        if(readed <= 0) break;
                        destination.write(buffer,0,readed);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
