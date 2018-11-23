package com.example.user.bitmmidprojecttest2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

}
