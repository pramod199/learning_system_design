package lld.flyweight_design_pattern.word_processor.fix;

import java.util.HashMap;
import java.util.Map;

public class LetterFactory {
    private static Map<Character, ILetter> characterCache = new HashMap<>();

    public static ILetter createLetter(char character) {
        ILetter letter = characterCache.get(character);
        if (letter == null) {
            letter = new DocumentCharacter(character, "Arial", 12);
            characterCache.put(character, letter);
        }
        return letter;
    }
}
