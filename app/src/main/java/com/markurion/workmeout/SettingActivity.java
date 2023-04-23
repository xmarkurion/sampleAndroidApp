package com.markurion.workmeout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    private EditText edit;
    private Button btn,radioBtn, call, website,email ,sms, sound;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_settings_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menuBar_exit){
            this.finishAffinity();
        }

        if(id == R.id.menuBar_info){
            Toast.makeText(this, "This app is nice...", Toast.LENGTH_SHORT).show();
        }

        if(id == R.id.menuBar_setBrightness){
            WindowManager.LayoutParams layout = getWindow().getAttributes();
            layout.screenBrightness = 1F;
            getWindow().setAttributes(layout);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setTitle("Settings");

        initialize();
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emeil = new Intent(Intent.ACTION_SEND);
                emeil.setType("message/rfc822");
                emeil.putExtra(Intent.EXTRA_EMAIL, new String[]{"tom@ait.ie"});
                emeil.putExtra(Intent.EXTRA_SUBJECT, "This will be my title");
                emeil.putExtra(Intent.EXTRA_TEXT, "Yes this will be the body of my email");

                startActivity(Intent.createChooser(emeil, "Send mail using: "));
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:0234543454");
                Intent msg = new Intent(Intent.ACTION_SENDTO,uri);
                msg.putExtra("sms_body", "I need more information please contact me.");
                startActivity(Intent.createChooser(msg, "Send sms using: "));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this,SettingOneActivity.class);
                i.putExtra("enteredText",edit.getText().toString());
                startActivity(i);
                }
        });

        radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this,SettingTwoActivity.class);
                startActivity(i);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + "1234567"));
                if (i.resolveActivity(getPackageManager())!= null){
                    startActivity(i);
                }
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://myanimelist.net/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(SettingActivity.this, R.raw.bell);
                mp.start();
                Toast.makeText(SettingActivity.this, "Sound is playing in bg...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void initialize(){
        edit = findViewById(R.id.setting_EditText);
        btn = findViewById(R.id.setting_btn_set);
        radioBtn = findViewById(R.id.setting_btn_radio);
        call = findViewById(R.id.setting_btn_call);
        website = findViewById(R.id.setting_open_browser);
        sms = findViewById(R.id.setting_btn_sms);
        email = findViewById(R.id.setting_btn_email);
        sound = findViewById(R.id.btn_play_sound);
    }
}