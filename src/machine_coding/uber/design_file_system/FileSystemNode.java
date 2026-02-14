package machine_coding.uber.design_file_system;

// acts as trie node -> it is abstract to handle file and directory

import java.util.Collection;

public abstract class FileSystemNode {
    private String name;

    public FileSystemNode(String name) {
        this.name = name;
    }

    // abstract method
    abstract boolean isFile();



    // Getters and Setters
    public String getName() {
        return name;
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
