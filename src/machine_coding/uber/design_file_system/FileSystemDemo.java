package machine_coding.uber.design_file_system;

// https://algo.monster/liteproblems/588
// https://algo.monster/liteproblems/1166
// https://codewitharyan.com/tech-blogs/design-file-system
public class FileSystemDemo {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        System.out.println("===== TEST 1: Initial root listing =====");
        fs.ls("/");

        System.out.println("\n===== TEST 2: Create directories =====");
        fs.mkdir("/a/b/c");
        fs.mkdir("/a/b/d");
//        System.out.println("ls(\"/\") -> " + fs.ls("/"));
//        System.out.println("ls(\"/a\") -> " + fs.ls("/a"));
//        System.out.println("ls(\"/a/b\") -> " + fs.ls("/a/b"));

        System.out.println("\n===== TEST 3: Add file content =====");
        fs.addContentToFile("/a/b/c/file.txt", "Hello ");
        fs.addContentToFile("/a/b/c/file.txt", "World!");
        System.out.println("ls(\"/a/b/c\") -> " + fs.ls("/a/b/c/file.txt"));

        System.out.println("\n===== TEST 4: Read file content =====");
        String content = fs.readContentFromFile("/a/b/c/file.txt");
        System.out.println("readContentFromFile(\"/a/b/c/file.txt\") -> " + content);

        System.out.println("\n===== TEST 5: Add multiple files =====");
        fs.addContentToFile("/a/b/c/alpha.txt", "Alpha file");
        fs.addContentToFile("/a/b/c/zeta.txt", "Zeta file");
        fs.addContentToFile("/a/b/c/beta.txt", "Beta file");

        System.out.println("ls(\"/a/b/c\") -> " + fs.ls("/a/b/c"));
        System.out.println("\n===== TEST 6: File ls behavior =====");
        System.out.println("ls(\"/a/b/c/file.txt\") -> " + fs.ls("/a/b/c/file.txt"));
    }
}
