package simonsays.sevenprinciples.com.simonsays;

/**
 * Created by manuel on 26.04.16.
 */
public enum Color {
    RED('r', R.raw.clara_pia_rot),
    GREEN('g', R.raw.clara_pia_gruen),
    YELLOW('y', R.raw.clara_pia_gelb),
    BLUE('b', R.raw.clara_pia_blau);

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