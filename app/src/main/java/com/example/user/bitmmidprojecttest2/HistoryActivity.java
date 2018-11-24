package com.example.user.bitmmidprojecttest2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewStructure;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HistoryActivity extends AppCompatActivity {
    private EditText name,details,appointment,phone,email;
    private Button addButton,viewBtn;
    private ImageView cameraBtn,galleryBtn;
    private static final int REQUEST_CODE_FOR_CAMERA = 1;
    private static final int REQUEST_CODE_FOR_GALLARY = 2;
    public String imageEncode;
    private String imageFromCamera;
    private DBHelper dbHelper;
    private DBManagerImage dbManagerImage;
    Uri imageURI;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        cameraBtn = findViewById(R.id.cameraId);
        galleryBtn = findViewById(R.id.galleryId);
        name = findViewById(R.id.nameEt);
        details = findViewById(R.id.detailsEt);
        appointment = findViewById(R.id.appointmentEt);
        phone = findViewById(R.id.phoneEt);
        email = findViewById(R.id.emailEt);

        addButton = findViewById(R.id.addBtn);
       viewBtn = findViewById(R.id.viewBtn);
       DBHelper dbHelper = new DBHelper(this);
       final DBManagerImage dbManagerImage = new DBManagerImage(this);

       cameraBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               if (intent.resolveActivity(getPackageManager())!= null) {
                   startActivityForResult(intent,REQUEST_CODE_FOR_CAMERA);
               }
           }
       });

       galleryBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
               if (intent.resolveActivity(getPackageManager()) != null) {
                   startActivityForResult(intent,REQUEST_CODE_FOR_GALLARY);
               }
           }
       });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameEt = name.getText().toString();
                String detailsEt = details.getText().toString();
                String appointmentEt = appointment.getText().toString();
                String phoneEt = phone.getText().toString();
                String emailEt =  email.getText().toString();


                History history = new History(nameEt,detailsEt,appointmentEt,phoneEt,emailEt,imageFromCamera);
                boolean insert = dbManagerImage.insertData(history);
                if (insert) {
                    Toast.makeText(HistoryActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(HistoryActivity.this, "failed", Toast.LENGTH_SHORT).show();

            }
        });


       viewBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(HistoryActivity.this,RecyclerViewActivity.class);
               startActivity(intent);
           }
       });


        Intent intent = getIntent();





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_FOR_CAMERA && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            cameraBtn.setImageBitmap(bitmap);
            imageFromCamera = encodeImage(bitmap,Bitmap.CompressFormat.JPEG,70);


            //Bitmap getImage = decodeImage(imageFromCamera);

        }
        else if (requestCode == REQUEST_CODE_FOR_GALLARY && resultCode == RESULT_OK) {
            imageURI = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(imageURI);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageFromCamera = encodeImage(bitmap,Bitmap.CompressFormat.JPEG,70);
               galleryBtn.setImageURI(imageURI);

                //boolean insert = dbManagerImage.InsertData(history);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }







    }

    public static String encodeImage(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int quality) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, quality, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
    }


}
