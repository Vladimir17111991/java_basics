import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
    try {
            //FileInputStream is = new FileInputStream(sourceDirectory);
            // FileOutputStream os = new FileOutputStream(destinationDirectory);
            Files.walk(Paths.get(sourceDirectory)).forEach(source -> {
                Path os = Paths.get(destinationDirectory, source.toString()
                        .substring(sourceDirectory.length()));
                try {
                    Files.copy(source, os);
                }
                catch (IOException ex)
                {ex.printStackTrace();}

            });
        }
    catch (Exception e)
    {e.printStackTrace();}
        }
}
