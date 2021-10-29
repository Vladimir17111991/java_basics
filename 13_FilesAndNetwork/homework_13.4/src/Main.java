import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {
            Document document = Jsoup.connect("https://lenta.ru").get();
            Elements elements = document.select("a>img");
            elements.forEach(element -> {
                String s = element.attr("abs:src");
                downloadImage(s);
                System.out.println("Картинка " + s + " в каталоге");
            });
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void downloadImage(String pathImage) {
        String imageName = pathImage.substring(pathImage.lastIndexOf("/") + 1);
        try {
            URL urlImage = new URL(pathImage);
            InputStream inputStream = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n;
            FileOutputStream outputStream = new FileOutputStream("images/" + imageName);
            while ((n = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, n);
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
