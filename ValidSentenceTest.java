import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidSentenceTest {

    @Test
    void validSentenceWithProperFormat() {
        String sentence = "This is a valid sentence.";
        assertTrue(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void invalidSentenceStartsWithLowerCase() {
        String sentence = "invalid sentence starts with lowercase.";
        assertFalse(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void invalidSentenceWithOddQuotationMarks() {
        String sentence = "This has an odd \"number of quotes.";
        assertFalse(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void invalidSentenceWithoutTerminationCharacter() {
        String sentence = "This sentence does not end properly";
        assertFalse(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void invalidSentenceWithPeriodsInTheMiddle() {
        String sentence = "This. Sentence. Has. Periods. In. The. Middle.";
        assertFalse(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void invalidSentenceNumberBefore13NotSpelledOut() {
        String sentence = "There are 10 apples and 5 oranges.";
        assertFalse(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void validSentenceNumber13OrGreater() {
        String sentence = "There are thirteen apples.";
        assertTrue(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void validSentenceWithQuotes() {
        String sentence = "This sentence has \"quotes\" in it.";
        assertTrue(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void validSentenceWithQuestionMark() {
        String sentence = "Is this a valid sentence?";
        assertTrue(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void validSentenceWithExclamationMark() {
        String sentence = "This is a valid sentence!";
        assertTrue(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void validSentenceWithMultipleSpaces() {
        String sentence = "This    is    a    valid    sentence.";
        assertTrue(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void validSentenceWithSingleCharacter() {
        String sentence = "A.";
        assertTrue(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void validSentenceWithEmptyString() {
        String sentence = "";
        assertFalse(ValidSentence.isValidSentence(sentence));
    }

    @Test
    void validSentenceWithSingleCharacterAndExclamationMark() {
        String sentence = "!";
        assertTrue(ValidSentence.isValidSentence(sentence));
    }
}
