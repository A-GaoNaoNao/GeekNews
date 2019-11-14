package com.example.geeknews.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.geeknews.R;

public class Ri_Web_Activity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ri__web_);

        initView();
    }

    private void initView() {
        web = findViewById(R.id.web_ri);

        Intent intent = getIntent();
        String url_ri = intent.getStringExtra("url_ri");

        web.loadUrl(url_ri);
        web.setWebViewClient(new WebViewClient());
    }
}
