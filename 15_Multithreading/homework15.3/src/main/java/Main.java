import java.io.FileWriter;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static final String rootName ="https://skillbox.ru/";
    public static void main(String[] args) {
        NodeLinks root = new ForkJoinPool().invoke(new NodeLinks(rootName));
        try {
            FileWriter writer = new FileWriter("links");
            root.writeFile(writer);
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}