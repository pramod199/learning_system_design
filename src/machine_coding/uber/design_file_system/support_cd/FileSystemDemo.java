package machine_coding.uber.design_file_system.support_cd;


//https://codezym.com/question/30
public class FileSystemDemo {
    public static void main(String[] args) {

        FileSystem fs = new FileSystem();

        System.out.println("Initial pwd: " + fs.pwd());

        fs.mkdir("/a/b/c");

        fs.cd("/a/b");
        System.out.println("After cd /a/b -> " + fs.pwd());

        fs.cd("*");
        System.out.println("After cd * -> " + fs.pwd());

        fs.cd("../*");
        System.out.println("After cd ../* -> " + fs.pwd());

        fs.cd("/*");
        System.out.println("After cd /* -> " + fs.pwd());

        fs.cd("/nope/*/x");
        System.out.println("Final pwd: " + fs.pwd());
    }
}
