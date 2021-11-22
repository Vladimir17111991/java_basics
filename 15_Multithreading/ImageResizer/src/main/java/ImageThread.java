import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageThread extends Thread {
    private final File[] files;
    private final int newWidth;
    private final String dstFolder;
    private long time;
    int numberThread;

    public ImageThread(int numberThread, File[] files, int newWidth, String dstFolder, long time) {
        this.numberThread = numberThread;
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage newImage = Scalr.resize(image, newWidth, newHeight);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
                ImageIO.write(newImage, "png", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String toString() {
        return "Time " + (numberThread + 1) +
                " Thread - " + (System.currentTimeMillis() - time) + " ms.";
    }
}
