package com.markurion.workmeout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ListSessionActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter listAdapter;
    private ArrayList<String> sessionsArr;
    private int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_session);
        init();
        addmoreInTime();
    }

    private void init(){
        listView = findViewById(R.id.listSessions);
        sessionsArr = new ArrayList<>();
        sessionsArr.add("TODAY");
        sessionsArr.add("Tomorow");
        sessionsArr.add("etc");
        sessionsArr.add("etc");
        sessionsArr.add("etc");
        sessionsArr.add("etc");
        sessionsArr.add("etc");


        listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sessionsArr);
        listView.setAdapter(listAdapter);

        listAdapter.add("Telegraph");

    }


    private void addmoreInTime(){
        Timer t = new Timer();
        x = 0;
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                ListSessionActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        x++;
                        listAdapter.add("New Item: " + x);
                    }
                });
            }
        };
        t.schedule(tt,0,500);
    }


}