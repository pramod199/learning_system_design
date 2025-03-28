package lld.composite_design_pattern.problem_statement;

public class File {
    String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public void ls() {
        System.out.println("file name " + fileName);
    }
}
