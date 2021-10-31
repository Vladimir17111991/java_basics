import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static JSONObject numberLine = new JSONObject();
    private static final String DATA_GSON = "data/metroParse.json";

    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            // Document document = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
            String htmlFile = parseFile("data/MetroMoscow.html");
            Document document = Jsoup.parse(htmlFile);
            downloadDataOnHtml(document);
        }
        catch (Exception e){e.printStackTrace();}
    }

    public static void writeJsonSimpleLine(String path) {
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("stations", numberLine);
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.write(GSON.toJson(sampleObject));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return builder.toString();
    }

    public static void downloadDataOnHtml(Document document){
        Elements lines = document.select("div > div > span.js-metro-line");
        Elements stations = document.select("div > div > div.js-metro-stations");
        lines.forEach(element -> {
            String lineNumber = element.attr("data-line");
            stations.forEach(element2 -> {
                String lineStation = element2.attr("data-line").trim();
                if (lineNumber.equals(lineStation)) {
                    int elem = element2.childNodeSize();
                    List<String> list = new ArrayList<>();
                    for (int i = 0; i < elem - 2; i++) {
                        list.add(element2.child(i).text());
                    }
                    numberLine.put(lineStation, list);
                }
            });
        });
        writeJsonSimpleLine(DATA_GSON);

}

}

