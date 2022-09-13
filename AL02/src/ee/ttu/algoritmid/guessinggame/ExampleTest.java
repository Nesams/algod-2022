package ee.ttu.algoritmid.guessinggame;
import java.util.Arrays;

public class ExampleTest {

    public static final void testExampleNoteArray() throws Exception {
        Note[] array = {new Note("A 3", 220.00),
                new Note("A 4", 440.00),
                new Note("E 4", 329.63),
                new Note("Dis 5", 622.25),
                new Note("G 2", 98.00),
                new Note("Es 7", 2489.02),
                new Note("C 3", 130.81),
                new Note("B 3", 246.94)
        };
        final Note correct = array[1];
        Teacher oracle = new Teacher(correct);
        GuessingGame nm = new GuessingGame(oracle);
        Note[] copy = Arrays.copyOf(array, array.length);
        final boolean guessResult = nm.play(copy).equals(correct.getName());
        if (!guessResult) {
            System.err.println("Your solution did not guess correctly.");
        } else {
            System.out.println("Your solution guessed the note correctly. However, get sure it is fast enough.");
        }
    }

    public static void main(String[] args) {
        try {
            testExampleNoteArray();
        } catch (Exception ignored) {
        }
    }
}
