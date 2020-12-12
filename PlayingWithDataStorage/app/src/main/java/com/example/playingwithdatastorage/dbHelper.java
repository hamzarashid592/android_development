package com.example.playingwithdatastorage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.zip.Inflater;

public class dbHelper extends SQLiteOpenHelper {


    Context context;
    private static final String DATABASE_NAME="Second_Database";
    static final String TABLE_NAME="TEST_1";
    static final String UID="UID";
    static final String NAME="NAME";
    static final String PASSWORD="PASSWORD";
    static final String CREATE_TABLE="create table "+TABLE_NAME+"("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAME+" VARCHAR(255),"+PASSWORD+" VARCHAR(255));";
    private static final Integer DATABASE_VERSION=8;



    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("hamza","onCreate of db called");


        try{
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e) {
            Log.d("hamza","onCreate exception"+e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d("hamza","onUpgrade of db called");

        try{
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
        } catch (SQLException e) {
            Log.d("hamza","onUpdate exception"+e);
        }


    }
}