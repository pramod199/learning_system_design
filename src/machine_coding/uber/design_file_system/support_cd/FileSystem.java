package machine_coding.uber.design_file_system.support_cd;


public class FileSystem {
    private DirectoryNode root;
    private DirectoryNode cwd;

    public FileSystem() {
        root = new DirectoryNode("root", null);
        root.parent = root; // root parent is itself
        cwd = root;
    }

    private String[] getParts(String path) {
        return path.split("/");
    }

    public String pwd() {
        if (cwd == root) {
            return "/";
        }

        StringBuilder path = new StringBuilder();
        FileSystemNode curr = cwd;

        while (curr != root) {
            path.insert(0, "/" + curr.getName());
            curr = curr.getParent();
        }
        return path.toString();
    }

    /**
     * mkdir with absolute or relative path
     */
    public void mkdir(String path) {

        DirectoryNode base = path.startsWith("/") ? root : cwd;
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) continue; // this will skip empty when path is absolute

            if (part.equals("..")) {
                base = base.getParent();
                continue;
            }
            // part is normal directory name
            FileSystemNode next = base.getChild(part);
            if (next == null) {
                // create directory
                DirectoryNode newDir = new DirectoryNode(part, base);
                base.addChild(newDir);
                base = newDir;
            } else {
                // exists
                if (next.isFile())
                    throw new RuntimeException("File exists in path");
                base = (DirectoryNode) next;
            }
        }
    }

    /**
     * cd with ., .., *, absolute, relative
     * Returns true if success, false if invalid path
     */
    public void cd(String path) {
        DirectoryNode original = cwd;

        DirectoryNode base = path.startsWith("/") ? root : cwd;
        String[] parts = path.split("/");

        try {
            for (String part : parts) {
                if (part.isEmpty()) {
                    continue;
                }
                if (part.equals(".")) {
                    continue;
                } else if (part.equals("..")) {
                    base = base.parent;
                } else if (part.equals("*")) {
                    FileSystemNode firstChild = base.getFirstChild();
                    if (firstChild != null){
                        if (firstChild.isFile()){
                            System.out.println("wildcard hit file");
                            throw new RuntimeException("wildcard hit file");
                        }
                        base = (DirectoryNode) firstChild;
                    }
                    // else stay(fallback to .)
                } else {
                    FileSystemNode next = base.getChild(part);
                    if(next == null || next.isFile()){
                        System.out.println("Invalid path");
                        throw new RuntimeException("Invalid path");
                    }
                    base = (DirectoryNode) next;
                }
            }
            cwd = base;
        } catch (Exception e){
            cwd = original;
        }

    }


}
