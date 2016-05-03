package simonsays.sevenprinciples.com.simonsays;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Simon Says
 * <p>
 * Created by Manuel Schmidt on 28/04/2016.
 * Copyright © 2016 Manuel Schmidt. All rights reserved.
 */
public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    // Buttons
    // ToDo: define and initizialise buttons
    @Bind(R.id.RotButton)
    Button Grün;

    private StringBuffer colorsOfPlayer1;
    private StringBuffer colorsOfPlayer2;

    @OnClick (R.id.RotButton)
    protected void Nutella(View view) {
        String message = "Hallöchen";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //startNewGame();
    }

    // click on red, green, yellow, blue button
    @OnClick({R.id.RotButton, R.id.GrünButton, R.id.GelbButton, R.id.BlauButton})
    protected void onCickButton(View view) {
        Log.d(TAG, view.getTag() + " button was clicked");

        // get current color and play sound of them
        Color currentColor = Color.valueOf(view.getTag().toString());
        Sound.playSound(getApplicationContext(), currentColor.getSoundFileResource());

        gameLogic();
    }

    private void gameLogic(Color currentColor) {
        if(colorsOfPlayer1.length() == 4){
            colorsOfPlayer2.append(currentColor.getFirstLetter());
            if (colorsOfPlayer2.length()==4){
                checkTheResult();
                Print print = new Print (getApplicationContext());
                print.printChooseOfColors(colorsOfPlayer1, colorsOfPlayer2);
                startNewGame();
            }
        }
    }

    // click on new game button
    @OnClick(R.id.newGameButton)
    protected void clickOnNewGameButton(View view) {
        Log.d(TAG, "start new game");
        startNewGame();
    }

    private void startNewGame() {
        colorsOfPlayer1 = new StringBuffer();
        colorsOfPlayer2 = new StringBuffer();
        playerLabelText.setText(R.string.player1);
    }

    private void checkTheResult() {
        // Todo
    }

    private void showDialog(final String messageText, final int icon) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_title))
                .setMessage(messageText)
                .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        /* startNewGame(); */
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