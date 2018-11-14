package com.example.user.bitmmidprojecttest2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name,details,appointment,phone,email;
    Button addButton,viewBtn;
    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameEt);
        details = findViewById(R.id.detailsEt);
        appointment = findViewById(R.id.appointmentEt);
        phone = findViewById(R.id.phoneEt);
        email = findViewById(R.id.emailEt);

        addButton = findViewById(R.id.addBtn);
        viewBtn = findViewById(R.id.viewBtn);

        DBHelper dbHelper = new DBHelper(this);
        dbManager = new DBManager(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameEt = name.getText().toString();
                String detailsEt = details.getText().toString();
                String appointmentEt = appointment.getText().toString();
                String phoneEt = phone.getText().toString();
                String emailEt =  email.getText().toString();

                Doctor doctor = new Doctor(nameEt,detailsEt,appointmentEt,phoneEt,emailEt);

                boolean insert = dbManager.InsertData(doctor);

                if(insert) {
                    Toast.makeText(MainActivity.this, "Records added successfully", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });



        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
    }
}
