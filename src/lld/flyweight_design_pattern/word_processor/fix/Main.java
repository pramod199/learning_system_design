package lld.flyweight_design_pattern.word_processor.fix;

public class Main {
    public static void main(String[] args) {
        ILetter object1 = LetterFactory.createLetter('t');
        object1.display(0,0);

        LetterFactory.createLetter('h').display(1,0);
        LetterFactory.createLetter('t').display(2,0); // this will not create new t but will fetch from cache.
    }
}
