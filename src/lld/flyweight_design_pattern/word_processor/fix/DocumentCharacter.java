package lld.flyweight_design_pattern.word_processor.fix;

public class DocumentCharacter implements ILetter {

    /* these fields are intrinsic
     *  and will be shared among all the objects
     */

    private char character;
    private String fontType;
    private int size;

    public DocumentCharacter(char character, String fontType, int size) {
        this.character = character;
        this.fontType = fontType;
        this.size = size;
    }

    // only getter to make immutable.

    @Override
    public void display(int x, int y) {
        // display the character of particular font and size at given location
    }
}
