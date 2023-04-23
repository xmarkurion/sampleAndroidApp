package com.markurion.workmeout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class FlipperActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private Button btu_next, btu_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper);
        getSupportActionBar().setTitle("Flipper showcase");

        btu_next = findViewById(R.id.flipper_btu_next);
        btu_prev = findViewById(R.id.flipper_btu_prev);
        viewFlipper = findViewById(R.id.view_flipper);

        btu_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setInAnimation(FlipperActivity.this,R.anim.slide_in_left);
                viewFlipper.setOutAnimation(FlipperActivity.this,R.anim.slide_out_right);
                viewFlipper.showNext();
            }
        });

        btu_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setInAnimation(FlipperActivity.this,R.anim.slide_in_right);
                viewFlipper.setOutAnimation(FlipperActivity.this,R.anim.slide_out_left);
                viewFlipper.showPrevious();
            }
        });

    }
}