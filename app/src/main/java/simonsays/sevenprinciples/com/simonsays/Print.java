package simonsays.sevenprinciples.com.simonsays;

import android.content.Context;
import android.util.Log;

/**
 * Created by manuel on 26.04.16.
 */
public class Print {

    private static final String TAG = Print.class.getSimpleName();
    private final Context context;

    Print(Context context) {
        this.context = context;
    }

    public void printChooseOfColors(StringBuffer colorsOfPlayer1, StringBuffer colorsOfPlayer2) {
        Log.d(TAG, "_______________________");
        Log.d(TAG, context.getString(R.string.player1) + ": " + getColors(colorsOfPlayer1.toString()));
        Log.d(TAG, context.getString(R.string.player2) + ": " + getColors(colorsOfPlayer2.toString()));
    }

    public String getColors(String manyFirstLetters) {
        StringBuffer colors = new StringBuffer();
        for (char firstLetter : manyFirstLetters.toCharArray()) {
            switch (firstLetter) {
                case 'r':
                    colors.append(Color.RED.toString() + " ");
                    break;
                case 'g':
                    colors.append(Color.GREEN.toString() + " ");
                    break;
                case 'y':
                    colors.append(Color.YELLOW.toString() + " ");
                    break;
                case 'b':
                    colors.append(Color.BLUE.toString() + " ");
                    break;
            }
        }
        return colors.toString();
    }
}
