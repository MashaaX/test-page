package com.example.sqlitewri;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListMahasiswa extends AppCompatActivity {
    ListView listMahasiswa;
    DatabaseHelper dbHelper;
    Mahasiswa  mhs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        listMahasiswa = findViewById(R.id.listMahasiswa);
        dbHelper = new DatabaseHelper(this);
        ArrayList<Mahasiswa> ArraylistMahasiswa = getAllData();

        MahasiswaAdapter adapter = new MahasiswaAdapter(this, R.layout.item, ArraylistMahasiswa);
        listMahasiswa.setAdapter(adapter);
    }

    public ArrayList<Mahasiswa> getAllData() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor data = dbHelper.getData();
        ArrayList<Mahasiswa> list = new ArrayList<>();

        data.moveToFirst();
        if (data.getCount()>0) {
            do {
                mhs = new Mahasiswa();
                mhs.setNim(data.getString(0));
                mhs.setName(data.getString(1));
                mhs.setKelas(data.getString(2));

                list.add(mhs);
                data.moveToNext();
            }while (!data.isAfterLast());
        }return list;
    }
}
