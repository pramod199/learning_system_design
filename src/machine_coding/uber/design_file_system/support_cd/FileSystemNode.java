package machine_coding.uber.design_file_system.support_cd;

// acts as trie node -> it is abstract to handle file and directory

import java.util.Collection;

public abstract class FileSystemNode {
    private String name;
    DirectoryNode parent; // only directory node can be parent.

    public FileSystemNode(String name, DirectoryNode parent) {
        this.name = name;
        this.parent = parent;
    }

    // abstract method
    abstract boolean isFile();



    // Getters and Setters
    public String getName() {
        return name;
    }

    public DirectoryNode getParent() {
        return parent;
    }


    // Composite operations (default unsupported)
    public FileSystemNode getChild(String name) {
        throw new UnsupportedOperationException("Not a directory");
    }

    public void addChild(FileSystemNode node) {
        throw new UnsupportedOperationException("Not a directory");
    }

    public Collection<FileSystemNode> getChildren() {
        throw new UnsupportedOperationException("Not a directory");
    }

    public void appendContent(String data) {
        throw new UnsupportedOperationException("Not a file");
    }

    public String readContent() {
        throw new UnsupportedOperationException("Not a file");
    }
}
