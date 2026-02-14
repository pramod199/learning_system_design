package machine_coding.uber.design_file_system.support_cd;


import java.util.Collection;
import java.util.TreeMap;

public class DirectoryNode extends FileSystemNode {
    private TreeMap<String, FileSystemNode> children;

    public DirectoryNode(String name, DirectoryNode parent) {
        super(name, parent);
        this.children = new TreeMap<>();
        // TreeMap keeps children lexicographically sorted
    }

    @Override
    boolean isFile() {
        return false;
    }

    @Override
    public FileSystemNode getChild(String name) {
        return children.get(name);
    }

    @Override
    public void addChild(FileSystemNode node) {
        children.put(node.getName(), node);
    }

    @Override
    public Collection<FileSystemNode> getChildren() {
        return children.values();
    }

    public FileSystemNode getFirstChild() {
        return children.firstEntry().getValue();
    }

}
