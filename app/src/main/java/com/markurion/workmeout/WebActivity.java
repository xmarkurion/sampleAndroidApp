package com.markurion.workmeout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebActivity extends AppCompatActivity {

    private EditText url;
    private Button btn;
    private String strurl = "https://moodle.ait.ie/";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        getSupportActionBar().setTitle("AKA. Web Browser");
        url = findViewById(R.id.web_editText_web);
        webView = findViewById(R.id.web_webWiew);
        btn = findViewById(R.id.web_btn_go);
        url.setText(strurl);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(strurl);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(String.valueOf(url.getText()));
            }
        });
    }
}