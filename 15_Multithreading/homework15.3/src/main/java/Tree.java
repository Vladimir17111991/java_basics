import java.util.Collection;

public class Tree implements Node{
    String name;
    Collection<Node> children;
    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(Collection<Node> children) {
        this.children = children;
    }

    public Collection<Node> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

}
