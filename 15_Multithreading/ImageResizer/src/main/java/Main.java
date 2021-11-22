import java.io.File;

public class Main {
    private static  final int newWidth = 300;
    public static void main(String[] args) {
        String srcFolder = "src/main/resources/src";
        String dstFolder = "src/main/resources/dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();
        int countCores = Runtime.getRuntime().availableProcessors();
        try {
            File[] files = srcDir.listFiles();
            int quarter = files.length / countCores;

            ImageThread[] arrayThread = new ImageThread[countCores];
            for (int i = 0; i < arrayThread.length; i++) {
                File[] filesThread = new File[quarter];
                System.arraycopy(files, i * quarter, filesThread, 0, filesThread.length);
                arrayThread[i] = new ImageThread(i, filesThread, newWidth, dstFolder, start);
                arrayThread[i].start();
                System.out.println(arrayThread[i]);
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }
}
