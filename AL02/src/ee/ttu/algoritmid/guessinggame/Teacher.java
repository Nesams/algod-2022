package ee.ttu.algoritmid.guessinggame;
public class Teacher {

    private Note note;

    public Teacher(Note note) {
        this.note = note;
    }

    /**
     * @param noteGuess - note you think is correct
     * @return
     *     "higher" if correct note is higher than your guess
     *     "lower" if correct note is lower than your guess
     *     "exactly!" if your guess is correct
     */
    public String isIt(Note noteGuess) {
        if (this.note.getFrequency() > noteGuess.getFrequency()) {
            return "higher";
        } else if (this.note.getFrequency() < noteGuess.getFrequency()) {
            return "lower";
        }
        return "exactly!";
    }
}