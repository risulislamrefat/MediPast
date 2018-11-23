package com.example.user.bitmmidprojecttest2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Statement;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "MyDb";
    private static final int DATABASE_VERSION = 10;
    public static final String TABLE_NAME = "UserInfo";
    public static final String MEDICAL_HISTORY_TABLE_NAME = "MedicalUserInfo";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DETAILS";
    public static final String COL_4 = "APPOINTMENT";
    public static final String COL_5 = "PHONE";
    public static final String COL_6 = "EMAIL";
    public static final String COL_7 = "Image";


    public DBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        //this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"("+COL_1+" Integer primary key autoincrement, "+COL_2+" text, " +
                ""+COL_3+" text, "+COL_4+" date, "+COL_5+" phone, "+COL_6+" textEmailAddress" +")");
        db.execSQL("create table "+MEDICAL_HISTORY_TABLE_NAME+"("+COL_1+" Integer primary key autoincrement, "+COL_2+" text, " +
                ""+COL_3+" text, "+COL_4+" date, "+COL_5+" phone, "+COL_6+" textEmailAddress, "+COL_7+" text  " +")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
