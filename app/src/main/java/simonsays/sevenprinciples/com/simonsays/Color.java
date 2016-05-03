package simonsays.sevenprinciples.com.simonsays;

/**
 * Created by manuel on 26.04.16.
 */
public enum Color {
    RED('r', R.raw.johanna_lara_rot),
    GREEN('g', R.raw.johanna_lara_gruen),
    YELLOW('y', R.raw.johanna_lara_gelb),
    BLUE('b', R.raw.johanna_lara_blau);

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