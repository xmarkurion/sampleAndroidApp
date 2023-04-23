package com.markurion.workmeout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        getSupportActionBar().setTitle("Calendar Activity ");

        textView = findViewById(R.id.calendar_textView);
        calendarView = findViewById(R.id.calendar_calendarView);

        textView.setText("Select workout date... ");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String myDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                textView.setText(myDate);
            }
        });
    }
}