package lld.composite_design_pattern.design_file_system;

public class Main {
    public static void main(String[] args) {
        Directory movieDirectory = new Directory("Movie");

        File border = new File("Border");
        movieDirectory.add(border);

        Directory comedyMovieDirectory = new Directory("ComedyMovie");
        File hulchal = new File("Hulchal");
        File heraPheri = new File("Hera Pheri");
        comedyMovieDirectory.add(hulchal);
        comedyMovieDirectory.add(heraPheri);
        movieDirectory.add(comedyMovieDirectory);

        movieDirectory.ls();
    }
}
