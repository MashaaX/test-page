package com.example.sqlitewri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Mahasiswa.db";
    private static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME = "TABLE_MAHASISWA";
    static final String COLUMN_NIM = "NIM";
    static final String COLUMN_NAME = "NAME";
    static final String COLUMN_CLASS = "CLASS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + " (NIM TEXT PRIMARY KEY, NAME TEXT, CLASS TEXT)";
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_TABLE = "DROP TABLE IF EXIST" + TABLE_NAME;
    }

    public boolean insertData (String nim, String name, String kelas) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NIM, nim);
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_CLASS, kelas);

        Long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = getWritableDatabase();

        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

}
