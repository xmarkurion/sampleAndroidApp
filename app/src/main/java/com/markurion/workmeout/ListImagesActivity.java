package com.markurion.workmeout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListImagesActivity extends AppCompatActivity {

    private ArrayList<String> names;
    private ArrayList<Integer> images;

    private ListView list;
    private MyAdapter myAdapter;

    private void init(){
        list = findViewById(R.id.id_list);

        names = new ArrayList<>();
        names.add("First image");
        names.add("2nd image");
        names.add("3rd image");
        names.add("4th image");
        names.add("5th image");

        images = new ArrayList<>();
        images.add(R.drawable.gymnastic_icon);
        images.add(R.drawable.screen_play);
        images.add(R.drawable.vector_card_membership);

        myAdapter = new MyAdapter();
        list.setAdapter(myAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_images);
        init();
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup ViewGroup) {
            view = getLayoutInflater().inflate(R.layout.my_card, ViewGroup, false);
            ImageView myImageView = view.findViewById(R.id.my_card_ImgView);
            TextView myTextView = view.findViewById(R.id.my_card_textView);

            myImageView.setImageResource(images.get(position));
            myTextView.setText(names.get(position));
            return view;
        }
    }

}



