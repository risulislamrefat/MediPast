package com.example.user.bitmmidprojecttest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public ImageView imageView;
    public DBManagerImage dbManagerImage;
    public HistoryAdapter historyAdapter;
    public LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerViewId);
        dbManagerImage = new DBManagerImage(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Intent intent = getIntent();

        ArrayList<History> historyList = dbManagerImage.getAllImages();
        historyAdapter = new HistoryAdapter(this,historyList);
        recyclerView.setAdapter(historyAdapter);
    }
}
