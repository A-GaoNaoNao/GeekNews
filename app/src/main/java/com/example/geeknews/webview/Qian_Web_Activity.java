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

public class Qian_Web_Activity extends AppCompatActivity {

    public Toolbar toolbar;
    public WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qian__web_);

        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar_qian);
        web = findViewById(R.id.web_qian);

        Intent intent = getIntent();
        String url_qian = intent.getStringExtra("url_qian");
        String desc_qian = intent.getStringExtra("desc_qian");

        web.loadUrl(url_qian);
        web.setWebViewClient(new WebViewClient());

        toolbar.setTitle(desc_qian);

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
