package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import backend.*;

/**
 * Test the Dictionary class methods
 * 
 * @author Lily Tran, Felicia Nemoto-Pace, Linda Hu 
 * 
 * Source: Past programming assignments,
 *         https://docs.junit.org/5.0.2/api/org/junit/jupiter/api/BeforeEach.html
 *         (BeforeEach interface)
 *         https://docs.oracle.com/javase/8/docs/api/java/util/List.html (List
 *         clear() method)
 */
public class DictionaryTest {
    @BeforeEach
    void resetEveryList() {
        Dictionary.commonWords.clear();
        Dictionary.englishWords.clear();
        Dictionary.validWordleGuesses.clear();
        Dictionary.validWordleTargets.clear();
    }

    @Test
    void testGet5LetterWords() {
        List<String> rawInput = Arrays.asList("extraordinary", "hello",
                "perfect", "merit", "i");
        List<String> res = Dictionary.get5LetterWords(rawInput);
        assertEquals(2, res.size());
        assertTrue(res.contains("hello"));
        assertTrue(res.contains("merit"));
        assertFalse(res.contains("tea"));
    }

    @Test
    void testIsValidGuessTrue() {
        Dictionary.validWordleGuesses.add("piano");
        assertTrue(Dictionary.isValidGuess("piano"));
    }

    @Test
    void testIsValidGuessNotInWordList() {
        Dictionary.validWordleGuesses.add("pizza");
        assertFalse(Dictionary.isValidGuess("tacos"));
    }

    @Test
    void testIsValidTargetCommonAndValidGuess() {
        Dictionary.validWordleGuesses.add("river");
        Dictionary.commonWords.add("river");
        assertTrue(Dictionary.isValidTarget("river"));
    }

    @Test
    void testIsValidTargetUncommonWord() {
        Dictionary.validWordleGuesses.add("crwth");
        assertFalse(Dictionary.isValidTarget("crwth"));
    }

    @Test
    void testIsValidTarget4LetterGuess() {
        Dictionary.commonWords.add("meow");
        assertFalse(Dictionary.isValidTarget("meow"));
    }

    @Test
    void testGetValidTarget() {
        Dictionary.englishWords.add("apple");
        Dictionary.englishWords.add("grape");
        Dictionary.validWordleGuesses.add("apple");
        Dictionary.validWordleGuesses.add("grape");
        Dictionary.commonWords.add("apple");
        Dictionary.commonWords.add("grape");

        String target = Dictionary.getValidTarget();
        assertNotNull(target);
        assertTrue(target.equals("apple") || target.equals("grape"));
    }

    @Test
    void testReadMissingFiles() {
        List<String> result = Dictionary.readFiles("file_not_exist.txt");
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testFilesSetUp() {
        Dictionary.englishWords.add("thisisalongword");
        Dictionary.englishWords.add("quirk");       
        Dictionary.englishWords.add("jumbo");
        Dictionary.validWordleGuesses = Dictionary
                .get5LetterWords(Dictionary.englishWords);
        System.out.println(Dictionary.validWordleGuesses);
        assertEquals(2, Dictionary.validWordleGuesses.size());
        assertEquals("jumbo", Dictionary.validWordleGuesses.get(1));
    }

    @Test
    void testCaseSensitivity() {
        Dictionary.validWordleGuesses.add("facts");
        assertFalse(Dictionary.isValidGuess("FACTS"));
    }

}
