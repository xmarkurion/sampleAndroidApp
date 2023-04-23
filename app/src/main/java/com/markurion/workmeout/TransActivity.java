package com.markurion.workmeout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TransActivity extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        getSupportActionBar().setTitle("See Transition in Action");


        back = findViewById(R.id.trans_btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void finish(){
        super.finish();
        //overridePendingTransition(R.transition.slide_in_left, R.transition.slide_out_right);
    }
}