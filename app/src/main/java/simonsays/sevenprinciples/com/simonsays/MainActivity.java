package simonsays.sevenprinciples.com.simonsays;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Simon Says
 * <p>
 * Created by Manuel Schmidt, Pia Rosenbuam, Clara Hartmann on 28/04/2016.
 * Copyright © 2016 Manuel Schmidt. All rights reserved.
 */
public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private StringBuffer colorsOfPlayer1;
    private StringBuffer colorsOfPlayer2;

    // Text
    @Bind(R.id.playerLabel) TextView playerLabelText;

    // Buttons
    @Bind(R.id.RotButton)
    Button Grün;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        startNewGame();
    }

    // click on red, green, yellow, blue button
    @OnClick({R.id.RotButton, R.id.GrünButton, R.id.GelbButton, R.id.BlauButton})
    protected void onCickButton(View view) {
        Log.d(TAG, view.getTag() + " button was clicked");

        // get current color and play sound of them
        Color currentColor = Color.valueOf(view.getTag().toString());
        Sound.playSound(getApplicationContext(), currentColor.getSoundFileResource());

        gameLogic(currentColor);
    }

    private void gameLogic(Color currentColor) {
        if (colorsOfPlayer1.length() == 4) {
            colorsOfPlayer2.append(currentColor.getFirstLetter());

            if (colorsOfPlayer2.length() == 4) {
                checkTheResult();

                // print results
                Print print = new Print(getApplicationContext());
                print.printChooseOfColors(colorsOfPlayer1, colorsOfPlayer2);

                startNewGame();
            }
        } else if (colorsOfPlayer2.length() == 0) {
            if (colorsOfPlayer1.length() == 3) {
                playerLabelText.setText(R.string.player2);
            }
            colorsOfPlayer1.append(currentColor.getFirstLetter());
        }
    }

    private void startNewGame() {
        colorsOfPlayer1 = new StringBuffer();
        colorsOfPlayer2 = new StringBuffer();
        playerLabelText.setText(R.string.player1);
    }

    private void checkTheResult() {
        if (colorsOfPlayer1.toString().equals(colorsOfPlayer2.toString())) {
            Sound.playSound(getApplicationContext(), R.raw.clara_pia_win);
            showDialog(getString(R.string.right), android.R.drawable.ic_dialog_info);

        } else {
            Sound.playSound(getApplicationContext(), R.raw.clara_pia_lose);
            showDialog(getString(R.string.fail), android.R.drawable.ic_dialog_alert);
        }
    }

    private void showDialog(final String messageText, final int icon) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_title))
                .setMessage(messageText)
                .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startNewGame();
                    }
                })
                .setIcon(icon)
                .show();
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}