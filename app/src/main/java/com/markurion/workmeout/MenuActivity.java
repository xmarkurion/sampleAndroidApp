package com.markurion.workmeout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout card, session, play, maps, web, setting;
    private ConstraintLayout mainLayout;
//    @Override
//    public void onBackPressed() {
//        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideProgressBar();
        setContentView(R.layout.activity_menu);
        setupAll();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        card.setOnClickListener(view -> {
            Intent i = new Intent(MenuActivity.this,MembershipActivity.class);
            startActivity(i);
                });
        play.setOnClickListener(view -> {
            Intent i = new Intent(MenuActivity.this,YoutubeActivity.class);
            startActivity(i);
        });
        maps.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo:53.419584,-7.906455"));
            startActivity(i);
        });
        web.setOnClickListener(view -> {
            Intent i = new Intent(MenuActivity.this,WebActivity.class);
            startActivity(i);
        });
        setting.setOnClickListener(view -> {
            Intent i = new Intent(MenuActivity.this,SettingActivity.class);
            startActivity(i);
        });
        session.setOnClickListener(view -> {
            Intent i = new Intent(MenuActivity.this, SessionActivity.class);
            startActivity(i);
        });
    }

    private void setupAll(){
        session = findViewById(R.id.main_layout_sessions);
        card = findViewById(R.id.main_layout_card);
        play = findViewById(R.id.main_layout_play);
        maps = findViewById(R.id.main_layout_map);
        web = findViewById(R.id.main_layout_web);
        setting = findViewById(R.id.main_layout_setting);
        mainLayout = findViewById(R.id.menu_constrainLayout);
    }

    private void hideProgressBar(){
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }

}
