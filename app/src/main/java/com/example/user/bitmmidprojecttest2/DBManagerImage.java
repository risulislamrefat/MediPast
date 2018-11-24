package com.example.user.bitmmidprojecttest2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.example.user.bitmmidprojecttest2.DBHelper.COL_2;
import static com.example.user.bitmmidprojecttest2.DBHelper.COL_3;
import static com.example.user.bitmmidprojecttest2.DBHelper.COL_4;
import static com.example.user.bitmmidprojecttest2.DBHelper.COL_5;
import static com.example.user.bitmmidprojecttest2.DBHelper.COL_6;

public class DBManagerImage {
    private Context context;
    public DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBManagerImage(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    public boolean insertData(History history) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.COL_2,history.getName());
        contentValues.put(DBHelper.COL_3,history.getDetails());
        contentValues.put(DBHelper.COL_4,history.getAppointment());
        contentValues.put(DBHelper.COL_5,history.getPhone());
        contentValues.put(DBHelper.COL_6,history.getEmail());
        contentValues.put(DBHelper.COL_7,history.getImage());

        long insertRow = db.insert(DBHelper.MEDICAL_HISTORY_TABLE_NAME,null,contentValues);
        if (insertRow>0) {

            return true;
        }
        else return false;

    }


    public ArrayList<History> getAllImages() {
        db = dbHelper.getReadableDatabase();
        ArrayList<History> imageList =  new ArrayList <>();
        String query = " select * from " + DBHelper.MEDICAL_HISTORY_TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_1));
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.COL_2));
                String details = cursor.getString(cursor.getColumnIndex(DBHelper.COL_3));
                String appointment = cursor.getString(cursor.getColumnIndex(DBHelper.COL_4));
                String phone = cursor.getString(cursor.getColumnIndex(DBHelper.COL_5));
                String email = cursor.getString(cursor.getColumnIndex(DBHelper.COL_6));
                String image = cursor.getString(cursor.getColumnIndex(DBHelper.COL_7));

                History history = new History(id,name,details,appointment,phone,email,image);
                imageList.add(history);
            }while (cursor.moveToNext());

        }
        db.close();
        return imageList;
    }

}
