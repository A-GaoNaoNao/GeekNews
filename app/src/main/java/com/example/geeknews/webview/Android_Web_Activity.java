package com.example.geeknews.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.geeknews.R;

public class Android_Web_Activity extends AppCompatActivity {

    public WebView web;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android__web_);

        initView();
    }

    private void initView() {
        web = findViewById(R.id.web_android);
        toolbar = findViewById(R.id.toolbar_android);


        Intent intent = getIntent();
        String url_android = intent.getStringExtra("url_android");
        String url_desc = intent.getStringExtra("url_desc");
        web.loadUrl(url_android);
        web.setWebViewClient(new WebViewClient());

        toolbar.setTitle(url_desc);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
