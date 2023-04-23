package com.markurion.workmeout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SessionActivity extends AppCompatActivity {

    CardView cardSession, 
            cardWorkoutHistory, 
            cardImagesList, 
            cardCaptureImage, 
            cardCalendar, 
            cardGymEQ,
            cardTransitions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        initialize();

        cardSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SessionActivity.this, "This", Toast.LENGTH_SHORT).show();
            }
        });

        cardWorkoutHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SessionActivity.this,ListSessionActivity.class);
                startActivity(i);
            }
        });

        cardImagesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SessionActivity.this, ListImagesActivity.class);
                startActivity(i);
            }
        });

        cardCaptureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SessionActivity.this, CaptureActivity.class);
                startActivity(i);
            }
        });

        cardCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SessionActivity.this, CalendarActivity.class);
                startActivity(i);
            }
        });

        cardGymEQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SessionActivity.this, FlipperActivity.class);
                startActivity(i);
            }
        });

        cardTransitions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent i = new Intent(SessionActivity.this, TransActivity.class);
                    startActivity(i);
                    //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_right);
                    overridePendingTransition(1,2);
                }catch(Exception e){
                    Log.d(" ee ", e.getMessage());
                }
            }

        });
    }

    protected void initialize(){
        cardSession = findViewById(R.id.session_card_start_session);
        cardWorkoutHistory = findViewById(R.id.session_card_history_session);
        cardImagesList = findViewById(R.id.session_image_list_card);
        cardCaptureImage = findViewById(R.id.session_image_capture_card);
        cardCalendar = findViewById(R.id.session_calendar_card);
        cardGymEQ = findViewById(R.id.session_flipper_card);
        cardTransitions = findViewById(R.id.session_transitions_card);
    }
}