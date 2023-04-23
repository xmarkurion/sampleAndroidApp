package com.markurion.workmeout;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Bundle;

import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MembershipActivity extends AppCompatActivity {

    private String TAG = "MembershipActivity";
    private Button btn_back, btn_path, btn_light;
    private ImageView img;
    private TextView textView_path;
    private SharedPreferences image_database;

    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // Activity result code
    //https://developer.android.com/training/data-storage/shared/photopicker

    // Registers a photo picker activity launcher in single-select mode.
    ActivityResultLauncher<PickVisualMediaRequest> pickMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);
        this.getSupportActionBar().setTitle("My Membership Card");

        //Initialize gui component's
        img = findViewById(R.id.membership_img_barcode);
        btn_light = findViewById(R.id.membership_brightness);
        btn_back = findViewById(R.id.membership_btn_back);
        btn_path = findViewById(R.id.membership_btn_path);
        textView_path = findViewById(R.id.membership_textView_path);

        //Initialize image picker
        pickMedia = actResult();

        //Set Table with data
        image_database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);

        //Check if there is a value stored.
        checkData();
        setBrightness();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });

        btn_path.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This does make red underline but at the end works ... Android Logic
                ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = (ActivityResultContracts.PickVisualMedia.VisualMediaType) ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE;
                pickMedia.launch(new PickVisualMediaRequest.Builder().setMediaType(mediaType).build());
            }
        });

        btn_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBrightness();
            }
        });

    }

    /**
     * @return ActivityResultLauncher for picking image.
     */
    protected ActivityResultLauncher<PickVisualMediaRequest> actResult(){
        return registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
                    // Callback is invoked after the user selects a media item or closes the
                    // photo picker.
                    if (uri != null) {
                        // Access the media file using the Uri
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(uri);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }

                        // Take persistable permissions for the Uri  ( Thanks by this your phone does not forget the pictures )
                        int takeFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION;
                        getContentResolver().takePersistableUriPermission(uri, takeFlags);

                        Log.d(TAG + "PhotoPicker", "Selected URI: " + uri.getPath());

                        storeImageURI(uri);
                        checkData();
                    } else {
                        Log.d(TAG + "PhotoPicker", "No media selected");
                    }
                });
    }

    protected void storeImageURI(Uri uri){
        SharedPreferences.Editor editor = image_database.edit();
        editor.putString("gym_card", uri.toString());
        editor.putString("card_updated_at" , nowDateToString());
        editor.apply();
    }

    protected void checkData(){
        checkIfImageIsStored();
        checkIfDateIsStored();
    }

    protected void checkIfImageIsStored(){
        try {
            String stored = image_database.getString("gym_card", null);
            Log.d(TAG + " stored", stored);
            Uri image_from_db = Uri.parse(stored);
            img.setImageURI(image_from_db);

        }catch (java.lang.NullPointerException e){

        }
    }

    protected void checkIfDateIsStored(){
        try {
            String stored = image_database.getString("card_updated_at", "Image Was never picked.");
            textView_path.setText(stored);

        }catch (Exception e){
            Log.d(TAG + " timeString: ", e.getMessage());
        }
    }

    protected String nowDateToString(){
        Date date = new Date();
        Timestamp now = new Timestamp(date.getTime());
        String readableDate = sdf.format(date.getTime());
        Log.d(TAG + " Date now: ", readableDate);
        return readableDate;
    }

    protected void setBrightness() {
        WindowManager.LayoutParams layout = getWindow().getAttributes();
        layout.screenBrightness = 1F;
        getWindow().setAttributes(layout);
    }


}