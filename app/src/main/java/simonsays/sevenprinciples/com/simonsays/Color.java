package simonsays.sevenprinciples.com.simonsays;

/**
 * Created by manuel on 26.04.16.
 */
public enum Color {
    RED('r', R.raw.red),
    GREEN('g', R.raw.green),
    YELLOW('y', R.raw.yellow),
    BLUE('b', R.raw.blue);

    private char firstLetter;
    private int soundFileResource;

    Color(char firstLetter, int soundFileResource) {
        this.firstLetter = firstLetter;
        this.soundFileResource = soundFileResource;
    }

    char getFirstLetter() {
        return firstLetter;
    }

    int getSoundFileResource() { return soundFileResource; }

}