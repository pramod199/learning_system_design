package machine_coding.uber.design_file_system.support_cd;


public class FileNode extends FileSystemNode {
    private StringBuilder content;

    public FileNode(String name, DirectoryNode parent) {
        super(name, parent);
        this.content = new StringBuilder();
    }

    @Override
    boolean isFile() {
        return true;
    }

    public void appendContent(String data) {
        content.append(data);
    }

    public String readContent() {
        return content.toString();
    }

}
