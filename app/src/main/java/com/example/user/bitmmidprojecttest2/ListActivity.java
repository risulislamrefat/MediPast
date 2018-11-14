package com.example.user.bitmmidprojecttest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    private DoctorAdapter doctorAdapter;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);
        dbManager = new DBManager(this);

        ArrayList<Doctor> doctorsList = dbManager.getAllStudent();
        doctorAdapter = new DoctorAdapter(this,doctorsList);
        listView.setAdapter(doctorAdapter);
    }
}
