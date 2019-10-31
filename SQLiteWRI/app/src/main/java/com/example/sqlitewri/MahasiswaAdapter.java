package com.example.sqlitewri;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MahasiswaAdapter extends ArrayAdapter<Mahasiswa> {
    private int resource;
    Context context;
    public MahasiswaAdapter(Context context, int resource, ArrayList<Mahasiswa> listMahasiswa) {
        super(context, resource, listMahasiswa);

        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TextView text_nim;
        TextView text_name;
        TextView text_class;
        View v = convertView;
        final Mahasiswa mhs = getItem(position);
        final  DatabaseHelper databaseHelper;

        if (v == null) {
            v = LayoutInflater.from(context).inflate(resource, null);
        }

        if (v != null) {
            text_nim = v.findViewById(R.id.txtNIM);
            text_name = v.findViewById(R.id.txtNAME);
            text_class = v.findViewById(R.id.txtCLASS);
            databaseHelper = new DatabaseHelper(v.getContext());


            if (text_nim != null) {
                text_nim.setText(mhs.getNim());
            }
            if (text_name != null) {
                text_name.setText(mhs.getName());
            }4
            if (text_class != null) {
                text_class.setText(mhs.getKelas());
            }
            Button btnDelete = v.findViewById(R.id.buttonDelete);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SQLiteDatabase db = databaseHelper.getWritableDatabase();
                    String nim = text_nim.getText().toString();
                    String selection = databaseHelper.COLUMN_NIM + " LIKE ? ";
                    String[] selectionArgs = {nim};
                    db.delete(databaseHelper.TABLE_NAME, selection, selectionArgs);

                    Toast.makeText(v.getContext(), "Data Deleted", Toast.LENGTH_LONG).show();
                }
            });
        }
        return v;
    }
}
