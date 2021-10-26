import java.io.File;
public class FileUtils {

    public static long calculateFolderSize(String path) {
        long countBytes = 0;
        try {
            File folder = new File(path);
            File[] files = folder.listFiles();
            for (File file : files) {
                String pathFile = file.getAbsolutePath();
                if (file.isDirectory()) {
                    File subFolder = new File(pathFile);
                    File[] filesSubFolder = subFolder.listFiles();
                    for (File fileNew : filesSubFolder) {
                        String pathFileInSubFolder = fileNew.getAbsolutePath();
                        System.out.println(pathFileInSubFolder + " - " + fileNew.length() + " байт");
                        countBytes += fileNew.length();
                    }
                    pathFile = "";
                }
                if (!pathFile.equals("")) {
                    System.out.println(pathFile + " - " + file.length() + " байт");
                    countBytes += file.length();
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return countBytes;
    }
}
