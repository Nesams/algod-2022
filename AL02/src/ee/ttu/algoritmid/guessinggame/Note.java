package ee.ttu.algoritmid.guessinggame;
public class Note {
    private String name;
    private double frequency;

    public Note(String name, double frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public String getName() {
        return this.name;
    }

    public double getFrequency() {
        return this.frequency;
    }
}