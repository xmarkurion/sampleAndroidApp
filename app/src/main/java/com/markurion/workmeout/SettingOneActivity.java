package com.markurion.workmeout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingOneActivity extends AppCompatActivity {

    TextView tx;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_one);
        getSupportActionBar().setTitle("Text From Another View");
         tx = findViewById(R.id.settingOne_TextView);
         back = findViewById(R.id.settingOne_btn_back);

         try{
             Bundle extracts = getIntent().getExtras();
             String text = extracts.getString("enteredText");
             tx.setText("->: " + text);
         }catch (RuntimeException e){
             e.getSuppressed();
         }

         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onBackPressed();
             }
         });
    }
}