package machine_coding.uber.design_file_system;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class DirectoryNode extends FileSystemNode {
    private Map<String, FileSystemNode> children;

    public DirectoryNode(String name) {
        super(name);
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

}
