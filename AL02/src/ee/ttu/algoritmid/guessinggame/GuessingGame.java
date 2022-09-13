package ee.ttu.algoritmid.guessinggame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class GuessingGame {

    Teacher teacher;

    public GuessingGame(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * @param noteArray - All the possible notes.
     * @return the name of the note.
     */
    public String play(Note[] noteArray) {
        Arrays.sort(noteArray, Comparator.comparing(Note::getFrequency));
        int startIndex = 0;
        int endIndex = noteArray.length - 1;
        int guessIndex = (startIndex + endIndex) / 2;
        String answerNote = teacher.isIt(noteArray[guessIndex]);

        while (!Objects.equals(answerNote, "exactly!")) {
            if (Objects.equals(answerNote, "lower")) {
                endIndex = guessIndex - 1;
            }
            else {
                startIndex = guessIndex + 1;
            }
            guessIndex = (startIndex + endIndex) / 2;
            answerNote = teacher.isIt(noteArray[guessIndex]);
        }
        return noteArray[guessIndex].getName();
    }
}