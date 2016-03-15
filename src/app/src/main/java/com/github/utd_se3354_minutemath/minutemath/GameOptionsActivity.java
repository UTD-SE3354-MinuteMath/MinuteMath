package com.github.utd_se3354_minutemath.minutemath;

/*
 * Copyright (c) 2016 UTD-SE3354-MinuteMath
 *
 * Permission to use, copy, modify, and/or distribute this software
 * for any purpose with or without fee is hereby granted,
 * provided that the above copyright notice and this permission notice
 * appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS"
 * AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE
 * INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES
 * OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS,
 * WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION,
 * ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


public class GameOptionsActivity extends ActionBarActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private Game activeGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameoptions);

        mDrawerList = (ListView)findViewById(R.id.navList);mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        TextView game_selected_text = (TextView)findViewById(R.id.textView10);



        //Build the drawers and setup links
        addDrawerItems();
        setupDrawer();
        setupListeners();
        setupScreen();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    private void setupScreen(){
        // Restore preferences
        // Get from the SharedPreferences
        SharedPreferences settings = getApplicationContext().getSharedPreferences(getString(R.string.pref_file), 1);

        //Recover Selected Object
        this.activeGame = (Game) getIntent().getSerializableExtra("Game");

        final NumberPicker np = (NumberPicker)findViewById(R.id.numberPicker);
        np.setMaxValue(20); // max value 100
        np.setMinValue(1);   // min value 0
        np.setWrapSelectorWheel(false);

        final NumberPicker timeSettingChooser = (NumberPicker)findViewById(R.id.numberPicker2);
        timeSettingChooser.setMaxValue(5); // max value 100
        timeSettingChooser.setMinValue(1);   // min value 0
        timeSettingChooser.setWrapSelectorWheel(false);
        timeSettingChooser.setEnabled(false);

    }
    private void setupListeners(){
        // Restore preferences
        final Button buttonToggle = (Button) findViewById(R.id.toggleButton);
        final TextView timeSettingText = (TextView) findViewById(R.id.textView7);
        final NumberPicker timeSettingChooser = (NumberPicker) findViewById(R.id.numberPicker2);
        buttonToggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                activeGame.setTimed(!activeGame.getTimed());
                timeSettingChooser.setEnabled(activeGame.getTimed());
            }
        });
    }

    private void addDrawerItems() {
        String[] itemArray = {"Main Menu", "Profile", "Games", "Tutorials"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemArray);
        mDrawerList.setAdapter(mAdapter);
        final Intent mainIntent = new Intent(this, MainActivity.class);
        final Intent profileIntent = new Intent(this, ProfileActivity.class);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position ==0)
                    startActivity(mainIntent);
                else if(position == 1)
                    startActivity(profileIntent);
                else
                    Toast.makeText(GameOptionsActivity.this, "Feature Not yet Available", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("App Navigation");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}