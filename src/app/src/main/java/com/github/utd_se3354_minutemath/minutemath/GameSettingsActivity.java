package com.github.utd_se3354_minutemath.minutemath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;

public class GameSettingsActivity extends AppCompatActivity {
    public static final String GAME_SETTINGS = "com.github.utd_se3354_minutemath.minutemath.SETTINGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //function to send an intent with the game settings
    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        int duration = ((NumberPicker) findViewById(R.id.duration)).getValue();
        int problems = ((NumberPicker) findViewById(R.id.number_of_problems)).getValue();
        int min = ((NumberPicker) findViewById(R.id.range_min)).getValue();
        int max = ((NumberPicker) findViewById(R.id.range_max)).getValue();
        int [] settings = {duration, problems, min, max};
        intent.putExtra(GAME_SETTINGS, settings);
        startActivity(intent);
    }
}
