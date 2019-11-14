package com.example.geeknews.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.geeknews.R;

public class Ios_Web_Activity extends AppCompatActivity {

    public Toolbar toolbar;
    public WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ios__web_);

        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar_ios);
        web = findViewById(R.id.web_ios);

        Intent intent = getIntent();
        String url_ios = intent.getStringExtra("url_ios");
        String desc_ios = intent.getStringExtra("desc_ios");
        web.loadUrl(url_ios);
        web.setWebViewClient(new WebViewClient());

        toolbar.setTitle(desc_ios);
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
