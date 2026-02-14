package machine_coding.uber.design_file_system;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private FileSystemNode root;

    public FileSystem() {
        root = new DirectoryNode("root");
    }

    private String[] getParts(String path) {
        return path.split("/");
    }

    private FileSystemNode traverse(String path) {
        if (path.equals("/")) return root; // handle special case of root

        String[] parts = getParts(path);
        FileSystemNode current = root;

        for (int i = 1; i < parts.length; i++) { // as on split we will have empty at first place-> /a/b/c -> [" ", a, b, c]
            current = current.getChild(parts[i]);
            if (current == null) return null;
        }

        return current;
    }

    public List<String> ls(String path) {
        FileSystemNode node = traverse(path);

        List<String> result = new ArrayList<>();

        if (node == null) {
            return result;
        }

        if (node.isFile()) {
            result.add(node.getName());
        } else{
            for (FileSystemNode child : node.getChildren()) {
                result.add(child.getName());
            }
        }
        return result;
    }

    public void mkdir(String path) {
        String[] parts = getParts(path);
        FileSystemNode current = root;

        for (int i = 1; i < parts.length; i++) {
            FileSystemNode next = current.getChild(parts[i]);

            if (next == null) {
                next = new DirectoryNode(parts[i]);
                current.addChild(next);
            }

            current = next;
        }
    }


    public void addContentToFile(String filePath, String content) {
        String[] parts = getParts(filePath);
        FileSystemNode current = root;

        for (int i = 1; i < parts.length - 1; i++) {
            FileSystemNode next = current.getChild(parts[i]);

            if (next == null) {
                next = new DirectoryNode(parts[i]);
                current.addChild(next);
            }

            current = next;
        }

        String fileName = parts[parts.length - 1];
        FileSystemNode file = current.getChild(fileName);

        if (file == null) {
            file = new FileNode(fileName);
            current.addChild(file);
        }

        file.appendContent(content);
    }

    public String readContentFromFile(String filePath) {
        FileSystemNode node = traverse(filePath);
        if (node == null) throw new RuntimeException("File not found");

        return node.readContent();
    }


}
