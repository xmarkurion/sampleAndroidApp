package com.markurion.workmeout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView mainText;
    private TextView precentText;
    private ProgressBar progressBar;

    private final static String[] words = {
            "Host", "Making","Slice", "Prepare", "WarmingUp", "4chan", "Epic", "Something",
            "Still", "A little bit more", "Done or not..", "Pizza", "Pasta", "Salad", "Burger",
            "Tacos", "Guitar", "Piano", "Drums", "Bass", "Violin", "Soccer", "Basketball",
            "Tennis", "Volleyball", "Football", "Beach", "Mountain", "City", "Countryside",
            "Desert", "Comedy", "Drama", "Action", "Romance", "Horror", "Math", "Science",
            "History", "English", "Art", "Hiking", "Camping", "Fishing", "Biking", "Kayaking",
            "Croissant", "Bagel", "Muffin", "Donut", "Toast", "Spring", "Summer", "Fall", "Winter",
            "Monsoon", "Red", "Blue", "Green", "Yellow", "Purple"
    };
    private String word;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        // Hide Title Bar
        this.hideProgressBar();
        setContentView(R.layout.activity_main);
        this.pointToElements();
        this.setRandomText();

        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(counter);
                        if(counter % 5 == 0) setRandomText();
                        precentText.setText("" + counter + "%");
                    }
                });

                counter+= 4;

                //Splash screen override
                counter=100;

                if(counter == 100) {
                    t.cancel();
                    finish();
                    Intent i = new Intent(MainActivity.this,MenuActivity.class);
                    startActivity(i);
                }
            }
        };
        t.schedule(tt,0,200);

    }

    private void pointToElements(){
        mainText = findViewById(R.id.main_textView);
        precentText = findViewById(R.id.main_textView_precent);
        progressBar = findViewById(R.id.main_progressBar);
    }

    private void setRandomText(){
        word = words[(int) (Math.random() * words.length)];
        mainText.setText(word);
    }

    private void hideProgressBar(){
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }
}