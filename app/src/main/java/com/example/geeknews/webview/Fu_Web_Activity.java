package com.example.geeknews.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.geeknews.R;

public class Fu_Web_Activity extends AppCompatActivity {

    public Toolbar toolbar;
    public ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fu__web_);

        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar_fu);
        iv = findViewById(R.id.iv_fuli);

        Intent intent = getIntent();
        String url_fu = intent.getStringExtra("url_fu");
        Glide.with(this).load(url_fu).into(iv);

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
