import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.RecursiveTask;

public class NodeLinks extends RecursiveTask<NodeLinks> implements Node{
    private final String path;
    private final Set<String> listLinks = new TreeSet<>();
    private final List<NodeLinks> listTask = new ArrayList<>();
    private final List<NodeLinks> listNodeLinks = new ArrayList<>();

    public NodeLinks(String path) {
        this.path = path;
    }

    @Override
    protected NodeLinks compute() {
        try {
            Thread.sleep(150);
            Document doc = Jsoup.connect(path).maxBodySize(0).get();
            Elements elements = doc.select("a");
            elements.forEach(element -> {
                String absolutePath = element.attr("href");
                if (absolutePath.matches(path + ".*/")) {
                    listLinks.add(absolutePath);
                } else if (absolutePath.matches(path.substring(Main.rootName.length()-1) + ".*/")) {
                    listLinks.add(Main.rootName + absolutePath.substring(1));
                }
            });
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        for (String child : listLinks) {
            NodeLinks links = new NodeLinks(child);
            links.fork();
            listTask.add(links);
        }

        for (NodeLinks task : listTask) {
            NodeLinks tmpNode = task.join();
            if (tmpNode != null) {
                listNodeLinks.add(task.join());
            }
        }
        return this;
    }
    @Override
    public String getAbsPath() {
        return path;
    }

    public void writeFile(FileWriter writer) throws Exception {
        int count = 0;
        String line = "";
        for (char element : getAbsPath().toCharArray()) {
            if (element == '/') {
                count++;
            }
        }
        for (int i = 3; i < count; i++) {
            line += "\t";
        }
        writer.append(line + getAbsPath() + "\n");
        for (NodeLinks nd : listNodeLinks) {
            nd.writeFile(writer);
        }
    }
}
