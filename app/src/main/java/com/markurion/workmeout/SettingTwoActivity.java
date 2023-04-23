package com.markurion.workmeout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class SettingTwoActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btn;

    ConstraintLayout lt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_two);
        getSupportActionBar().setTitle("Radio Buttons Example");
        radioGroup = findViewById(R.id.radioGroup);
        btn = findViewById(R.id.setting_two_btn);
        lt = findViewById(R.id.setting_two_layout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
    }

    private void check(){
        if(radioGroup.getCheckedRadioButtonId() == R.id.rb1){
            lt.setBackgroundColor(Color.RED);
        }

        if(radioGroup.getCheckedRadioButtonId() == R.id.rb2){
            lt.setBackgroundColor(Color.BLUE);
        }

        if(radioGroup.getCheckedRadioButtonId() == R.id.rb3){
            lt.setBackgroundColor(Color.GREEN);
        }

        if(radioGroup.getCheckedRadioButtonId() == R.id.rb4){
            lt.setBackgroundColor(Color.YELLOW);
        }

        if(radioGroup.getCheckedRadioButtonId() == R.id.rb5){
            lt.setBackgroundColor(Color.GRAY);
        }

    }
}