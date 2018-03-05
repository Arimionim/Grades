package com.example.android.grades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    MyDatabaseHelper(Context context, final String DATABASE_NAME, final int DATABASE_VERSION)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating database with fields:
        db.execSQL("create table main ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "grade num" + ");")
        ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
