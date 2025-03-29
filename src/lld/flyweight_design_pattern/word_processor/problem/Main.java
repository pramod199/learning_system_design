package lld.flyweight_design_pattern.word_processor.problem;

public class Main {
    public static void main(String[] args) {
        /*
        this is the data we want to write into the word processor.

        total = 58 characters.
        t = 7 times
        h = 3 times
        a= 3 times and so on...
         */

        Character obj1 = new Character('t', "Arial", 12, 1, 1);
        Character obj2 = new Character('h', "Arial", 12, 1, 2);
        Character obj3 = new Character('i', "Arial", 12, 1, 3);

    }
}
