package com.example.geeknews.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.geeknews.R;

public class Re_Web_Activity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re__web_);

        initView();
    }

    private void initView() {
        web = findViewById(R.id.web_re);
        Intent intent = getIntent();
        String url_re = intent.getStringExtra("url_re");
        web.loadUrl(url_re);
        web.setWebViewClient(new WebViewClient());
    }
}
