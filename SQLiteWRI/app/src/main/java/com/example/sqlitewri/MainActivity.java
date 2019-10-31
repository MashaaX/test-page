package com.example.sqlitewri;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText_NIM;
    EditText editText_Name;
    EditText editText_Class;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_NIM = findViewById(R.id.txtNIM);
        editText_Class = findViewById(R.id.txtClass);
        editText_Name = findViewById(R.id.txtName);

      databaseHelper = new DatabaseHelper(this);
    }

    public void btnVIEW(View view) {
        Intent viewIntent = new Intent(this, ListMahasiswa.class);
        startActivity(viewIntent);
    }

    public void btnADD(View view) {
        String nim = editText_NIM.getText().toString();
        String name = editText_Name.getText().toString();
        String kelas = editText_Class.getText().toString();

        boolean result = databaseHelper.insertData(nim, name, kelas);
        if (result) {
            Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Data not added", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnDELETE(View view) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String nim = editText_NIM.getText().toString();
        String selection = databaseHelper.COLUMN_NIM + " LIKE ? ";
        String[] selectionArgs = {nim};
        db.delete(databaseHelper.TABLE_NAME, selection, selectionArgs);
    }

    public void btnUPDATE(View view) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String nim = editText_NIM.getText().toString();
        String name = editText_Name.getText().toString();
        String kelas = editText_Class.getText().toString();

        cv.put(databaseHelper.COLUMN_NIM, nim);
        cv.put(databaseHelper.COLUMN_CLASS, kelas);
        cv.put(databaseHelper.COLUMN_NAME, name);

        String selection = databaseHelper.COLUMN_NIM + " LIKE ? ";
        String[] selectionArgs = {nim};
        db.update(databaseHelper.TABLE_NAME, cv, selection, selectionArgs);

        Toast.makeText(this, "Wes keupdate cok", Toast.LENGTH_LONG).show();
    }

    public void viewData(View view) {
        Intent viewIntent = new Intent(this, ListMahasiswa.class);
        startActivity(viewIntent);
    }


}
