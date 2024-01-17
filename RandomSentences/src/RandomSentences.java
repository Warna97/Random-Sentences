
import java.util.Random;

public class RandomSentences {

    // Arrays for different word categories
    private static final String[] properNouns = {"Fred", "Jane", "Richard Nixon", "Miss America"};
    private static final String[] commonNouns = {"man", "woman", "fish", "elephant", "unicorn"};
    private static final String[] determiners = {"a", "the", "every", "some"};
    private static final String[] adjectives = {"big", "tiny", "pretty", "bald"};
    private static final String[] intransitiveVerbs = {"runs", "jumps", "talks", "sleeps"};
    private static final String[] transitiveVerbs = {"loves", "hates", "sees", "knows", "looks for", "finds"};
    private static final String[] conjunctions = {"and", "or", "but", "because"};

    // Random object for selecting random elements
    private static final Random random = new Random();

    /**
     * Generates a random sentence following the grammar rules.
     *
     * @return A randomly generated sentence.
     */
    public static String generateSentence() {
        return generateSimpleSentence() + (random.nextBoolean() ? " " + getRandomElement(conjunctions) + " " + generateSentence() : "");
    }

    /**
     * Generates a simple sentence following the grammar rules.
     *
     * @return A randomly generated simple sentence.
     */
    private static String generateSimpleSentence() {
        return generateNounPhrase() + " " + generateVerbPhrase();
    }

    /**
     * Generates a noun phrase following the grammar rules.
     *
     * @return A randomly generated noun phrase.
     */
    private static String generateNounPhrase() {
        String nounPhrase = getRandomElement(properNouns);
        if (random.nextBoolean()) {
            nounPhrase = getRandomElement(determiners) + (random.nextBoolean() ? " " + getRandomElement(adjectives) : "") + " " +
                    getRandomElement(commonNouns) + (random.nextBoolean() ? " who " + generateVerbPhrase() : "");
        }
        return nounPhrase;
    }

    /**
     * Generates a verb phrase following the grammar rules.
     *
     * @return A randomly generated verb phrase.
     */
    private static String generateVerbPhrase() {
        String verbPhrase;
        switch (random.nextInt(4)) {
            case 0:
                verbPhrase = getRandomElement(intransitiveVerbs);
                break;
            case 1:
                verbPhrase = getRandomElement(transitiveVerbs) + " " + generateNounPhrase();
                break;
            case 2:
                verbPhrase = "is " + getRandomElement(adjectives);
                break;
            default:
                verbPhrase = "believes that " + generateSimpleSentence();
        }
        return verbPhrase;
    }

    /**
     * Helper method to retrieve a random element from an array.
     *
     * @param array The array from which to select a random element.
     * @return A randomly selected element from the array.
     */
    private static String getRandomElement(String[] array) {
        return array[random.nextInt(array.length)];
    }

    public static void main(String[] args) {
        // Generate and print a random sentence
        String randomSentence = generateSentence();
        System.out.println("Random Sentence: " + randomSentence);
    }
}

