package lld.composite_design_pattern.problem_statement;

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
