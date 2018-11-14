package com.example.user.bitmmidprojecttest2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.example.user.bitmmidprojecttest2.DBHelper.COL_1;
import static com.example.user.bitmmidprojecttest2.DBHelper.COL_2;
import static com.example.user.bitmmidprojecttest2.DBHelper.COL_3;
import static com.example.user.bitmmidprojecttest2.DBHelper.COL_4;
import static com.example.user.bitmmidprojecttest2.DBHelper.COL_5;
import static com.example.user.bitmmidprojecttest2.DBHelper.COL_6;
import static com.example.user.bitmmidprojecttest2.DBHelper.TABLE_NAME;

public class DBManager {
    private Context context;
    public DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    public boolean InsertData(Doctor doctor) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //Doctor doctor = new Doctor(COL_2,COL_3,COL_4,COL_5,COL_6);
        contentValues.put(DBHelper.COL_2,doctor.getName());
        contentValues.put(DBHelper.COL_3,doctor.getDetails());
        contentValues.put(DBHelper.COL_4,doctor.getAppointment());
        contentValues.put(DBHelper.COL_5,doctor.getPhone());
        contentValues.put(DBHelper.COL_6,doctor.getEmail());

       long insertRow = db.insert(DBHelper.TABLE_NAME,null,contentValues);
       if (insertRow>0) {
           //db.close();
           return true;
       }
       else return false;

    }


    public ArrayList<Doctor> getAllStudent() {
        db = dbHelper.getReadableDatabase();
        ArrayList<Doctor> doctorsList =  new ArrayList <>();
        String query = " select * from " + DBHelper.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COL_1));
                String name = cursor.getString(cursor.getColumnIndex(COL_2));
                String details = cursor.getString(cursor.getColumnIndex(COL_3));
                String appointment = cursor.getString(cursor.getColumnIndex(COL_4));
                String phone = cursor.getString(cursor.getColumnIndex(COL_5));
                String email = cursor.getString(cursor.getColumnIndex(COL_6));

                Doctor doctor = new Doctor(id, name, details, appointment, phone, email);
                doctorsList.add(doctor);
            }while (cursor.moveToNext());

            }
            db.close();
        return doctorsList;
        }


    }





































